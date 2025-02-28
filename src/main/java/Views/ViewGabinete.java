
package Views;

import javax.swing.JOptionPane;
import models.Gabinete;
import opCRUD.CRUDGabinete;


public class ViewGabinete extends javax.swing.JFrame {

   CRUDGabinete crudGabinete=new CRUDGabinete();
   boolean update=false;
    public ViewGabinete() {
        initComponents();
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        createTable();
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    
    public void createTable(){
        tblGabinete.setModel(crudGabinete.opBuscar("numGabinete", txtBuscar.getText()));
    }
    
    public void limpiarCampos(){
        txtNumero.setText("");
        txtDescripcion.setText("");
        tblGabinete.clearSelection();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtNumero = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGabinete = new javax.swing.JTable();
        btnGoBack = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Gabinete"));
        pnlPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPrincipalMouseClicked(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel1.setText("Número de gabinete");

        jLabel2.setText("Descripción");

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(83, 83, 83))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnCancel))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Buscar"));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tblGabinete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblGabinete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblGabineteFocusLost(evt);
            }
        });
        tblGabinete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGabineteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGabinete);

        btnGoBack.setText("Regresar");

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(btnGoBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        if(txtNumero.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Debe elegir un registro para eliminarlo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            crudGabinete.delete(Integer.parseInt(tblGabinete.getValueAt(tblGabinete.getSelectedRow(),0).toString()));
            createTable();
            limpiarCampos();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        boolean bandera=false;
        int numGabinete=0;
        String descripcion=null;
        
        if(txtNumero.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Debe asignar un número al gabinete", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true;
        }else{
            try{
                numGabinete=Integer.parseInt(txtNumero.getText());
            }catch(NumberFormatException err){
                JOptionPane.showMessageDialog(null, "El número de gabinete debe de ser entero, sin letras ni signos", "ERROR", JOptionPane.ERROR_MESSAGE);
                bandera=true;
            }
        }
        
        if(txtDescripcion.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Se debe darle una descripción al gabinete", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true; 
        }else{
            descripcion=txtDescripcion.getText();
        }
        
        if (!bandera) {
            Gabinete newgabinete = new Gabinete();
            newgabinete.setNumGabinete(numGabinete);
            if (crudGabinete.validarGabinete(newgabinete.getNumGabinete())) {
                JOptionPane.showMessageDialog(null, "Este gabinete ya esta dado de alta", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                newgabinete.setDescripcion(descripcion);
                crudGabinete.save(newgabinete);
                limpiarCampos();
                createTable();
            }
        }
        
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblGabineteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGabineteMouseClicked
        txtNumero.setText(tblGabinete.getValueAt(tblGabinete.getSelectedRow(),0).toString());
        txtDescripcion.setText(tblGabinete.getValueAt(tblGabinete.getSelectedRow(),1).toString());
        update=true;
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        
    }//GEN-LAST:event_tblGabineteMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        boolean bandera=false;
        int numGabinete=0;
        String descripcion=null;
        
        if(txtNumero.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Debe asignar un número al gabinete", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true;
        }else{
            try{
                numGabinete=Integer.parseInt(txtNumero.getText());
            }catch(NumberFormatException err){
                JOptionPane.showMessageDialog(null, "El número de gabinete debe de ser entero, sin letras ni signos", "ERROR", JOptionPane.ERROR_MESSAGE);
                bandera=true;
            }
        }
        
        if(txtDescripcion.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Se debe darle una descripción al gabinete", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true; 
        }else{
            descripcion=txtDescripcion.getText();
        }
        
        if (!bandera) {
            Gabinete newgabinete = new Gabinete();
            newgabinete.setNumGabinete(numGabinete);
            if(newgabinete.getNumGabinete()==Integer.parseInt(tblGabinete.getValueAt(tblGabinete.getSelectedRow(),0).toString())){
                newgabinete.setDescripcion(descripcion);
                crudGabinete.update(newgabinete,Integer.parseInt(tblGabinete.getValueAt(tblGabinete.getSelectedRow(),0).toString()));
                limpiarCampos();
                createTable();
            }else {
                if (crudGabinete.validarGabinete(newgabinete.getNumGabinete())) {
                    JOptionPane.showMessageDialog(null, "Este gabinete ya esta dado de alta", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    newgabinete.setDescripcion(descripcion);
                    crudGabinete.update(newgabinete, Integer.parseInt(tblGabinete.getValueAt(tblGabinete.getSelectedRow(),0).toString()));
                    limpiarCampos();
                    createTable();
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        createTable();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void pnlPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPrincipalMouseClicked
   
        if(update){
            pnlPrincipal.requestFocus();
            limpiarCampos();
            update=false;
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
        }else{
            pnlPrincipal.requestFocus();
        }
    }//GEN-LAST:event_pnlPrincipalMouseClicked

    private void tblGabineteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblGabineteFocusLost
        
            limpiarCampos();
            update=false;
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
        
    }//GEN-LAST:event_tblGabineteFocusLost

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewGabinete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewGabinete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewGabinete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGabinete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGabinete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTable tblGabinete;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
