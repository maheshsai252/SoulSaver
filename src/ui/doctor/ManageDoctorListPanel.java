/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.doctor;

import database.DoctorService;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import model.Doctor;
import model.DoctorOrg;
import model.Pharmacy;

/**
 *
 * @author pavanmadhav
 */
public class ManageDoctorListPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageDoctorListPanel
     */
    JSplitPane mainPanel;
    ArrayList<Component> al;
    DoctorService hs = new DoctorService();
    DoctorOrg d;
    public ManageDoctorListPanel(JSplitPane mainPanel, ArrayList<Component> al) {
        initComponents();
        this.d=d;
        this.mainPanel = mainPanel;
        this.al=al;
        addData();
    }
   void addData() {
        ArrayList<Doctor> hospitals = hs.getAllDoctors();
        DefaultTableModel model = (DefaultTableModel) this.tblEncounters.getModel();

        model.setRowCount(0);
        ArrayList<Pharmacy> reqs = new ArrayList<>();
        
        for(Doctor h: hospitals) {
            Object[] row = new Object[3];
                
                System.out.println("Done");
                row[0] = h;
                row[1] = h.getId();

                model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnCreateEvent = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEncounters = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Doctors");

        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCreateEvent.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnCreateEvent.setText("Update");
        btnCreateEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEventActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jButton1.setText("Delete ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnBack)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 493, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateEvent)
                    .addComponent(jButton1))
                .addGap(47, 47, 47))
        );

        tblEncounters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Address"
            }
        ));
        tblEncounters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEncountersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEncounters);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Component c = this.al.get(this.al.size()-1);
        this.al.remove(this.al.size()-1);
        this.mainPanel.setRightComponent(c);
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblEncountersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEncountersMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEncountersMouseClicked

    private void btnCreateEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEventActionPerformed
        // TODO add your handling code here:
        int idx = this.tblEncounters.getSelectedRow();
        if(idx<0) {
            JOptionPane.showMessageDialog(this, "Not correct index");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) this.tblEncounters.getModel();

        Doctor item = (Doctor) model.getValueAt(idx, 0);
        if(item == null) {
            JOptionPane.showMessageDialog(this, "Not correct item");
            return;
        }

        UpdateDoctorlPanel panel = new UpdateDoctorlPanel(item,this.mainPanel,this.al);
        this.al.add(this);
        this.mainPanel.setRightComponent(panel);
    }//GEN-LAST:event_btnCreateEventActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int idx = this.tblEncounters.getSelectedRow();
        if(idx<0) {
            JOptionPane.showMessageDialog(this, "Not correct index");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) this.tblEncounters.getModel();

        Doctor item = (Doctor) model.getValueAt(idx, 0);
        if(item == null) {
            JOptionPane.showMessageDialog(this, "Not correct item");
            return;
        }
        String msg = this.hs.deleteDoctor(item.getId());
        JOptionPane.showMessageDialog(this, msg);
        
        addData();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateEvent;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEncounters;
    // End of variables declaration//GEN-END:variables
}