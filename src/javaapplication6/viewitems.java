/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static mail.mail.send1;

/**
 *
 * @author chandan
 */
public class viewitems extends javax.swing.JFrame {

    /**
     * Creates new form viewitems
     */
    public viewitems() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        jScrollPane1.setBounds(0, 0,this.getWidth(),500);
        jTable1.setBounds(0,0,this.getWidth(),500);
        
     this.add();
    }
    public void add() 
{
    
    
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
     try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "pass");
                   Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from items");
            int i=1; 
            while(rs.next()) {
                  
     String data1 = rs.getString("iname");
    String data2 = rs.getString("rate");
   
   

    Object[] row = {rs.getInt("id"),data1, data2};
    i++;
     model.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(forgetdetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(forgetdetails.class.getName()).log(Level.SEVERE, null, ex);
        }
     

}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setHorizontalScrollBar(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1378, 500));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ItemNo", "Item name", "Rate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addComponent(jButton3)
                .addGap(55, 55, 55)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BufferedWriter bfw = null;
        try {
            bfw = new BufferedWriter(new FileWriter("h://QUOTATIONS.txt"));
            System.out.println(bfw);
            bfw.write("--------------------------------------------------");
            bfw.newLine();
            bfw.write("|                   BLUEPEARL LIMITED             |");
            bfw.newLine();
             bfw.write("--------------------------------------------------");
             bfw.newLine();
            for(int i = 0 ; i < jTable1.getColumnCount() ; i++)
            {
                bfw.write(jTable1.getColumnName(i));
                bfw.write("\t  ");
            }         for (int i = 0 ; i < jTable1.getRowCount(); i++)
            {
                bfw.newLine();
                for(int j = 0 ; j < jTable1.getColumnCount();j++)
                {
                    bfw.write(String.valueOf(jTable1.getValueAt(i,j)));
                    bfw.write("\t   ");
                }
            }         
            bfw.close();
            Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "pass");
                   Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from customer");
             while(rs.next()) {
          send1("bluepearl273@gmail.com","bluepearl123",rs.getString("email"),"Quotations","this is the quotationof abc group of company","h://QUOTATIONS.txt");
             }
          JOptionPane.showMessageDialog(null, "MESSAGE SENT SUCCESSFULLY"); 

        } catch (IOException ex) {  
            Logger.getLogger(viewitems.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewitems.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(viewitems.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bfw.close();
            } catch (IOException ex) {
                Logger.getLogger(viewitems.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing", "root", "pass");
                   Statement stmt = conn.createStatement();
                   
            for(int j=0;j<id.length;j++)
            {
                String sql = "DELETE FROM items WHERE id ="+id[j];
                System.out.println(sql); 
      stmt.executeUpdate(sql);
            }
            this.dispose();
            new viewitems().setVisible(true);
           
           
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(forgetdetails.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(forgetdetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
int[] id=new int[100];
int[]i=new int[100];
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         int i[]=jTable1.getSelectedRows();
       for(int j=0;j<i.length;j++)
        { 
            System.out.println(i[j]);  
    }                                    
 DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for(int j=0;j<i.length;j++)
        {
       id[j]=(int) model.getValueAt(i[j],0);
        System.out.println(id[j]);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(mainWin.clientviewitems==true)
        {
            
        }
        if(mainWin.clientviewitems==false)
        {
            new Adminview().setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewitems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewitems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewitems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewitems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewitems().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
