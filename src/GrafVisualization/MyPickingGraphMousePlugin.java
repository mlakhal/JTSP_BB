/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GrafVisualization;
import java.lang.Object.*;
import edu.uci.ics.jung.visualization.control.*;
import java.awt.geom.*;
import java.awt.Component.*;
import java.awt.event.*;
import java.util.*;

/**
 * tez chyba niewazne - nieuzywane  ale lepiej nie kasowac  -
 * do klikanai w wierzcholki grafu
 * @author Dorota
 */
public class MyPickingGraphMousePlugin<Object,Integer> extends PickingGraphMousePlugin {

//public ArrayList<Vertex>vertexes;
public ArrayList<VertexLocalization>vertexes;
public Vertex vertex1;
public MyPickingGraphMousePlugin()
{
    vertexes=new ArrayList<VertexLocalization>();
}
public void set(Vertex v, Point2D vPlacement)
{
   VertexLocalization a=new VertexLocalization(v.getDistances(), v.getDistancesSize(), v.getLowerBound(), vPlacement);
   vertexes.add(a);
}

@Override
   public  void mouseClicked(MouseEvent e)
{
 
}

}