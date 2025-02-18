
package Views;

import Util.PasswordEncryption;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import models.Administrador;
import opCRUD.CRUDAdmin;


public class ViewAdmin extends javax.swing.JFrame {

    CRUDAdmin crudAdmin=new CRUDAdmin();
    boolean cambiarContrasenia=false;
    
    public ViewAdmin() {
        initComponents();
        createTable();
    }
    
    public void createTable(){
        tblAdmin.setModel(crudAdmin.opBuscar(cmbBuscar.getSelectedItem().toString(), txtBuscar.getText()));
    }
    public void limpiarCampos(){
        txtApellidoP.setText("");
        txtApellidoM.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtCuenta.setText("");
        passwordONE.setText("");
        passwordConfirm.setText("");
        tblAdmin.clearSelection();
    }
    
   public boolean validarCorreo(String correo){
       String regex="[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
       Pattern pattern=Pattern.compile(regex);
       Matcher matcher=pattern.matcher(correo);
       return matcher.matches();
   }
   
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cmbBuscar = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        passwordONE = new javax.swing.JPasswordField();
        passwordConfirm = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnGoBack = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtTelefono = new javax.swing.JTextField();
        cmbTel = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        txtCorreo = new javax.swing.JTextField();
        txtCuenta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnCambiarContrasenia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAdmin);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nombre del Administrador"));

        jLabel1.setText("Apellido Paterno");

        jLabel2.setText("Apellido Materno");

        jLabel3.setText("Nombre(s)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Buscar"));

        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Número de cuenta", "Nombre del administrador", "Teléfono" }));

        jLabel6.setText("Buscar según");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Contraseña"));

        jLabel4.setText("Constraseña");

        jLabel5.setText("Confirmar contraseña");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addComponent(passwordONE, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        btnGoBack.setText("Regresar");

        btnCancel.setText("Limpiar todos los campos");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar registro");

        btnUpdate.setText("Actualizar registro");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setText("Agregar administrador");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Número de teléfono"));

        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });

        cmbTel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+52", "Ext" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(cmbTel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Correo electrónico"));

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });

        txtCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuentaActionPerformed(evt);
            }
        });

        jLabel7.setText("Correo electrónico");

        jLabel8.setText("Número de cuenta");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnCambiarContrasenia.setText("Cambiar Contraseña");
        btnCambiarContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraseniaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 345, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 345, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnCambiarContrasenia)
                                .addGap(223, 223, 223)
                                .addComponent(btnDelete))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGoBack)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnGoBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnCancel)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnCambiarContrasenia))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        boolean bandera=false;
        String nombre=null,apellidoPaterno=null, apellidoMaterno=null, telefono=null, correo=null, StringPasswordONE=null, StringPasswordConfirm=null,hashedPasswordONE=null,hashedPasswordConfirm=null;
        int  numCuenta=-1;
        
        if(txtApellidoM.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Debe de introducir su apellido materno", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true;
        }else{
            apellidoMaterno=txtApellidoM.getText();
        }
        if(txtApellidoP.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Debe de introducir su apellido paterno", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true;
        }else{
            apellidoPaterno=txtApellidoP.getText();
        }
        if(txtNombre.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Debe de introducir su nombre(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true;
        }else{
            nombre=txtNombre.getText();
        }
        
        if(txtTelefono.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe de instroducir su número de teléfono", "ERROR", JOptionPane.ERROR_MESSAGE);
            bandera=true;
        }else{
            telefono=cmbTel.getSelectedItem()+" "+txtTelefono.getText();
        }
        if(txtCorreo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe de introducir su nombre completo", "ERROR", JOptionPane.ERROR_MESSAGE);
            bandera=true;
        }else{
            correo=txtCorreo.getText();
            if(!validarCorreo(correo)){
               JOptionPane.showMessageDialog(null, "El correo no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
               bandera=true; 
            }
        }
        if(txtCuenta.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Debe de introducir su número de cuenta", "Error", JOptionPane.ERROR_MESSAGE);
            bandera=true;
        }else{
            try{
            numCuenta=Integer.parseInt(txtCuenta.getText());
            }catch(NumberFormatException err){
                JOptionPane.showMessageDialog(null,"No debe de haber letras en el número de cuenta","Error",JOptionPane.ERROR_MESSAGE);
                bandera=true;
            }
        }
//*****************Apartado para la encriptacion y validacion de la contrasenias*******************//
        char[] passwordCharsONE= passwordONE.getPassword();
        char[] passwordCharsConfirm=passwordConfirm.getPassword();
        
        if(passwordCharsConfirm.length==0 && passwordCharsONE.length==0){
            JOptionPane.showMessageDialog(null,"Debe de introducir una contraseña y confirmarla", "Error", JOptionPane.ERROR_MESSAGE);
            bandera=true;
        }else{
            StringPasswordONE=new String(passwordCharsONE);
            StringPasswordConfirm=new String(passwordCharsConfirm);
            
            if(!StringPasswordONE.equals(StringPasswordConfirm)){
               JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE); 
               StringPasswordONE=null;
               StringPasswordConfirm=null;
               Arrays.fill(passwordCharsONE,'\0');//Limpieza de caracteres de la contraseña
               Arrays.fill(passwordCharsConfirm,'\0');//Limpieza de caracteres de la contraseña
               bandera=true;
            }else{
               hashedPasswordONE=PasswordEncryption.encryptionPassword(StringPasswordONE);
               Arrays.fill(passwordCharsONE,'\0');//Liempieza de caracteres de la contraseña
               Arrays.fill(passwordCharsConfirm,'\0');//Limpieza de caracteres de la contraseña
              
            }   
        }
      if(!bandera){
          Administrador newAdmin=new Administrador();
          newAdmin.setApellidoPaterno(apellidoPaterno);
          newAdmin.setApellidoMaterno(apellidoMaterno);
          newAdmin.setNombre(nombre);
          newAdmin.setCuentaAdmin(numCuenta);
          newAdmin.setTelefono(telefono);
          newAdmin.setCorreo(correo);
          newAdmin.setContrasenia(hashedPasswordONE);
          crudAdmin.save(newAdmin);
          char[]hashedPasswordChars=hashedPasswordONE.toCharArray();//Convertir la hashesPassword en carateres para limpiarlo
          Arrays.fill(hashedPasswordChars, '\0');//Limpiar la contraseña encriptada
          limpiarCampos();
          createTable();
      }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuentaActionPerformed
        
    }//GEN-LAST:event_txtCuentaActionPerformed

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        
    }//GEN-LAST:event_txtTelefonoFocusLost

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
       if(!validarCorreo(txtCorreo.getText())){
            JOptionPane.showMessageDialog(null,"El correo introducido no es valido", "Error",JOptionPane.ERROR_MESSAGE);
            txtCorreo.setText("");
        }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void tblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdminMouseClicked
       
       txtApellidoP.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),1).toString());
       txtApellidoM.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),2).toString());
       txtNombre.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),3).toString());
       txtTelefono.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),5).toString());
       txtCorreo.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),4).toString());
       txtCuenta.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),0).toString());
       passwordONE.setEnabled(false);
       passwordConfirm.setEnabled(false);           
    }//GEN-LAST:event_tblAdminMouseClicked

    private void btnCambiarContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraseniaActionPerformed
       passwordONE.setEnabled(true);
       passwordConfirm.setEnabled(true);
       cambiarContrasenia=true;
    }//GEN-LAST:event_btnCambiarContraseniaActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        boolean bandera = false;
        String nombre = null, apellidoPaterno = null, apellidoMaterno = null, telefono = null, correo = null, StringPasswordONE = null, StringPasswordConfirm = null, hashedPasswordONE = null, hashedPasswordConfirm = null;
        int numCuenta = -1;
        Administrador newAdmin=new Administrador();

        if (txtApellidoM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de introducir su apellido materno", "ERROR", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        } else {
            apellidoMaterno = txtApellidoM.getText();
        }
        if (txtApellidoP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de introducir su apellido paterno", "ERROR", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        } else {
            apellidoPaterno = txtApellidoP.getText();
        }
        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de introducir su nombre(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        } else {
            nombre = txtNombre.getText();
        }

        if (txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de instroducir su número de teléfono", "ERROR", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        } else {
           telefono=cmbTel.getSelectedItem()+" "+txtTelefono.getText();
        }
        if (txtCorreo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de introducir su nombre completo", "ERROR", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        } else {
            correo = txtCorreo.getText();
            if (!validarCorreo(correo)) {
                JOptionPane.showMessageDialog(null, "El correo no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
                bandera = true;
            }
        }
        if (txtCuenta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de introducir su número de cuenta", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        } else {
            try {
                numCuenta = Integer.parseInt(txtCuenta.getText());
            } catch (NumberFormatException err) {
                JOptionPane.showMessageDialog(null, "No debe de haber letras en el número de cuenta", "Error", JOptionPane.ERROR_MESSAGE);
                bandera = true;
            }
        }
        if (cambiarContrasenia) {
            char[] passwordCharsONE = passwordONE.getPassword();
            char[] passwordCharsConfirm = passwordConfirm.getPassword();

            if (passwordCharsConfirm.length == 0 && passwordCharsONE.length == 0) {
                JOptionPane.showMessageDialog(null, "Debe de introducir una contraseña y confirmarla", "Error", JOptionPane.ERROR_MESSAGE);
                bandera = true;
            } else {
                StringPasswordONE = new String(passwordCharsONE);
                StringPasswordConfirm = new String(passwordCharsConfirm);

                if (!StringPasswordONE.equals(StringPasswordConfirm)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                    StringPasswordONE = null;
                    StringPasswordConfirm = null;
                    Arrays.fill(passwordCharsONE, '\0');//Limpieza de caracteres de la contraseña
                    Arrays.fill(passwordCharsConfirm, '\0');//Limpieza de caracteres de la contraseña
                    bandera = true;
                } else {
                    hashedPasswordONE = PasswordEncryption.encryptionPassword(StringPasswordONE);
                    newAdmin.setContrasenia(hashedPasswordONE);
                    Arrays.fill(passwordCharsONE, '\0');//Liempieza de caracteres de la contraseña
                    Arrays.fill(passwordCharsConfirm, '\0');//Limpieza de caracteres de la contraseña
                    char[]hashedPasswordChars=hashedPasswordONE.toCharArray();//Convertir la hashesPassword en carateres para limpiarlo
                    Arrays.fill(hashedPasswordChars, '\0');//Limpiar la contraseña encriptada
                }
                
            }
        }
        
        if(!bandera){
          newAdmin.setApellidoPaterno(apellidoPaterno);
          newAdmin.setApellidoMaterno(apellidoMaterno);
          newAdmin.setNombre(nombre);
          newAdmin.setCuentaAdmin(numCuenta);
          newAdmin.setTelefono(telefono);
          newAdmin.setCorreo(correo); 
          crudAdmin.update(newAdmin, numCuenta);
          limpiarCampos();
          createTable();
          cambiarContrasenia=false;
          
        }
        

    }//GEN-LAST:event_btnUpdateActionPerformed

  
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
            java.util.logging.Logger.getLogger(ViewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCambiarContrasenia;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField passwordConfirm;
    private javax.swing.JPasswordField passwordONE;
    private javax.swing.JTable tblAdmin;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
