/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GrafVisualization;
import java.awt.geom.*;


public class Vertex{
    int id;
    private String description;
    private String description2;
    private Point2D placement;
    Integer [][]distances;
    int lowerBound;
    int distancesSize;
    public int lewy;
    public Vertex(Integer[][]tab,int tabSize, int lb, int l)
    {
        distancesSize=tabSize;
        distances=new Integer[tabSize][];
        for(int i=0; i<tabSize; ++i)
            distances[i]=new Integer[tabSize];

        for(int i=0; i<tabSize; ++i)
            for(int j=0; j<tabSize; ++j)
                distances[i][j]=tab[i][j];
        lowerBound=lb;
        lewy=l;

    }
    public Integer[][]getDistances()
    {
        return distances;
    }
    public int getLowerBound()
    {
        return lowerBound;
    }
    public int getDistancesSize()
    {
        return distancesSize;
    }
    public void setPlacement(int x, int y)
    {
        placement=new Point2D.Double(x, y);
    }
    public Point2D getPlacement()
    {
        return placement;
    }

    public void setDescription(String a)
    {
        description=a;
    }

    public void setDescription2(String a)
    {
        description2=a;
    }
    public String getDescription()
    {
        return description;
    }
    public String getDescription2()
    {
        return description2;
    }
    @Override
    public String toString()
    {
        return description;
    }
   public int getId()
   {
       return id;
   }
   public void setId(int i)
   {
       id=i;
   }


}