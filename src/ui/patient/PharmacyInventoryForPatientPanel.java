/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.patient;

import Services.MailService;
import database.InventoryItemService;
import database.TransactionLogService;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import model.InventoryItem;
import model.Patient;
import model.Pharmacy;
import model.TransactionLog;

/**
 *
 * @author maheshsai
 */
public class PharmacyInventoryForPatientPanel extends javax.swing.JPanel {

    /**
     * Creates new form PharmacyInventoryForPatientPanel
     */
    
    JSplitPane mainPanel;
    ArrayList<Component> al;
    InventoryItemService iis;
    Pharmacy ph;
    Patient p;
    public PharmacyInventoryForPatientPanel(Patient p, Pharmacy ph, JSplitPane mainPanel, ArrayList<Component> al) {
        initComponents();
        iis = new InventoryItemService();
        this.mainPanel = mainPanel;
        this.al = al;
        this.p = p;
        this.ph = ph;
        update();
//        this.txtDiagnose.setEditable(false);
        this.btnNotify.setEnabled(false);
        this.lblStatus.setText("");
        this.btnPurchse.setEnabled(false);
    }
    void update() {
        DefaultTableModel model = (DefaultTableModel) this.tblEncounters.getModel();
        model.setRowCount(0);
        ArrayList<InventoryItem> inventoryItems = new ArrayList<>();
        if(ph != null) {
            inventoryItems = this.iis.getAllInventoryItemsOfPharmacy(ph.getId());
        } 
        for(InventoryItem item: inventoryItems) {
                Object[] row = new Object[4];
                
                System.out.println("Done");
                if(item.getManufacturer() != null) {
                row[0] = item.getManufacturer().getName();
                } else {
                    row[0] = "NA";
                }
                row[1] = item;
                row[2] = item.getQty();
                row[3] = item.getCost();

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
        btnNotify = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiagnose = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnPurchse = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel1.setText("Pharmacy Inventory");

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
                "Manufacturer", "name", "qty", "price"
            }
        ));
        tblEncounters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEncountersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEncounters);

        btnNotify.setForeground(new java.awt.Color(204, 0, 255));
        btnNotify.setText("Notify");
        btnNotify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyActionPerformed(evt);
            }
        });

        txtDiagnose.setColumns(20);
        txtDiagnose.setRows(5);
        jScrollPane2.setViewportView(txtDiagnose);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel4.setText("Qty");

        lblStatus.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblStatus.setText("Type");

        btnPurchse.setText("Purchase");
        btnPurchse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(371, 371, 371))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblStatus)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPurchse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNotify))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnBack)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 23, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNotify)
                            .addComponent(btnPurchse))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 838, Short.MAX_VALUE)
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
        int idx = this.tblEncounters.getSelectedRow();
        if(idx<0) {
            JOptionPane.showMessageDialog(this, "Not correct index");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) this.tblEncounters.getModel();

        InventoryItem item = (InventoryItem) model.getValueAt(idx, 1);
        if(item == null) {
            JOptionPane.showMessageDialog(this, "Not correct item");
            return;
        }
        if(item.getQty() == 0) {
            this.lblStatus.setText("Out Of Stock");
            this.btnNotify.setEnabled(true);
            this.btnPurchse.setEnabled(false);
        } else {
            this.btnPurchse.setEnabled(true);
        }
    }//GEN-LAST:event_tblEncountersMouseClicked

    private void btnNotifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyActionPerformed
        // TODO add your handling code here:
        int idx = this.tblEncounters.getSelectedRow();
        if(idx<0) {
            JOptionPane.showMessageDialog(this, "Not correct index");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) this.tblEncounters.getModel();

        InventoryItem item = (InventoryItem) model.getValueAt(idx, 1);
        if(item == null) {
            JOptionPane.showMessageDialog(this, "Not correct item");
            return;
        }
        String address = item.getPharmacy().getEmail();
        MailService es = new MailService();
        es.actionPerformed("Out of stock for"+ item.getName(), "Out of stock for"+ item.getName(), p.getEmail(), address);

        if(this.txtDiagnose.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Not correct qty");
            return;
        }

       
        JOptionPane.showMessageDialog(this, "Notified Pharmacy");
    }//GEN-LAST:event_btnNotifyActionPerformed

    private void btnPurchseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchseActionPerformed
        // TODO add your handling code here:
        int idx = this.tblEncounters.getSelectedRow();
        if(idx<0) {
            JOptionPane.showMessageDialog(this, "Not correct index");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) this.tblEncounters.getModel();

        InventoryItem item = (InventoryItem) model.getValueAt(idx, 1);
        if(item == null) {
            JOptionPane.showMessageDialog(this, "Not correct item");
            return;
        }
        //        String address = item.getManufacturer().getEmail();
        //        MailService es = new MailService();
        //        es.actionPerformed("Out of stock for"+ item.getName(), "Out of stock for"+ item.getName(), item.getPharmacy().getEmail(), address);
        if(this.txtDiagnose.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Not correct qty");
            return;
        }

        int qty = Integer.parseInt(this.txtDiagnose.getText());
        if(qty>item.getQty()) {
            JOptionPane.showMessageDialog(this, "Not available qty");
            return;
        }
        item.setQty(item.getQty()-qty);
        iis.update(item);
        
        TransactionLog t = new TransactionLog(item.getId(),item.getPharmacy_id(), qty, p.getId(),qty*item.getCost());
        TransactionLogService ts = new TransactionLogService();
        ts.create(t);
        JOptionPane.showMessageDialog(this, "Purchased with cost "+ String.valueOf(qty*item.getCost()));
        update();
    }//GEN-LAST:event_btnPurchseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNotify;
    private javax.swing.JButton btnPurchse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblEncounters;
    private javax.swing.JTextArea txtDiagnose;
    // End of variables declaration//GEN-END:variables
}
