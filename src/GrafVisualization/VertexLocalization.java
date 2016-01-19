/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GrafVisualization;
import java.awt.geom.*;

/**
 *
 * @author Dorota
 */
public class VertexLocalization {

    private Integer [][]distances;
    private int lowerBound;
    private Point2D localization;
    public VertexLocalization(Integer[][]tab,int tabSize,int lb,Point2D local)
    {
        distances=new Integer[tabSize][];
        for(int i=0; i<tabSize; ++i)
            distances[i]=new Integer[tabSize];

        for(int i=0; i<tabSize; ++i)
            for(int j=0; j<tabSize; ++j)
                distances[i][j]=tab[i][j];
        lowerBound=lb;
        localization=new Point2D.Double();
        localization.setLocation(local);
    }
    public Point2D getLocalization()
    {
        return localization;
    }
    public int getLowerBound()
    {
        return lowerBound;
    }

}