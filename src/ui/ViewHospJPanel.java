/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DataService;
import model.Hospital;

/**
 *
 * @author somes
 */
public class ViewHospJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewHospJPanel
     */
    DataService hosp;
    public ViewHospJPanel(DataService hosp) {
        initComponents();
        this.hosp = hosp;
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbViewHospital = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHosp = new javax.swing.JTable();
        btnViewHosp = new javax.swing.JButton();
        btnDeleteHosp = new javax.swing.JButton();
        lbHospName = new javax.swing.JLabel();
        lbCommunityID = new javax.swing.JLabel();
        txtHospId = new javax.swing.JTextField();
        txtHospName = new javax.swing.JTextField();
        txtCommId = new javax.swing.JTextField();
        lbHospID = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 204, 255));

        lbViewHospital.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbViewHospital.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbViewHospital.setText("View Hospital Details");

        tblHosp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Hospital ID", "Hospital Name", "Community ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHosp);

        btnViewHosp.setText("View");
        btnViewHosp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewHospActionPerformed(evt);
            }
        });

        btnDeleteHosp.setText("Delete");
        btnDeleteHosp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteHospActionPerformed(evt);
            }
        });

        lbHospName.setText("Hospital Name :");

        lbCommunityID.setText("Community ID :");

        txtHospId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHospIdActionPerformed(evt);
            }
        });

        lbHospID.setText("Hospital ID :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbViewHospital, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(btnViewHosp)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteHosp))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbCommunityID)
                                    .addComponent(lbHospName)
                                    .addComponent(lbHospID))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtHospId, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHospName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCommId, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 69, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbViewHospital)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewHosp)
                    .addComponent(btnDeleteHosp))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHospID)
                    .addComponent(txtHospId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHospName)
                    .addComponent(txtHospName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCommunityID)
                    .addComponent(txtCommId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewHospActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewHospActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblHosp.getSelectedRow();
        if(selectedRowIndex<0){
        JOptionPane.showMessageDialog(this,"Please select a row to delete.");
        return;
        }
        DefaultTableModel model= (DefaultTableModel) tblHosp.getModel();
        Hospital selectedHospital = (Hospital) model.getValueAt(selectedRowIndex, 0);
        txtHospId.setText(String.valueOf(selectedHospital.getHospitalId()));
        txtHospName.setText(selectedHospital.getHospitalName());
        txtCommId.setText(selectedHospital.getCommunityId());
    
    }//GEN-LAST:event_btnViewHospActionPerformed

    private void txtHospIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHospIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHospIdActionPerformed

    private void btnDeleteHospActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHospActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblHosp.getSelectedRow();
        if(selectedRowIndex<0){
        JOptionPane.showMessageDialog(this,"Please select a row to delete.");
        return;
        }
        DefaultTableModel model= (DefaultTableModel) tblHosp.getModel();
        Hospital selectedHospital = (Hospital) model.getValueAt(selectedRowIndex, 0);
        hosp.deleteHosp(selectedHospital);
        JOptionPane.showMessageDialog(this, "Hospital record has been deleted");
        populateTable();
    }//GEN-LAST:event_btnDeleteHospActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteHosp;
    private javax.swing.JButton btnViewHosp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCommunityID;
    private javax.swing.JLabel lbHospID;
    private javax.swing.JLabel lbHospName;
    private javax.swing.JLabel lbViewHospital;
    private javax.swing.JTable tblHosp;
    private javax.swing.JTextField txtCommId;
    private javax.swing.JTextField txtHospId;
    private javax.swing.JTextField txtHospName;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        DefaultTableModel model= (DefaultTableModel) tblHosp.getModel();
        model.setRowCount(0);
        
        for(Hospital hp : hosp.getHosp()){
            Object[] row = new Object[3];
            row[0] = hp;
            row[1] = hp.getHospitalName();
            row[2] = hp.getCommunityId();
            model.addRow(row);
            
        }
    }
}
