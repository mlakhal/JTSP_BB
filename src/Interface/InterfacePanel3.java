/*
 * InterfacePanel3.java
 *
 * Created on 2009-05-05, 10:39:18
 */

package Interface;

import Algorithm.Solver;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class InterfacePanel3 extends javax.swing.JFrame {



    private static final int INF=100000000;


    private Integer[][] koszty;


    int ilosc;


    private int tryb;


    Solver rozw;


    int iteracje;


    int ktoraIteracja = 1;

    /** Creates new form InterfacePanel3 */
    public InterfacePanel3(int t) {
        initComponents();
        tryb = t;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Dalej = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        dodaj = new javax.swing.JButton();
        podglad = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "�criture", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 1, 15))); // NOI18N

        
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("frais:");

        Dalej.setText("plus");
        Dalej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DalejActionPerformed(evt);
            }
        });

        jButton3.setText("retour");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("ville de d�part");

        jLabel5.setText("Ville de destination");

        jLabel6.setText("co�t");

        dodaj.setText("ajouter");
        dodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajActionPerformed(evt);
            }
        });

        podglad.setText("avant-premi�re");
        podglad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                podgladActionPerformed(evt);
            }
        });

        jLabel7.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Dalej)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dodaj)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7))))))
                    .addComponent(podglad))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Dalej, jButton3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dodaj, jButton1, jTextField1, jTextField2, jTextField3, jTextField4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dodaj))
                .addGap(18, 18, 18)
                .addComponent(podglad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Dalej, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jButton3.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
}//GEN-LAST:event_jButton3ActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ilosc = Integer.parseInt(jTextField1.getText());
        jLabel7.setText(jTextField1.getText());
        jTextField1.setText(" ");
        koszty = new Integer[ilosc][];
        for (int i = 0; i<ilosc; i++)
        {
            koszty[i] = new Integer[ilosc];
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    private void dodajActionPerformed(java.awt.event.ActionEvent evt) {
        int m1, m2, k;
        m1 = Integer.parseInt(jTextField2.getText());
        m2 = Integer.parseInt(jTextField3.getText());
        k = Integer.parseInt(jTextField4.getText());
        if (spr_miasta(m1, m2))
        {
            if(m1!=m2)
                koszty[m1-1][m2-1] = k;
            if(m1==m2 && m1>0 )
                koszty[m1-1][m2-1]= 100000000;
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
        }


        else
        {
            
        }
    }





    private void DalejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DalejActionPerformed
    try {
            for(int i=0; i<ilosc; ++i)
                koszty[i][i]=100000000;
            InterfacePanel6 Panel6 = new InterfacePanel6(tryb, ilosc, koszty);
            Panel6.setVisible(true);
        }
    catch (IOException iOException)
        {
        }
}//GEN-LAST:event_DalejActionPerformed



    private void podgladActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_podgladActionPerformed
        JFrame Podglad = new javax.swing.JFrame();
        JPanel NewRow = wypiszKoszty(ilosc, koszty);
        Podglad.add(NewRow);
        Podglad.setVisible(true);
        Podglad.pack();

}//GEN-LAST:event_podgladActionPerformed


private boolean spr_miasta (int a, int b)
{
    if ((a <= ilosc)&&(b <= ilosc)&&(a != b))
        return true;
    return false;
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
                    if((i!=j)&&(koszty[j-1][i-1]<100000))
                    {
                        if (koszty[j-1][i-1]<0)
                            NewColumn.add(new javax.swing.JLabel(" "));
                        else
                            NewColumn.add(new javax.swing.JLabel(String.valueOf(koszty[j-1][i-1])));
                    }
                    else
                        NewColumn.add(new javax.swing.JLabel(Character.toString((char)8734)));
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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dalej;
    private javax.swing.JButton dodaj;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton podglad;
    // End of variables declaration//GEN-END:variables

}