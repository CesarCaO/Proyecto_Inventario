
package Views;

import Util.PasswordEncryption;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import models.Administrador;
import opCRUD.CRUDAdmin;


public class ViewAjustesPerfil extends javax.swing.JFrame {
    
    Administrador admin=null;
    CRUDAdmin crudAdmin=new CRUDAdmin();
    boolean cambiarContrasenia=false;
  
    public ViewAjustesPerfil(Administrador admin) {
        initComponents();
        this.admin=admin;
        rellenarCampos();
        pnlPrincipal.requestFocus();
        passwordONE.setEnabled(false);
        passwordConfirm.setEnabled(false);
        btnUpdate.setEnabled(false);
    }
   
    public ViewAjustesPerfil(){}

   public void rellenarCampos(){
        txtPaterno.setText(admin.getApellidoPaterno());
        txtMaterno.setText(admin.getApellidoMaterno());
        txtNombre.setText(admin.getNombre());
        txtCuenta.setText(String.valueOf(admin.getCuentaAdmin()));
        txtCorreo.setText(admin.getCorreo());
        txtTelefono.setText(admin.getTelefono());
   }
   
    public boolean validarTelefono(String telefono, boolean extension) {
        boolean valido = false;        
        if (extension) {
            String regex = "^\\d{6}+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(telefono.trim());
            valido = matcher.matches();
            return valido;
        } else {
            String regex = "^\\d{10}+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(telefono.trim());
            valido = matcher.matches();
            return valido;
        }  
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
        pnlPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        checkExtension = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        passwordONE = new javax.swing.JPasswordField();
        passwordConfirm = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnCambiarContraseña = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ajustes de Perfil"));

        pnlPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos Generales"));
        pnlPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPrincipalMouseClicked(evt);
            }
        });

        jLabel1.setText("Apellido Paterno:");

        jLabel2.setText("Apellido Materno:");

        jLabel3.setText("Nombre Completo:");

        txtPaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPaternoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPaternoFocusLost(evt);
            }
        });
        txtPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaternoActionPerformed(evt);
            }
        });
        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaternoKeyReleased(evt);
            }
        });

        txtMaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaternoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaternoFocusLost(evt);
            }
        });
        txtMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaternoKeyReleased(evt);
            }
        });

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        jLabel6.setText("Numero de cuenta:");

        txtCuenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCuentaFocusLost(evt);
            }
        });
        txtCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCuentaKeyReleased(evt);
            }
        });

        jLabel7.setText("Correo Electrónico:");

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });

        jLabel8.setText("Telefono:");

        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });

        checkExtension.setText("Extensión");
        checkExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkExtensionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPaterno)
                            .addComponent(txtMaterno)
                            .addComponent(txtNombre)
                            .addComponent(txtCorreo)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkExtension))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Contraseña"));

        passwordONE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordONEFocusLost(evt);
            }
        });
        passwordONE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordONEKeyReleased(evt);
            }
        });

        passwordConfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordConfirmKeyReleased(evt);
            }
        });

        jLabel4.setText("Constraseña");

        jLabel5.setText("Confirmar contraseña");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordONE, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jButton1.setText("Regresar");

        btnCambiarContraseña.setText("Cambiar Contraseña");
        btnCambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraseñaActionPerformed(evt);
            }
        });

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(btnCambiarContraseña)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnCambiarContraseña)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel))
                .addContainerGap())
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

    private void passwordONEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordONEFocusLost

    }//GEN-LAST:event_passwordONEFocusLost

    private void checkExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkExtensionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkExtensionActionPerformed

    private void txtPaternoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPaternoFocusGained
        
    }//GEN-LAST:event_txtPaternoFocusGained

    private void txtMaternoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaternoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaternoFocusGained

    private void txtPaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoKeyReleased
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_txtPaternoKeyReleased

    private void txtMaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaternoKeyReleased
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_txtMaternoKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtCuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaKeyReleased
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_txtCuentaKeyReleased

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_txtCorreoKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void passwordONEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordONEKeyReleased
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_passwordONEKeyReleased

    private void passwordConfirmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordConfirmKeyReleased
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_passwordConfirmKeyReleased

    private void txtPaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPaternoFocusLost
        
    }//GEN-LAST:event_txtPaternoFocusLost

    private void txtPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaternoActionPerformed

    private void txtMaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaternoFocusLost
        
    }//GEN-LAST:event_txtMaternoFocusLost

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtCuentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCuentaFocusLost
        
    }//GEN-LAST:event_txtCuentaFocusLost

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
      
    }//GEN-LAST:event_txtTelefonoFocusLost

    private void pnlPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPrincipalMouseClicked
        pnlPrincipal.requestFocus();
    }//GEN-LAST:event_pnlPrincipalMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        System.out.println("Iniciando actualización");
        boolean bandera = false;
        String nombre = null, apellidoPaterno = null, apellidoMaterno = null, telefono = null, correo = null, hashedPasswordONE = null, StringPasswordONE=null,
        StringPasswordConfirm=null;
        int numCuenta = -1;
        Administrador newAdmin=new Administrador();
         ///////////////////////////////////////Apellido Materno/////////////////////////////////////////////////////////////////////////////
         if(txtMaterno.getText().isEmpty()||!txtMaterno.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
           JOptionPane.showMessageDialog(null, "Debe de introducir su apellido materno correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true;
           rellenarCampos();
        }else{
            apellidoMaterno=txtMaterno.getText();
            System.out.println("Apellido Materno adquirido");
        }
         ///////////////////////////////////////Apellido Paterno/////////////////////////////////////////////////////////////////////////////
         if(txtPaterno.getText().isEmpty()||!txtPaterno.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
           JOptionPane.showMessageDialog(null, "Debe de introducir su apellido paterno correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true;
           rellenarCampos();
        }else{
            apellidoPaterno=txtPaterno.getText();
            System.out.println("Apellido Paterno adquirido");
        }
         ///////////////////////////////////////Nombre/////////////////////////////////////////////////////////////////////////////
        if(txtNombre.getText().isEmpty()||!txtNombre.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
           JOptionPane.showMessageDialog(null, "Debe de introducir su nombre(s) correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true;
           rellenarCampos();
        }else{
            nombre=txtNombre.getText();
            System.out.println("Nombre adquirido");
        }
         ///////////////////////////////////////Telefono/////////////////////////////////////////////////////////////////////////////
        if(txtTelefono.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe de instroducir un número de teléfono\n", "ERROR", JOptionPane.ERROR_MESSAGE);
            bandera=true;
            rellenarCampos();
        }else{
            if(validarTelefono(txtTelefono.getText(),checkExtension.isSelected())){
                telefono=txtTelefono.getText();
                System.out.println("Telefono adquirido");
            }else{
                JOptionPane.showMessageDialog(null, "El número de telefono es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
                bandera=true;
            }
        }
         ///////////////////////////////////////Correo/////////////////////////////////////////////////////////////////////////////
        if(txtCorreo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe de introducir un correo electrónico", "ERROR", JOptionPane.ERROR_MESSAGE);
            bandera=true;
            rellenarCampos();
        }else{
            correo=txtCorreo.getText();
            
            System.out.println("Correo adquirido");
            if(!validarCorreo(correo)){
                JOptionPane.showMessageDialog(null, "El correo electrónico es invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
                bandera=true;
                rellenarCampos();
            }
        }
         ///////////////////////////////////////Número de cuenta/////////////////////////////////////////////////////////////////////////////
        if (txtCuenta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de introducir su número de cuenta", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
            rellenarCampos();
        } else {
            try {
                numCuenta = Integer.parseInt(txtCuenta.getText());
                System.out.println("Num Cuenta adquirido");
            } catch (NumberFormatException err) {
                JOptionPane.showMessageDialog(null, "El número de cuenta es invalido", "Error", JOptionPane.ERROR_MESSAGE);
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
                    passwordConfirm.setText("");
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
 
        if (!bandera) {
            newAdmin.setCuentaAdmin(numCuenta);
            if(newAdmin.getCuentaAdmin()==admin.getCuentaAdmin()){
                newAdmin.setApellidoPaterno(apellidoPaterno);
                newAdmin.setApellidoMaterno(apellidoMaterno);
                newAdmin.setNombre(nombre);
                newAdmin.setTelefono(telefono);
                newAdmin.setCorreo(correo);
                newAdmin.setContrasenia(hashedPasswordONE);
                crudAdmin.update(newAdmin,admin.getCuentaAdmin());
                admin=newAdmin;
                rellenarCampos();
                btnUpdate.setEnabled(false);
                passwordONE.setEnabled(false);
                passwordConfirm.setEnabled(false);
                
            }else{
                 if (crudAdmin.ValidarAdministrador(newAdmin.getCuentaAdmin())) {
                JOptionPane.showMessageDialog(null, "El administrador ya esta dado de alta en el sistema", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                     newAdmin.setApellidoPaterno(apellidoPaterno);
                     newAdmin.setApellidoMaterno(apellidoMaterno);
                     newAdmin.setNombre(nombre);
                     newAdmin.setTelefono(telefono);
                     newAdmin.setCorreo(correo);
                     newAdmin.setContrasenia(hashedPasswordONE);
                     crudAdmin.update(newAdmin,admin.getCuentaAdmin());
                     admin=newAdmin;
                     rellenarCampos();
                     btnUpdate.setEnabled(false);
                     passwordONE.setEnabled(false);
                     passwordConfirm.setEnabled(false);
                     
                 }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraseñaActionPerformed
        passwordONE.setEnabled(true);
        passwordConfirm.setEnabled(true);
        cambiarContrasenia=true;
    }//GEN-LAST:event_btnCambiarContraseñaActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        passwordONE.setText("");
        passwordConfirm.setText("");
        btnUpdate.setEnabled(false);
        rellenarCampos();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ViewAjustesPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAjustesPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAjustesPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAjustesPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAjustesPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarContraseña;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox checkExtension;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField passwordConfirm;
    private javax.swing.JPasswordField passwordONE;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
