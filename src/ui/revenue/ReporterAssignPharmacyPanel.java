/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.revenue;

import Services.ComboItem;
import database.PharmacyService;
import database.ReporterAssignmentService;
import database.ReporterService;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import model.Pharmacy;
import model.Reporter;
import model.ReporterAssignment;

/**
 *
 * @author maheshsai
 */
public class ReporterAssignPharmacyPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReporterAssignPharmacyPanel
     */
  ReporterService ps = new ReporterService();
    PharmacyService ds = new PharmacyService();
    JSplitPane mainPanel;
    ArrayList<Component> al;
    public ReporterAssignPharmacyPanel(JSplitPane mainPanel, ArrayList<Component> al) {
        initComponents();
        this.al = al;
        this.mainPanel = mainPanel;
        ArrayList<Reporter> patients = this.ps.getAllReporters();
        if(patients!=null) {
        for(Reporter patient: patients) {
            this.boxAdmins.addItem(new ComboItem(patient.getName(),patient.getId()));
        }
        }
        
        ArrayList<Pharmacy> doctors = this.ds.getAllPharmacys();
        if(doctors!=null) {
        for(Pharmacy doctor: doctors) {
            this.boxPharmacys.addItem(new ComboItem(doctor.getName(),doctor.getId()));
        }
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
        boxAdmins = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boxPharmacys = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        boxAdmins.setForeground(new java.awt.Color(0, 0, 0));
        boxAdmins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAdminsActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Reporter");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Pharmacy");

        boxPharmacys.setForeground(new java.awt.Color(0, 0, 0));
        boxPharmacys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPharmacysActionPerformed(evt);
            }
        });

        btnAdd.setForeground(new java.awt.Color(0, 0, 0));
        btnAdd.setText("Assign");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Assign  Pharmacy");

        btnBack1.setForeground(new java.awt.Color(0, 0, 0));
        btnBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/back.png"))); // NOI18N
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBack1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boxAdmins, 0, 177, Short.MAX_VALUE)
                            .addComponent(boxPharmacys, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(261, 261, 261))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 344, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addComponent(jLabel1))
                        .addGap(357, 357, 357))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxAdmins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnBack1)))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(boxPharmacys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addComponent(btnAdd)
                .addContainerGap(296, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxAdminsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAdminsActionPerformed
        // TODO add your handling code here:
        //        this.boxVitalSigns.removeAll();
    }//GEN-LAST:event_boxAdminsActionPerformed

    private void boxPharmacysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPharmacysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxPharmacysActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Object item = this.boxAdmins.getSelectedItem();
        if(item == null) {
            JOptionPane.showMessageDialog(this, "reporter can't be null");
            return;
        }
        String adminid = ((ComboItem)item).getValue();

        Object item2 = this.boxPharmacys.getSelectedItem();
        if(item2 == null) {
            JOptionPane.showMessageDialog(this, "Pharmacy can't be null");
            return;
        }
        //        if(this.jDateChooser1.getDate() == null) {
            //            JOptionPane.showMessageDialog(this, "date can't be null");
            //            return;
            //        }
        String hid = ((ComboItem)item2).getValue();

        ReporterAssignment ec = new ReporterAssignment(hid, adminid, "Pharmacy");
        ReporterAssignmentService es = new ReporterAssignmentService();
        es.create(ec);
        JOptionPane.showMessageDialog(this, "Successfully created");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        Component c = this.al.get(this.al.size()-1);
        this.al.remove(this.al.size()-1);
        this.mainPanel.setRightComponent(c);
    }//GEN-LAST:event_btnBack1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ComboItem> boxAdmins;
    private javax.swing.JComboBox<ComboItem> boxPharmacys;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
