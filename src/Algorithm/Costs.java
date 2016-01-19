	
package Algorithm;
import java.util.*;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B1E29A5E-B0C9-DE82-5C7F-2D9407852545]
// </editor-fold> 
public class Costs {

    // ATRIBUTES:
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C98302E3-1152-F130-A844-F3457B1473A9]
    // </editor-fold>
    private Integer[][] distances;
    public Integer[]rzedy;
    public Integer[]kolumny;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F91F661B-AEC4-C8C7-027A-C4ED2B889438]
    // </editor-fold>
    private int size;
    private int arraySize;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C3C6D90E-B87F-7E39-7894-2F867EA58A96]
    // </editor-fold> 
    private int lowerBound;
    public int lewy;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9794A3B4-71FF-E157-7A13-C7773A3FFE63]
    // </editor-fold>
  
    private ArrayList<Edge> path;


    private ArrayList<Edge> noPath;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5275A5C1-0E3C-ED28-030E-DC9E857A5296]
    // </editor-fold> 
    private String description;

    private String description2;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6C270CB1-6125-0FDB-19FA-3EE73D07CEAA]
    // </editor-fold> 
    private Edge edgeToBranch;
    
    private static final int INF=100000000;
/////////////////////////////////////////////////
// METHODS:
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E6C135C1-B775-4307-DEDF-6D4DDD33738D]
    // </editor-fold>
   
    public Costs (int n) {
        path=new ArrayList<Edge>();
        noPath=new ArrayList<Edge>();
        size=n;
        arraySize=n;
        distances=new Integer[arraySize][];
        for(int i=0; i<arraySize; ++i)
        {
            distances[i]=new Integer[arraySize];
        }
        for(int i=0; i<arraySize; ++i)
            for(int j=0; j<n; ++j)
            distances[i][j]=INF;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B06BF4CD-4CF5-1A0B-E39E-9EF2A0EBD370]
    // </editor-fold>


