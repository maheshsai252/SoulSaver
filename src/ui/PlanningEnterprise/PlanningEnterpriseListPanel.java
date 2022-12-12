/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.PlanningEnterprise;

import database.PlanningEnterpriseService;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import model.PlanningEnterprise;
import ui.forecasting.ForecastOrgListPanel;

/**
 *
 * @author maheshsai
 */
public class PlanningEnterpriseListPanel extends javax.swing.JPanel {

    /**
     * Creates new form PlanningEnterpriseListPanel
     */
   JSplitPane mainPanel;
    ArrayList<Component> al;
    PlanningEnterpriseService hs = new PlanningEnterpriseService();
    public PlanningEnterpriseListPanel(JSplitPane mainPanel, ArrayList<Component> al) {
        initComponents();
        this.mainPanel = mainPanel;
        this.al=al;
        addData();
    }
    void addData() {
        ArrayList<PlanningEnterprise> hospitals = hs.getAllPlanningEnterprises();
        DefaultTableModel model = (DefaultTableModel) this.tblEncounters.getModel();

        model.setRowCount(0);
        
        for(PlanningEnterprise h: hospitals) {
            Object[] row = new Object[3];
                
                System.out.println("Done");
                row[0] = h;

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEncounters = new javax.swing.JTable();
        btnCreateEvent = new javax.swing.JButton();
        btnViewEvent = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Planning Enterprises");

        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblEncounters.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        tblEncounters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NAME"
            }
        ));
        tblEncounters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEncountersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEncounters);

        btnCreateEvent.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnCreateEvent.setText("View Reporter Orgs");
        btnCreateEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEventActionPerformed(evt);
            }
        });

        btnViewEvent.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnViewEvent.setText("Update");
        btnViewEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEventActionPerformed(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnBack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreateEvent)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewEvent, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))))
                .addContainerGap(263, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCreateEvent, btnViewEvent, jButton1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCreateEvent)
                        .addGap(18, 18, 18)
                        .addComponent(btnViewEvent)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(55, 55, 55))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCreateEvent, btnViewEvent, jButton1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 10, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
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

        PlanningEnterprise item = (PlanningEnterprise) model.getValueAt(idx, 0);
        if(item == null) {
            JOptionPane.showMessageDialog(this, "Not correct item");
            return;
        }

        ForecastOrgListPanel panel = new ForecastOrgListPanel(item,this.mainPanel,this.al);
        this.al.add(this);
        this.mainPanel.setRightComponent(panel);
    }//GEN-LAST:event_btnCreateEventActionPerformed

    private void btnViewEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewEventActionPerformed
        // TODO add your handling code here:

        int idx = this.tblEncounters.getSelectedRow();
        if(idx<0) {
            JOptionPane.showMessageDialog(this, "Not correct index");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) this.tblEncounters.getModel();

        PlanningEnterprise item = (PlanningEnterprise) model.getValueAt(idx, 0);
        if(item == null) {
            JOptionPane.showMessageDialog(this, "Not correct item");
            return;
        }

        UpdatePlanningEnterprisePanel panel = new UpdatePlanningEnterprisePanel(item,this.mainPanel,this.al);
        this.al.add(this);
        this.mainPanel.setRightComponent(panel);
    }//GEN-LAST:event_btnViewEventActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int idx = this.tblEncounters.getSelectedRow();
        if(idx<0) {
            JOptionPane.showMessageDialog(this, "Not correct index");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) this.tblEncounters.getModel();

        PlanningEnterprise item = (PlanningEnterprise) model.getValueAt(idx, 0);
        if(item == null) {
            JOptionPane.showMessageDialog(this, "Not correct item");
            return;
        }
        String msg = this.hs.deletePlanningEnterprise(item.getId());
        JOptionPane.showMessageDialog(this, msg);
        addData();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateEvent;
    private javax.swing.JButton btnViewEvent;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEncounters;
    // End of variables declaration//GEN-END:variables
}