/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.encounter;

import Services.ComboItem;
import Services.ValidationServices;
import database.DoctorService;
import database.EncounterService;
import database.PatientService;
import database.VitalSignService;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.SpinnerDateModel;
import model.Doctor;
import model.Encounter;
import model.Patient;
import model.VitalSigns;

/**
 *
 * @author somes
 */
public class CreateEncounterPatientPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateEncounterPatientPanel
     */
   
    PatientService ps = new PatientService();
    DoctorService ds = new DoctorService();
    VitalSignService vs = new VitalSignService();
    JSplitPane mainPanel;
    String types[] = {"General","Surgery"};
    ArrayList<Component> al;
    Patient p;
    public CreateEncounterPatientPanel(Patient p, JSplitPane mainPanel, ArrayList<Component> al) {
        initComponents();
        this.al = al;
        this.mainPanel = mainPanel;
        this.p=p;
      
         this.boxVitalSigns.removeAllItems();
       
        String patientId = this.p.getId();
        ArrayList<VitalSigns> vss = this.vs.getAllvitalsignsOfPatient(patientId);
        if(vss == null) {
            return;
        }
        for(VitalSigns v: vss) {
            this.boxVitalSigns.addItem(new ComboItem(v.getDate()+" BP : "+v.getBloodPressure()+" heart rate: "+v.getHeartRate(), v.getId()));
        }
        ArrayList<Doctor> doctors = this.ds.getAllDoctors();
        if(doctors!=null) {
        for(Doctor doctor: doctors) {
            this.boxDoctors.addItem(new ComboItem(doctor.getEmail(),doctor.getId()));
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        boxVitalSigns = new javax.swing.JComboBox<>();
        boxDoctors = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblCharge = new javax.swing.JLabel();
        timeSpinner = new javax.swing.JSpinner();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Encounter");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Doctor");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Vital Sign");

        boxVitalSigns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxVitalSignsActionPerformed(evt);
            }
        });

        boxDoctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDoctorsActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnAdd.setText("Create");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Date");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Type");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Surgery" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        timeSpinner.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 429, Short.MAX_VALUE)
                .addComponent(lblCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(357, 357, 357))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxVitalSigns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {boxDoctors, boxVitalSigns, jComboBox1, timeSpinner});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, jLabel6});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jLabel1))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxVitalSigns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(lblCharge)
                .addGap(138, 138, 138))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {boxDoctors, boxVitalSigns, jComboBox1, timeSpinner});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, jLabel6});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 865, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxVitalSignsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxVitalSignsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxVitalSignsActionPerformed
void updatecharges() {
        Object item = this.boxDoctors.getSelectedItem();
        if(item == null) {
            return;
        }
        String did = ((ComboItem)item).getValue();
        Doctor d = this.ds.getDoctor(did);
        String type = types[this.jComboBox1.getSelectedIndex()];
        System.out.println(d.getId());
         System.out.println(  d.getConsultation_charges());
        if(type.equals("General")) {
            this.lblCharge.setText(String.valueOf(d.getConsultation_charges()));
        } else {
            this.lblCharge.setText(String.valueOf(d.getSurgery_charges()));

        }
    }
    private void boxDoctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDoctorsActionPerformed
        // TODO add your handling code here:

        updatecharges();

    }//GEN-LAST:event_boxDoctorsActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Date cd = ((SpinnerDateModel)timeSpinner.getModel()).getDate();
        System.out.println(cd);
     
        String patientid = this.p.getId();

        Object item1 = this.boxVitalSigns.getSelectedItem();
        if(item1==null) {
            JOptionPane.showMessageDialog(this, "VitalSigns can't be null");
            return;
        }
        String vitalsignid = ((ComboItem)item1).getValue();

        Object item2 = this.boxDoctors.getSelectedItem();
        if(item2 == null) {
            JOptionPane.showMessageDialog(this, "doctor can't be null");
            return;
        }
        //        if(this.jDateChooser1.getDate() == null) {
            //            JOptionPane.showMessageDialog(this, "date can't be null");
            //            return;
            //        }
        String doctorid = ((ComboItem)item2).getValue();
        String type = types[this.jComboBox1.getSelectedIndex()];
        if((this.lblCharge.getText().isEmpty()) && !(ValidationServices.isNumeric(this.lblCharge.getText()))) {
            JOptionPane.showMessageDialog(this, "Not correct input");
            return;
        }
        double charges = Double.parseDouble(this.lblCharge.getText());
        Encounter ec = new Encounter(vitalsignid,patientid,doctorid,cd,type, charges);
        EncounterService es = new EncounterService();
        es.create(ec);
        JOptionPane.showMessageDialog(this, "Successfully created");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Component c = this.al.get(this.al.size()-1);
        this.al.remove(this.al.size()-1);
        this.mainPanel.setRightComponent(c);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        this.updatecharges();
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ComboItem> boxDoctors;
    private javax.swing.JComboBox<ComboItem> boxVitalSigns;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCharge;
    private javax.swing.JSpinner timeSpinner;
    // End of variables declaration//GEN-END:variables
}
