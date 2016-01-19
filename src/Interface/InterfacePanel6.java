
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Algorithm.Solver;
import GrafVisualization.Vertex;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.io.*;



public class InterfacePanel6 extends javax.swing.JFrame
{

    private Integer[][] koszty;


    private static final int INF=100000000;


    int ilosc;


    private int tryb;


    Solver rozw;


    int iteracje;


    int ktoraIteracja = 1;
    Integer lb;


    JPanel calyPanel = new javax.swing.JPanel();
    JPanel prawyPanel = new javax.swing.JPanel();
    JPanel lewyPanel = new javax.swing.JPanel();
    JButton nastepny = new javax.swing.JButton();
    JButton poprzedni = new javax.swing.JButton();
    JScrollPane prawyScrollPane;

        String wypis1; //D
        String wypis2; //D

    public InterfacePanel6(int t, int i, Integer[][] k) throws IOException
    {
        initComponents();
        tryb = t;
        ilosc = i;
        koszty = new Integer[ilosc][];
        for (int j = 0; j<ilosc; j++)
        {
           koszty[j] = new Integer[ilosc];
        }
                for (int j = 0; j<ilosc; j++)
            for(int l = 0; l<ilosc; l++)
                koszty[j][l] = k[j][l];
        rozw = new Solver(ilosc,koszty);
        iteracje = rozw.branchAndBound()+1;

                wypis1=rozw.printAnswer2(); 
                wypis2=rozw.printAnswer3(); 
       lb=rozw.answer.getLowerBound();

        ustawParametry();

        wypiszWynik();
    }


