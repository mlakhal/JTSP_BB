/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GrafVisualization;
import javax.swing.*;
import java.awt.*;
/**
 * tworzy canve tu nie ma nic ciekawego do zmieniania
 * @author Dorota
 */
public class Canvas1 extends JApplet {
  JLabel Title;
  Canva DrawingArea;
  public Canvas1 (int n,Integer tab[][]) {
    Container Pane;

    Pane = getContentPane();
    Title = new JLabel ("The JLabel is in the SOUTH area");
    DrawingArea = new Canva(n,tab);
Pane.add (DrawingArea, BorderLayout.CENTER);

}
}