/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.systsemadmin;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JSplitPane;
import model.Patient;
import model.SystemAdmin;
import ui.PlanningEnterprise.PlanningAdminListPanel;
import ui.hospital.DoctorOrgListPanel;
import ui.hospital.HospitalAdminListPanel;
import ui.pharmaceutical.PharmaceuticalAdminListPanel;
import ui.revenue.RevenueAdminListPanel;

/**
 *
 * @author madhav
 */
public class SystemAdminPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminPanel
     */
      JSplitPane mainPanel;
    ArrayList<Component> al;
    SystemAdmin user;
    public SystemAdminPanel(SystemAdmin user, JSplitPane mainPanel) {
        initComponents();
        this.user = user;
        this.mainPanel = mainPanel;
        this.al = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnHospital = new javax.swing.JButton();
        btnPharmaceutical = new javax.swing.JButton();
        btnRevenue = new javax.swing.JButton();
        btnPlanning = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnHospital1 = new javax.swing.JButton();
        btnHospital2 = new javax.swing.JButton();
        btnRevenue1 = new javax.swing.JButton();
        btnPlanning1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("System Admin");

        btnHospital.setForeground(new java.awt.Color(0, 0, 0));
        btnHospital.setText("Manage Hospital Enterprise");
        btnHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospitalActionPerformed(evt);
            }
        });

        btnPharmaceutical.setForeground(new java.awt.Color(0, 0, 0));
        btnPharmaceutical.setText("Manage Pharmaceutical Enterprise");
        btnPharmaceutical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPharmaceuticalActionPerformed(evt);
            }
        });

        btnRevenue.setForeground(new java.awt.Color(0, 0, 0));
        btnRevenue.setText("Manage Revenue Enterprise");
        btnRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevenueActionPerformed(evt);
            }
        });

        btnPlanning.setForeground(new java.awt.Color(0, 0, 0));
        btnPlanning.setText("Manage Planning Enterprise");
        btnPlanning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlanningActionPerformed(evt);
            }
        });

        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Get to Know");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnHospital1.setForeground(new java.awt.Color(0, 0, 0));
        btnHospital1.setText("Manage Hospital Admins");
        btnHospital1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospital1ActionPerformed(evt);
            }
        });

        btnHospital2.setForeground(new java.awt.Color(0, 0, 0));
        btnHospital2.setText("Manage Pharmaceutical Admins");
        btnHospital2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospital2ActionPerformed(evt);
            }
        });

        btnRevenue1.setForeground(new java.awt.Color(0, 0, 0));
        btnRevenue1.setText("Manage Revenue Admins");
        btnRevenue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevenue1ActionPerformed(evt);
            }
        });

        btnPlanning1.setForeground(new java.awt.Color(0, 0, 0));
        btnPlanning1.setText("Manage Planning Admins");
        btnPlanning1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlanning1ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Hospital Enterprise");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Pharmaceutical Enterprise");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Revenue Enterprise");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Planning Enterprise");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPharmaceutical, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPlanning, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPlanning1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRevenue1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHospital2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHospital1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHospital)
                    .addComponent(btnHospital1))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPharmaceutical)
                    .addComponent(btnHospital2))
                .addGap(12, 12, 12)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRevenue)
                    .addComponent(btnRevenue1))
                .addGap(28, 28, 28)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlanning)
                    .addComponent(btnPlanning1))
                .addGap(61, 61, 61)
                .addComponent(jButton5)
                .addContainerGap(104, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospitalActionPerformed
        // TODO add your handling code here:
          ManageHospitalEnterprisePanel panel = new ManageHospitalEnterprisePanel(this.mainPanel,this.al);
        this.al.add(this);
        this.mainPanel.setRightComponent(panel);
        
    }//GEN-LAST:event_btnHospitalActionPerformed

    private void btnHospital1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospital1ActionPerformed
        // TODO add your handling code here:
         HospitalAdminListPanel panel = new HospitalAdminListPanel(this.mainPanel,this.al);
        this.al.add(this);
        this.mainPanel.setRightComponent(panel);
        
    }//GEN-LAST:event_btnHospital1ActionPerformed

    private void btnHospital2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospital2ActionPerformed
        // TODO add your handling code here:
        PharmaceuticalAdminListPanel panel = new PharmaceuticalAdminListPanel(this.mainPanel,this.al);
        this.al.add(this);
        this.mainPanel.setRightComponent(panel);
    }//GEN-LAST:event_btnHospital2ActionPerformed

    private void btnRevenue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevenue1ActionPerformed
        // TODO add your handling code here:
         RevenueAdminListPanel panel = new RevenueAdminListPanel(this.mainPanel,this.al);
        this.al.add(this);
        this.mainPanel.setRightComponent(panel);
    }//GEN-LAST:event_btnRevenue1ActionPerformed

    private void btnPlanning1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlanning1ActionPerformed
        // TODO add your handling code here:
        PlanningAdminListPanel panel = new PlanningAdminListPanel(this.mainPanel,this.al);
        this.al.add(this);
        this.mainPanel.setRightComponent(panel);
    }//GEN-LAST:event_btnPlanning1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnPharmaceuticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPharmaceuticalActionPerformed
        // TODO add your handling code here:
        ManagePharmaceuticalPanel panel = new ManagePharmaceuticalPanel(this.mainPanel,this.al);
        this.al.add(this);
        this.mainPanel.setRightComponent(panel);
    }//GEN-LAST:event_btnPharmaceuticalActionPerformed

    private void btnRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevenueActionPerformed
        // TODO add your handling code here:
         ManageRevenueEnterprisePanel panel = new ManageRevenueEnterprisePanel(this.mainPanel,this.al);
        this.al.add(this);
        this.mainPanel.setRightComponent(panel);
    }//GEN-LAST:event_btnRevenueActionPerformed

    private void btnPlanningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlanningActionPerformed
        // TODO add your handling code here:
        ManagePlanningEnterprisePanel panel = new ManagePlanningEnterprisePanel(this.mainPanel,this.al);
        this.al.add(this);
        this.mainPanel.setRightComponent(panel);
    }//GEN-LAST:event_btnPlanningActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHospital;
    private javax.swing.JButton btnHospital1;
    private javax.swing.JButton btnHospital2;
    private javax.swing.JButton btnPharmaceutical;
    private javax.swing.JButton btnPlanning;
    private javax.swing.JButton btnPlanning1;
    private javax.swing.JButton btnRevenue;
    private javax.swing.JButton btnRevenue1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
