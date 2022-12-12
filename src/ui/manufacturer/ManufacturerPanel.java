/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.manufacturer;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JSplitPane;
import model.Manufacturer;
import model.Patient;

/**
 *
 * @author madhav
 */
public class ManufacturerPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManufacturerPanel
     */
    JSplitPane mainPanel;
    ArrayList<Component> al;
    Manufacturer user;
    public ManufacturerPanel(Manufacturer user, JSplitPane mainPanel) {
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

        jLabel4 = new javax.swing.JLabel();
        btnUpdateAddress1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnBuyMedicine1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Manufacturer Panel");

        btnUpdateAddress1.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnUpdateAddress1.setText("Update Details");
        btnUpdateAddress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAddress1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Update");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Actions");

        btnBuyMedicine1.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnBuyMedicine1.setText("Manage Inventory");
        btnBuyMedicine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyMedicine1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(btnBuyMedicine1)
                            .addComponent(btnUpdateAddress1))))
                .addContainerGap(343, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBuyMedicine1, btnUpdateAddress1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel4)
                .addGap(89, 89, 89)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateAddress1)
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(btnBuyMedicine1)
                .addContainerGap(325, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, jLabel6});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBuyMedicine1, btnUpdateAddress1});

    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateAddress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAddress1ActionPerformed
        // TODO add your handling code here:
        this.al.add(this);
        UpdateManufacturerPanel upanel = new UpdateManufacturerPanel(this.user, this.mainPanel,this.al);
        this.mainPanel.setRightComponent(upanel);
    }//GEN-LAST:event_btnUpdateAddress1ActionPerformed

    private void btnBuyMedicine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyMedicine1ActionPerformed
        // TODO add your handling code here:
        
        ManufacturingWorkflowRequestsPanel panel = new ManufacturingWorkflowRequestsPanel(user, this.mainPanel, this.al);
        this.al.add(this);
        this.mainPanel.setRightComponent(panel);
    }//GEN-LAST:event_btnBuyMedicine1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuyMedicine1;
    private javax.swing.JButton btnUpdateAddress1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