public Costs (int n, Costs parent, Edge e, boolean take) {
        
        path=new ArrayList<Edge>();
        noPath=new ArrayList<Edge>();
        ArrayList<Edge> parentPath=parent.getPath();
        ArrayList<Edge> parentNoPath=parent.getNoPath();
        for(Iterator<Edge>it=parentPath.iterator(); it.hasNext();)
        {
            Edge val=it.next();
            path.add(val);

        } 
        for(Iterator<Edge>it=parentNoPath.iterator(); it.hasNext();)
        {
            Edge val=it.next();
            noPath.add(val);

        }

        size=n; 
        arraySize=parent.getArraySize();
        distances=new Integer[arraySize][];
        for(int i=0; i<arraySize; ++i)
        {
            distances[i]=new Integer[arraySize];
        }
        for(int i=0; i<arraySize; ++i)
            for(int j=0; j<arraySize; ++j)
                distances[i][j]=parent.getDistances()[i][j];
        int f=e.getFrom();
        int t=e.getTo();
        
        if(f<arraySize && t<arraySize)
        {
            if(take==true) 
            {
                if(path.isEmpty()) 
                {
                    path.add(e);
            
                }
            
            else
            {
                int index=0;
                boolean done=false;
                for(Iterator<Edge> it= path.iterator(); it.hasNext();) 
                {
                   
                    Edge a=it.next(); 
                    
                    if(a.getTo()==f) 
                    {
                        path.add(index+1,e);
                        done=true; 
                        break;
                    }
                    if(a.getFrom()==t) 
                    {
                        path.add(index,e);
                        done=true;
                        break;
                    }
                    ++index;
               }
               if(done==false) 
                   path.add(e);
           }
         
            for(int i=0; i<arraySize; ++i)
            {
                distances[f][i]=-1;
                distances[i][t]=-1;
            }
           blokujPetle(); 
        }        
        else
        {
            if(noPath.isEmpty()) 
                {
                    noPath.add(e);

                }

            else
            {
                int index=0;
                boolean done=false;
                for(Iterator<Edge> it= noPath.iterator(); it.hasNext();) 
                {

                    Edge a=it.next(); 

                    if(a.getTo()==f)
                    {
                        noPath.add(index+1,e);
                        done=true; 
                        break;
                    }
                    if(a.getFrom()==t) 
                    {
                        noPath.add(index,e);
                        done=true;
                        break;
                    }
                    ++index;
               }
               if(done==false) 
                   noPath.add(e);
           }
           distances[f][t]=INF;
        }
     }
       
 }

    
    private void blokujPetle()
    {

        Iterator<Edge> it=path.iterator();
        Edge start=it.next();
        Edge stop=start;
        int prev=start.getTo();
        while(it.hasNext())
        {
            Edge e=it.next();
            if(prev!=e.getFrom())
            {
                //dodany if
                if(distances[stop.getTo()][start.getFrom()]!=-1)
                {
                distances[stop.getTo()][start.getFrom()]=INF; 
                start=e;
                stop=e;
                prev=start.getTo();
                }
            }
            else
            {
                stop=e;
                prev=e.getTo();
            }
            
        }
    
        if(distances[stop.getTo()][start.getFrom()]!=-1)
            distances[stop.getTo()][start.getFrom()]=INF;

    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3F4B4058-332A-95F5-044F-4891723043EF]
    // </editor-fold> 
    public String getDescription () {
        return description;
    }

    public String getDescription2 () {
        return description2;
    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E86A8C45-4692-08F7-C201-67F546E3BCDE]
    // </editor-fold>

    public void setDescription ()
    {
        description="";
        if (!path.isEmpty())
        {
            description+="z: ";
            for(int i=0; i<path.size(); ++i)
            {
                Edge e=path.get(i);
                description+="(";
                description+=e.getFrom()+1;
                description+="-";
                description+=e.getTo()+1;
                description+=") ";
            }
        }
    }
    public void setDescription2 ()
    {
        description2="";
        if (!noPath.isEmpty())
        {
            description2+="bez: ";
            for(int i=0; i<noPath.size(); ++i)
            {
                Edge e=noPath.get(i);
                description2+="(";
                description2+=e.getFrom()+1;
                description2+="-";
                description2+=e.getTo()+1;
                description2+=") ";
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A86B808A-99D3-C47E-09E5-AA6130EFD29A]
    // </editor-fold> 
    public Integer[][] getDistances () {
        return distances;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.ACCA8629-200C-821C-7C1F-C9C09A44971A]
    // </editor-fold> 
    public void setDistances (int i, int j, int k)
    {
        if (i< size)
            if(j<size)
                distances[i][j] = k;
    }
  
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B41B1FF7-A0B4-FF0D-EC1F-FF846CD47B13]
    // </editor-fold> 
    public int getLowerBound () {
        return lowerBound;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D74975C4-6175-82C6-AEC5-8021D778CB01]
    // </editor-fold>
    
    public void setLowerBoundAndReduce (int oldLowerBound) {
        int lb=oldLowerBound;
        
        for(int i=0; i<arraySize; ++i)
        {
            int minPoziom=INF;

            for(int j=0; j<arraySize; ++j)
            {
                if(distances[i][j]!=-1 && distances[i][j]<minPoziom)
                    minPoziom=distances[i][j];
            }
            
            for(int j=0; j<arraySize; ++j)
            {
                if(distances[i][j]!=INF && distances[i][j]!=-1)
                    distances[i][j]-=minPoziom;
            }
            if(minPoziom!=INF)
            lb+=minPoziom; 
        }

        for(int i=0; i<arraySize; ++i)
        {
            int minPion=INF;
            for(int j=0; j<arraySize; ++j)
            {
                if(distances[j][i]!=-1 && distances[j][i]<minPion)
                    minPion=distances[j][i];
            }

            for(int j=0; j<arraySize; ++j)
            {
                if(distances[j][i]!=INF &&distances[j][i]!=-1)
                distances[j][i]-=minPion;
            }
            if(minPion!=INF)
            lb+=minPion; 
        }
        lowerBound=lb;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1265C963-939B-377D-3732-05384D0E7A5E]
    // </editor-fold> 
    public ArrayList<Edge> getPath () {
        return path;
    }

    public ArrayList<Edge> getNoPath () {
        return noPath;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.51DD69AC-26BB-EB64-8462-AD56CCC6E583]
    // </editor-fold> 
    public int getSize () {
        return size;
    }

    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.45480FBC-5F06-C21A-2CF3-9E0EB3BDD036]
    // </editor-fold> 
    public Edge getEdgeToBranch () {
        return edgeToBranch;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.46E659CB-98C7-9557-1B64-452BB8831131]
    // </editor-fold>

    public void setEdgeToBranch () {
       int maxGrowth=0;
       for(int i=0; i<arraySize; ++i)
       {
           for(int j=0; j<arraySize; ++j)
           {

               if(distances[i][j]==0) 
               {
                   int growth=0, min=INF;
                   //wybranie min dla wiersza
                    for(int k=0; k<arraySize; ++k)
                    {
                        if(k!=j && distances[i][k]<min && distances[i][k]!=-1)
                            min=distances[i][k];
                    }
                   growth+=min;
              
                   min=INF;
                   //wybranie mina dla kolumny
                   for(int k=0; k<arraySize; ++k)
                   {
                       if(k!=i && distances[k][j]<min && distances[k][j]!=-1)
                           min=distances[k][j];
                   }
                   growth+=min; // przyrost dla tego luku
                   if(growth>maxGrowth) //wybor max przyrostu
                   {
                       maxGrowth=growth;
                       Edge a=new Edge(i,j);
                       edgeToBranch=a;
                   }
               }
           }
       }
    }
    
public int getArraySize()
{
   return arraySize;
}

public int findIndexInPath(Edge toPut)
{
    int index=1;
    int indexToReturn=path.size();
    boolean found=false;
    
   /* System. out.println(path.toString());
    System.out.print(toPut.getFrom()+" ");
        System.out.print(toPut.getTo());
      System.out.println();*/
    for(Iterator<Edge>it=path.iterator(); it.hasNext();)
    {
       Edge e=it.next();
       if(e==toPut)
       {
           return -1;
       }
    }

    for(Iterator<Edge>it=path.iterator();it.hasNext();)
    {
        Edge e=it.next();
    /*    System.out.print(toPut.getFrom()+" ");
         System.out.print(toPut.getTo());
         System.out.println();*/
        if(e.getTo()==toPut.getFrom())
        {
            indexToReturn = index;
            found=true;
        }
        index++;
    }
    if(found==false)
    {
    index=0;
        for(Iterator<Edge>it=path.iterator();it.hasNext();)
        {
        Edge e=it.next();
        if(e.getFrom()==toPut.getTo())
        {
            indexToReturn = index;
        }
        index++;
        }
    }
    return indexToReturn;
}


public boolean pathOk()
{
    if(path.get(0).getFrom()!=path.get(path.size()-1).getTo())
    {
        return false;
    }
    for(int i=0; i<path.size()-1; ++i)
    {
        if(path.get(i).getTo()!=path.get(i+1).getFrom())
            return false;
    }
    return true;

}
public  void zerujSciezke()
{
    path.clear();
}
public void printPath()
{
        for(Iterator<Edge>it=path.iterator();it.hasNext();)
        {
        Edge e=it.next();
        System.out. print("( "+e.getFrom()+","+e.getTo()+")");
        }
        System.out.println();

}
}