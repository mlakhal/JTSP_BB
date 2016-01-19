package Algorithm;

import edu.uci.ics.jung.graph.*;
import java.util.*;
import GrafVisualization.*;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.7B791AD3-C503-B12A-7E83-B53FCB270ABD]
// </editor-fold>


public class Solver {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8A6DF046-5FC7-EA1E-4FF4-3F050ADD01D4]
    // </editor-fold> 
    private Costs root;
    private static final int INF=100000000;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C1E7AE27-A76C-E768-4E77-FD363CEBCC94]
    // </editor-fold> 
    private Costs leftChild;
    private Costs minLeaf;
    boolean newMinLeaf=false;
    public Graf treeVisualization;
    Costs rootNiezmienialny;
    int id=1;
    int ileKrokow=0;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3042A9A7-FDFE-5E68-5152-3AFC6E761C5E]
    // </editor-fold> 
    private Costs rightChild;
    private DirectedGraph<Costs,Integer>g; 
    public DelegateTree tree; 
    public Costs answer;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E00E93BC-F2F5-204E-DAF9-148AB083C5B1]
    // </editor-fold>


    public Solver(int n, Integer tab[][])
    {
        root=new Costs(n);
        rootNiezmienialny=new Costs(n);
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                if(i!=j)
                {
                    root.setDistances(i, j, tab[i][j]);
                    rootNiezmienialny.setDistances(i, j, tab[i][j]);
                }
        g = new DirectedSparseGraph();
        tree=new DelegateTree(g);
        boolean ok=tree.addVertex(root);
        //do v3
     

    }

    public Solver (Costs root)
    {
        g = new DirectedSparseGraph();
        tree=new DelegateTree(g);        
        boolean ok=tree.addVertex(root);
    }


    public int branchAndBound ()
    {
        int edgeCounter=0;
        root =(Costs)tree.getRoot();
        int size=root.getSize();
        root.setLowerBoundAndReduce(0); 
        int min=INF;
        int counter=0;

        while(counter<15 && root.getLowerBound()<min)
        {
            size=root.getSize();
            while(size>2)  
            {

                ++ileKrokow;
                root.setLowerBoundAndReduce(root.getLowerBound()); 
                root.setEdgeToBranch(); 
                Edge branchEdge=root.getEdgeToBranch();
                
                leftChild = new Costs(root.getSize()-1,root,branchEdge,true);
                leftChild.setLowerBoundAndReduce(root.getLowerBound());
                leftChild.lewy=1;
                rightChild=new Costs(root.getSize(),root,branchEdge,false);
                rightChild.setLowerBoundAndReduce(root.getLowerBound());
                rightChild.lewy=0;
                boolean ok;

                ok=tree.addChild(edgeCounter,root, leftChild);
                edgeCounter++;
                ok=tree.addChild(edgeCounter, root,rightChild);
                edgeCounter++;

                root=leftChild;
                --size;
            }
        
            if(counter==0) 
                answer=root;
            if(root.getLowerBound()<answer.getLowerBound()) 
                answer=root;
                comPath();
            min=root.getLowerBound();
            newMinLeaf=false;
            chooseNext((Costs)tree.getRoot(),root.getLowerBound()); 
            
            if(newMinLeaf==true)
                root=minLeaf; 
            else
                break;
            ++counter;
        }
      comPath();
        return ileKrokow;
    }


    public void branchAndBound2 (int ileIteracji,int max)
       {
           g=null;
           tree=null;
           g = new DirectedSparseGraph();
           tree=new DelegateTree(g);
           root=rootNiezmienialny;
           boolean dziala=tree.addVertex(root);
           int edgeCounter=0;
           root =(Costs)tree.getRoot();
           int size=root.getSize();
           root.setLowerBoundAndReduce(root.getLowerBound());
           int min=INF;
           int counter=0;
           int iteracje=0;

            while(counter<15 && root.getLowerBound()<min)
            {
                size=root.getSize();

                while(size>2 && iteracje<ileIteracji) 
                {
                    iteracje++;
                    ++ileKrokow;
                   root.setLowerBoundAndReduce(root.getLowerBound()); 

                    root.setEdgeToBranch();
                    Edge branchEdge=root.getEdgeToBranch();

                    leftChild = new Costs(root.getSize()-1,root,branchEdge,true);
                    leftChild.setLowerBoundAndReduce(root.getLowerBound());
                    leftChild.lewy=1;
                    rightChild=new Costs(root.getSize(),root,branchEdge,false);
                    rightChild.setLowerBoundAndReduce(root.getLowerBound());
                    rightChild.lewy=0;
                    boolean ok;

                    ok=tree.addChild(edgeCounter,root, leftChild);
                    edgeCounter++;
                    ok=tree.addChild(edgeCounter, root,rightChild);
                    edgeCounter++;

                    root=leftChild;

                    --size;
                    
               }
             if(counter==0) 
                 answer=root;
             if(root.getLowerBound()<answer.getLowerBound()) 
                 answer=root;
             if(answer.getSize()<=2 && iteracje<ileIteracji)
                {
                        comPath();
                }
             min=root.getLowerBound();
             newMinLeaf=false;
             chooseNext((Costs)tree.getRoot(),root.getLowerBound());

             if(newMinLeaf==true)
             {
                 root=minLeaf;
             }
             else
                  break;
             ++counter;
             }
        }


    public void chooseNext(Costs root,int oldLB)
    {
          Collection<Costs>children=new ArrayList<Costs>();
          children=tree.getChildren(root);
          int min=oldLB;
                for(Iterator<Costs> it=children.iterator(); it.hasNext();)
                {
                    Costs child=it.next();
                    if(child.getLowerBound()<min)
                    {
                    if(tree.isLeaf(child)==true)
                    {
                            min=child.getLowerBound();
                            minLeaf=child;
                            newMinLeaf=true;
                    }
                    else
                        chooseNext(child,oldLB);
                    }
                }
    }

    public void showTree(Costs root, Vertex parent)
    {
        Collection<Costs>children=new ArrayList<Costs>();
        children=tree.getChildren(root);
        for(Iterator<Costs> it=children.iterator(); it.hasNext();)
        {
            Costs child=it.next();

            Vertex a=new Vertex(child.getDistances(),child.getArraySize(),child.getLowerBound(),child.lewy);
            child.setDescription();
            child.setDescription2();
            a.setDescription(child.getDescription());
            a.setDescription2(child.getDescription2());
            treeVisualization.gv.addVertex(a);
            if(parent!=null)
            {
                treeVisualization.gv.addEdge(id, parent, a);
                ++id;
            }
            showTree(child,a);
        }
         
    }

    public JPanel createTreeVisualization()
    {
        treeVisualization=new Graf();
        treeVisualization.init();
        Costs r=(Costs)tree.getRoot();
        Vertex a=new Vertex(r.getDistances(),r.getArraySize(),r.getLowerBound(),r.lewy);
        r.setDescription();
        r.setDescription2();
        String desc=r.getDescription();
        String desc2=r.getDescription2();
        a.setDescription(desc);
        a.setDescription2(desc2);
        treeVisualization.gv.addVertex(a);
        showTree(r,a);

        JPanel tmpPanel = new javax.swing.JPanel();
        tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.PAGE_AXIS));
        tmpPanel.add(treeVisualization.drawGraf());
        tmpPanel.add(Box.createRigidArea(new Dimension(0,5)));
        return tmpPanel;
        /*************************/

    }
    public void comPath()
    {
        System.out.println("ble");
       /* for(int i=0; i<answer.getArraySize();++i)
        {
            for(int j=0;j<answer.getArraySize(); ++j)
            {
                System.out.print(answer.getDistances()[i][j]+" ");
            }
            System.out.println();
        }*/
      //  System.out.println(answer.getArraySize());
        Edge edges[]=new Edge[4];
        int index=0;


        for(int i=0; i<answer.getArraySize();++i)
            for(int j=0; j<answer.getArraySize();++j)
            {
                if( answer.getDistances()[i][j]!=-1 && answer.getDistances()[i][j]!=INF)
                {
                    Edge e=new Edge(i,j);
                    edges[index]=e;
                    ++index;
                }
            }


        int index1,index2;


    //    answer.printPath();
        
        for(int i=0; i<index; ++i)
            for(int j=0; j<index; ++j)
            {
                if(i!=j)
                {
                Edge toTake1=edges[i];
                Edge toTake2=edges[j];

                index1=answer.findIndexInPath(toTake1);
              //  if(index1!=-1)
                  answer.getPath().add(index1, toTake1);
                index2=answer.findIndexInPath(toTake2);
              // if(index2!=-1)
                    answer.getPath().add(index2, toTake2);
                if(answer.pathOk()==true)
                {
                    return;
                }
                else
                {
                    answer.getPath().remove(index2);
                    answer.getPath().remove(index1);
                }
                }
            }
    }


   public String printAnswer3()
    {
        answer.setDescription2();
        return answer.getDescription2();

    }

    public String printAnswer2()
    {

        answer.setDescription();
        return answer.getDescription();

    }

    public int getIleKrokow()
    {

        return ileKrokow;
    }


    public Integer[][] getDistances () {
        return answer.getDistances();
    }


    public int getSize () {
        return answer.getArraySize();
    }

}