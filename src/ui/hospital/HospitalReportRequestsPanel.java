/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.hospital;

import Services.RevenueService;
import database.HospitalDBService;
import database.ReportRequestService;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import model.Hospital;
import model.ReportRequest;
import model.Reporter;

/**
 *
 * @author pavanmadhav
 */
public class HospitalReportRequestsPanel extends javax.swing.JPanel {

    /**
     * Creates new form HospitalReportRequestsPanel
     */
     Hospital h;
    
JSplitPane mainPanel;
    ArrayList<Component> al;
    HospitalDBService hs = new HospitalDBService();
    HashMap<String, Double> records;
    ReportRequestService ras = new  ReportRequestService();
    public HospitalReportRequestsPanel(Hospital h, JSplitPane mainPanel,ArrayList<Component> al) {
        initComponents();
        this.mainPanel = mainPanel;
        this.al = al;
        this.h = h;
        addData();
        
    }
    void addData() {
           DefaultTableModel model = (DefaultTableModel) this.tblEncounters.getModel();
        model.setRowCount(0);
        RevenueService rs = new RevenueService();
        
        ArrayList<ReportRequest> reqs = ras.getHospitalReportRequests(h.getId());
        
        for(ReportRequest s : reqs) {
                Object[] row = new Object[4];
                
                System.out.println("Done");
                
//                Hospital h = hs.getHospital(s.getHid());
                row[0] = s;
                row[1] = h;
                row[2] = s.getDate();
                row[3] = s.getStatus();
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
        btnFullfill = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hospital List of Requests");

        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblEncounters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Hospital", "Date", "Status"
            }
        ));
        tblEncounters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEncountersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEncounters);

        btnFullfill.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnFullfill.setText("Create");
        btnFullfill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFullfillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFullfill)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFullfill)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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

    private void btnFullfillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFullfillActionPerformed
        // TODO add your handling code here:
 
        ReportRequest req = new ReportRequest(h.getId(), false, new Date());
        ras.create(req);
        JOptionPane.showMessageDialog(this, "Created report Req");
        addData();

    }//GEN-LAST:event_btnFullfillActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFullfill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEncounters;
    // End of variables declaration//GEN-END:variables
}
