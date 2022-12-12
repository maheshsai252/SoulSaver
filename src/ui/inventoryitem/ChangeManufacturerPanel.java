/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.inventoryitem;

import Services.ComboItem;
import database.InventoryItemService;
import database.ManufacturerService;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import model.InventoryItem;
import model.Manufacturer;
import model.Patient;
import model.Pharmacy;

/**
 *
 * @author somes
 */
public class ChangeManufacturerPanel extends javax.swing.JPanel {

    /**
     * Creates new form ChangeManufacturerPanel
     */
    
    JSplitPane mainPanel;
    ArrayList<Component> al;
    InventoryItemService iis;
    ManufacturerService mas;
    Pharmacy ph;
    Patient p;
    public ChangeManufacturerPanel(JSplitPane mainPanel, ArrayList<Component> al) {
        initComponents();
        iis = new InventoryItemService();
        mas = new ManufacturerService();
        this.mainPanel = mainPanel;
        this.al = al;
        this.p = p;
        this.ph = ph;
        updateTable();
        ArrayList<Manufacturer> communities = this.mas.getAllManufacturers();
       if(communities!=null) {
        for(Manufacturer c: communities) {
            if(c!=null){
                this.boxManufacturers.addItem(new ComboItem(c.getName(),c.getId()));
            }
        }
       }
//        this.txtDiagnose.setEditable(false);
        
    }
    void updateTable() {
        DefaultTableModel model = (DefaultTableModel) this.tblEncounters.getModel();
        model.setRowCount(0);
        ArrayList<InventoryItem> inventoryItems = new ArrayList<>();
        inventoryItems = this.iis.getAllInventoryItems();
        
        for(InventoryItem item: inventoryItems) {
                Object[] row = new Object[4];
                
                System.out.println("Done");
                if(item.getManufacturer()!=null) {
                    row[0] = item.getManufacturer().getName();
                } else{
                    row[0]="NA";
                }
                row[1] = item;
                row[2] = item.getQty();
                row[3] = item.getCost();

                model.addRow(row);
            
        }
    }
    void setSelectedValue(JComboBox comboBox, String value)
    {
        ComboItem item;
        for (int i = 0; i < comboBox.getItemCount(); i++)
        {
            item = (ComboItem)comboBox.getItemAt(i);
            if (item.getValue().equals(value))
            {
                comboBox.setSelectedIndex(i);
                break;
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
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEncounters = new javax.swing.JTable();
        btnNotify = new javax.swing.JButton();
        boxManufacturers = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Change Manufacturer");

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
                "Manufacturer", "Name", "Quantity", "Price"
            }
        ));
        tblEncounters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEncountersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEncounters);

        btnNotify.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnNotify.setForeground(new java.awt.Color(204, 0, 255));
        btnNotify.setText("Update");
        btnNotify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Manufacturers");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(105, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNotify)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boxManufacturers, 0, 110, Short.MAX_VALUE)))
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boxManufacturers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNotify)
                        .addGap(250, 250, 250))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(56, Short.MAX_VALUE))))
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
            .addGap(0, 555, Short.MAX_VALUE)
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
        
        this.btnNotify.setEnabled(true);
        if(item.getManufacturer() != null) {
             this.setSelectedValue(boxManufacturers, item.getManufacturer_id());
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
        Object items = this.boxManufacturers.getSelectedItem();
        if(items==null) {
            JOptionPane.showMessageDialog(this, "City details can't be empty");
            return;
        }
        String mid = ((ComboItem)items).getValue();
        item.setManufacturer_id(mid);
        String s = iis.update(item);
        JOptionPane.showMessageDialog(this, s);
        updateTable();
    }//GEN-LAST:event_btnNotifyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ComboItem> boxManufacturers;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNotify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEncounters;
    // End of variables declaration//GEN-END:variables
}