package GrafVisualization;

import java.lang.Object.*;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.visualization.*;
import edu.uci.ics.jung.visualization.control.*;
import edu.uci.ics.jung.visualization.decorators.*;
//import org.apache.commons.collections15.*;
//import java.awt.Dimension;
import java.awt.Dimension;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;


public class Graf
{
    public DirectedSparseMultigraph<Vertex,Integer>gv;
       public Layout<Vertex,Integer>layout; 
    public VisualizationViewer<Vertex,Integer>vv;
    private MyPickingGraphMousePlugin<Vertex,Integer> mouse;
    int vertexId=0;
    int vertexCounter=0;

    public Vertex findRoot()
    {
        Collection<Vertex>vertexes=new ArrayList<Vertex>();
        vertexes=gv.getVertices();
        Vertex root=null;
        for(Iterator<Vertex>it=vertexes.iterator(); it.hasNext();)
        {
            Vertex a=it.next();
            if(gv.degree(a)==2)
                root=a;
        }
        return root;
    }
    public void init()
    {
        gv=new DirectedSparseMultigraph<Vertex,Integer>();
    }



    private void setVertexPlacement(Vertex parent, Point2D parentPlacement, double wsp)//, int numer)
    {
       // System.out.println(vertexId);
        Collection<Vertex>children=new ArrayList<Vertex>();
        ArrayList<Vertex>childrenList=new ArrayList<Vertex>();

        //zwraca nastepników w dowolnej kolejnosci dlatego w drzewie w dowonej kolejnosci
        //trzeba je przesorotwac z mniejszym lb pierwsze zrobie to jutro
        children=gv.getSuccessors(parent);
        for(Iterator<Vertex>its=children.iterator();its.hasNext();)
        {
            Vertex el=its.next();
            childrenList.add(el);
        }
        //jezeli peirwsze dziecko ma mniejsze lb to usuwamy i wrzucamy na 
        // koniec w przeciwnym wypadku nicn ie robimy
        Iterator <Vertex>its=childrenList.iterator();
        if(its.hasNext())
        {
            Vertex child1=its.next(); 
            Vertex child2=its.next();
            if(child1.lewy==0 && child2.lewy==1)
            {
                Vertex ble=childrenList.remove(0);
                childrenList.add(0, child2);
                childrenList.add(1,ble);
            }
        }
        mouse.set(parent, parentPlacement);
        int childrenNotLeaf=0;
        int childrenCounter=0;
        double x,y;
        for(Iterator<Vertex>it=childrenList.iterator();it.hasNext();)
        {
            Vertex child=it.next();
            if(gv.getSuccessorCount(child)!=0)
            {
                childrenNotLeaf++;
            }
        }
      /*  String olddesc=parent.getDescription();
        String olddesc2=parent.getDescription2();
        String newdesc=Integer.toString(numer)+". "+olddesc+"\r\n "+olddesc2;
        parent.setDescription(newdesc);
        vertexId++;*/
        for(Iterator<Vertex>it=childrenList.iterator();it.hasNext();)
        {
            Vertex child=it.next();
            y=parentPlacement.getY()+50;
  
            if(childrenCounter%2==0)
                x=parentPlacement.getX()-wsp*150;
            else
                x=parentPlacement.getX()+wsp*150;


            Point2D placement=new Point2D.Double(x, y);
            layout.setLocation(child, placement);

            if(childrenNotLeaf>1)
                setVertexPlacement(child,placement,0.5*wsp);//,vertexId);
            else if(childrenNotLeaf==1)
                setVertexPlacement(child,placement,wsp);//,vertexId);
            else;
            childrenCounter++;
         //   vertexId++;
        }

    }


    public void setId(Vertex root)
    {
      /*  root.setId(vertexId);
        ++vertexId;
        String olddesc=root.getDescription();
        String olddesc2=root.getDescription2();
        String newdesc=Integer.toString(root.getId())+". "+olddesc+"\r\n "+olddesc2;
        root.setDescription(newdesc);*/
        Collection<Vertex>children=new ArrayList<Vertex>();
         Queue <Vertex>kolejka=new LinkedList<Vertex>();
         kolejka.add(root);
         while(kolejka.isEmpty()==false)
         {
          
        Vertex parent=kolejka.poll();
       parent.setId(vertexId);
        ++vertexId;
        String olddesc=parent.getDescription();
        String olddesc2=parent.getDescription2();
        String newdesc=Integer.toString(parent.getId())+". "+olddesc+"\r\n"+olddesc2;
        parent.setDescription(newdesc);
        children=gv.getSuccessors(parent);
        Iterator<Vertex>it=children.iterator();
        if(children.size()==2)
        {
            Vertex child1=it.next();
            Vertex child2=it.next();
            if(child1.lewy==1 && child2.lewy==0)
            {
                kolejka.add(child1);
                kolejka.add(child2);
            }
            else
            {
                kolejka.add(child2);
                kolejka.add(child1);
            }
        }
        else if(children.size()==1)
        {
            Vertex child=it.next();
            kolejka.add(child);        
        }
        else;
         }

     /*   for(Iterator<Vertex>it=children.iterator();it.hasNext();)
        {
            Vertex child=it.next();
            
            setId(child);
            ++childCounter;

        }*/



    }
 
    public VisualizationViewer drawGraf()
    {
        vertexId=0;
        layout= new CircleLayout(gv);
        vv = new VisualizationViewer<Vertex,Integer>(layout);
        vv.setPreferredSize(new Dimension(800,500));
        Vertex root=findRoot();
        MyGraphMouseListener mouseListener=new MyGraphMouseListener();
        vv.addGraphMouseListener(mouseListener);
        Point2D rootPlacement=new Point2D.Double(500.0,50.0);
        mouse=new MyPickingGraphMousePlugin<Vertex,Integer>();
        layout.setLocation(root, rootPlacement);
        setVertexPlacement(root,rootPlacement,2);//,vertexId);
       setId(root);
        vertexCounter=vertexId;
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        PluggableGraphMouse gm=new PluggableGraphMouse();
        gm.add(new TranslatingGraphMousePlugin(MouseEvent.BUTTON1_MASK));
        gm.add(new ScalingGraphMousePlugin(new CrossoverScalingControl(), 0, 1.1f, 0.9f));
        vv.setGraphMouse(gm);
        gm.add(mouse);
        MouseEvent e=new MouseEvent(vv, 0, 1,1, 0, 0, 0, true);

        mouse.mouseClicked(e);
        return vv;
    }

}
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.F1A8FC4E-4E6F-8B9B-511D-A4349D12269B]
// </editor-fold>