    private void initComponents()
    {
        nastepny.setText("suivant");
        nastepny.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ktoraIteracja++;

                                rozw.branchAndBound2(ktoraIteracja,iteracje); 
                calyPanel.remove(2);
                calyPanel.add(new JScrollPane(nowyPrawyPanel()));
                calyPanel.repaint();
                calyPanel.validate();
            }
        });

        poprzedni.setText("Poprzedni");
        poprzedni.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ktoraIteracja--;

                                 rozw.branchAndBound2(ktoraIteracja,iteracje);
                calyPanel.remove(2);
                calyPanel.add(new JScrollPane(nowyPrawyPanel()));
                calyPanel.repaint();
                calyPanel.validate();
            }
        });
    }


    private void ustawParametry()
    {
        Dimension wymiary;
        if (tryb == 1)
        {
            wymiary = new Dimension(500, 400);
        }
        else
        {
            calyPanel.setLayout(new BoxLayout(calyPanel, BoxLayout.LINE_AXIS));
            wymiary = new Dimension(1180, 800);
        }
        this.setPreferredSize(wymiary);

    }


    public void saveCosts() throws IOException
    {
        try
        {
        FileWriter fw=new FileWriter("wynik.txt");
        fw.write("Pour une matrice de coût donné:\r\n\r\n");
        for(int i=0; i<ilosc; ++i)
        {
            String linia=new String();
            for(int j=0; j<ilosc; ++j)
            {
                if(i!=j)
                 linia+=koszty[i][j];
                else
                    linia+="inf";
                linia+=" ";
            }
            linia+="\r\n";
            fw.write(linia);

        }
        fw.write("\r\n");
        fw.write("Le plus court chemin est:\r\n\r\n");
        String sciezka=wypis1+wypis2;
        fw.write(sciezka);

        fw.close();
        }catch(IOException e){System.out.println("vous ne pouvez pas écrire sur le fichier");}
    }


    private JPanel wypiszKoszty(int ilosc, Integer[][] koszty)
    {
        JPanel tmpPanel = new javax.swing.JPanel();
        tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.LINE_AXIS));

            for (int i = 0; i<=ilosc; i++)
            {
                JPanel NewColumn = new javax.swing.JPanel();
                NewColumn.setLayout(new BoxLayout(NewColumn, BoxLayout.PAGE_AXIS));
                for (int j= 0; j<=ilosc; j++)
                {
                    if ((i==0)&&(j!=0))
                    {
                        NewColumn.add(new javax.swing.JLabel(String.valueOf(j)));
                        NewColumn.add(Box.createRigidArea(new Dimension(20,0)));
                    }
                    else if ((i!=0)&&(j==0))
                    {
                        NewColumn.add(new javax.swing.JLabel(String.valueOf(i)));
                        NewColumn.add(Box.createRigidArea(new Dimension(0,20)));
                    }
                    else if ((i!=0)&&(j!=0))
                    {
                        if((koszty[j-1][i-1]<INF))
                        {
                            if (koszty[j-1][i-1]<0)
                                NewColumn.add(new javax.swing.JLabel(" "));
                            else
                                NewColumn.add(new javax.swing.JLabel(String.valueOf(koszty[j-1][i-1])));
                        }
                        else
                        {
                            if( (koszty[j-1][i-1]==INF)) // D
                            NewColumn.add(new javax.swing.JLabel(Character.toString((char)8734)));
                        }
                        NewColumn.add(Box.createRigidArea(new Dimension(10,0)));
                    }
                    else
                    {
                        NewColumn.add(new javax.swing.JLabel(" "));
                        NewColumn.add(Box.createRigidArea(new Dimension(20,20)));
                    }

                }
                tmpPanel.add(NewColumn);
                tmpPanel.add(Box.createRigidArea(new Dimension(10,0)));

            }
        return tmpPanel;
    }




    private void wypiszWynik()
    {
        lewyPanel.setLayout(new BoxLayout(lewyPanel, BoxLayout.PAGE_AXIS));

        JPanel Row1 = new javax.swing.JPanel();
        Row1.setLayout(new BoxLayout(Row1, BoxLayout.LINE_AXIS));
        Row1.add(new javax.swing.JLabel("Le résultat obtenu pour le coût:"));
        lewyPanel.add(Row1);
        lewyPanel.add(Box.createRigidArea(new Dimension(0,20)));

        JPanel Row2 = wypiszKoszty(ilosc, koszty);
        lewyPanel.add(Row2);
        lewyPanel.add(Box.createRigidArea(new Dimension(0,20)));

        JPanel Row3 = new javax.swing.JPanel();
        Row3.setLayout(new BoxLayout(Row3, BoxLayout.LINE_AXIS));
        Row3.add(new javax.swing.JLabel("chemin:"));
        lewyPanel.add(Row3);
        lewyPanel.add(Box.createRigidArea(new Dimension(0,10)));

        JPanel Row4 = new javax.swing.JPanel();
        Row4.setLayout(new BoxLayout(Row4, BoxLayout.LINE_AXIS));
        Row4.add(new javax.swing.JLabel(wypis1));
        lewyPanel.add(Row4);
        lewyPanel.add(Box.createRigidArea(new Dimension(0,10)));

        JPanel Row6 = new javax.swing.JPanel();
        Row6.setLayout(new BoxLayout(Row6, BoxLayout.LINE_AXIS));
        Row6.add(new javax.swing.JLabel(wypis2));
        lewyPanel.add(Row6);
        lewyPanel.add(Box.createRigidArea(new Dimension(0,10)));

        JPanel Row9 = new javax.swing.JPanel();
        Row9.setLayout(new BoxLayout(Row9, BoxLayout.LINE_AXIS));
        Row9.add(new javax.swing.JLabel("Koszt: "+String.valueOf(lb)));
        lewyPanel.add(Row9);
        lewyPanel.add(Box.createRigidArea(new Dimension(0,10)));

        JPanel Row7 = new javax.swing.JPanel();
        Row7.setLayout(new BoxLayout(Row7, BoxLayout.LINE_AXIS));
        Row7.add(new javax.swing.JLabel());
        lewyPanel.add(Row7);
        lewyPanel.add(Box.createRigidArea(new Dimension(0,10)));

        JPanel Row8 = new javax.swing.JPanel();
        Row8.setLayout(new BoxLayout(Row8, BoxLayout.LINE_AXIS));
        JButton zapisz = new javax.swing.JButton("Zapisz");
        zapisz.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                try {
                    saveCosts();
                } catch (IOException ex) {
                    Logger.getLogger(InterfacePanel6.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Row7.add(zapisz);
        lewyPanel.add(Row7);

        calyPanel.add(lewyPanel);

        if(tryb==2)
        {
            calyPanel.add(Box.createHorizontalGlue());
            prawyPanel.setLayout(new BoxLayout(prawyPanel, BoxLayout.PAGE_AXIS));
            JPanel Row5 = rozw.createTreeVisualization();
            prawyPanel.add(Row5);
            prawyPanel.add(Box.createRigidArea(new Dimension(5,0)));
            prawyPanel.add(wypiszTabelki());
            prawyPanel.add(Box.createRigidArea(new Dimension(5,0)));
            prawyScrollPane = new JScrollPane(prawyPanel);
            calyPanel.add(prawyScrollPane);
        }


        else if(tryb==3)
        {
            calyPanel.add(Box.createHorizontalGlue());
            prawyScrollPane = new JScrollPane(nowyPrawyPanel());
            calyPanel.add(prawyScrollPane);

        }

    this.add(calyPanel);
    this.setVisible(true);
    this.pack();

    }


        private JPanel wypiszTabelki()
{
    JPanel tmpPanel = new javax.swing.JPanel();
    tmpPanel.setLayout(new GridLayout(0,3,5,5));
    tmpPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    
    Queue <Vertex>kolejka=new LinkedList<Vertex>();
    Collection<Vertex> children = new ArrayList<Vertex>();
    Vertex root = rozw.treeVisualization.findRoot();
    kolejka.add(root);
    int tableIndex = 1; 
    while(!kolejka.isEmpty())
    {
        root = kolejka.poll();
        JPanel tabPanel = new javax.swing.JPanel();
        tabPanel.setLayout(new BoxLayout(tabPanel, BoxLayout.PAGE_AXIS));
        tabPanel.add(new javax.swing.JLabel("vertex No. "+Integer.toString(root.getId())));
        tabPanel.add(Box.createRigidArea(new Dimension(0,10)));
        tabPanel.add(new javax.swing.JLabel("LB =  "+Integer.toString(root.getLowerBound())));
        tabPanel.add(Box.createRigidArea(new Dimension(0,10)));
        tabPanel.add(wypiszKoszty(root.getDistancesSize(), root.getDistances()));
        tabPanel.add(Box.createRigidArea(new Dimension(0,10)));
        tmpPanel.add(tabPanel);
        tableIndex++;
        children=rozw.treeVisualization.gv.getSuccessors(root);
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
        /*  for(Iterator<Vertex>it = children.iterator();it.hasNext();)
        {
            Vertex doKolejki=it.next();
            kolejka.add(doKolejki);
        }*/


    return tmpPanel;
}


   private JPanel nowyPrawyPanel()
    {
 //       iteracje = rozw.branchAndBound();
        JPanel tmpPanel = new javax.swing.JPanel();
        tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.PAGE_AXIS));
        JPanel przyciski = new javax.swing.JPanel();
        przyciski.setLayout(new BoxLayout(przyciski, BoxLayout.LINE_AXIS));

        if (ktoraIteracja>1)
        {
            przyciski.add(poprzedni);
            przyciski.add(Box.createRigidArea(new Dimension(0,5)));
        }

        if (ktoraIteracja<iteracje) // <= -> <
        {
            przyciski.add(nastepny);
        }

        tmpPanel.add(przyciski);
        tmpPanel.add(Box.createRigidArea(new Dimension(5,0)));
        rozw.branchAndBound2(ktoraIteracja,iteracje);
        if (ktoraIteracja>0)
        {
            tmpPanel.add(rozw.createTreeVisualization());
            tmpPanel.add(Box.createRigidArea(new Dimension(5,0)));
            tmpPanel.add(wypiszTabelki());
        }
        tmpPanel.setVisible(true);
        return tmpPanel;
    }

}