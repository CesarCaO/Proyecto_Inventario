
package Views;

import Util.PasswordEncryption;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import models.Administrador;
import opCRUD.CRUDAdmin;


public class ViewAdmin extends javax.swing.JFrame {

    CRUDAdmin crudAdmin=new CRUDAdmin();
    Administrador admin=null;
    private boolean updateDelete;
    
    public ViewAdmin(Administrador admin) {
        this.admin=admin;
        initComponents();
        createTable();
        ///////////////////////////////////
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        ///////////////////////////////////
        btnDelete.setEnabled(false);
        lblNumCuenta.setText(String.valueOf(admin.getCuentaAdmin()));
        String nombreCompleto=admin.getNombre()+" "+admin.getApellidoPaterno()+" "+admin.getApellidoMaterno();
        lblNombre.setText(nombreCompleto);
        pnlPrincipal.requestFocus();
        
        try{
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception err){
            err.printStackTrace();
        }
    }
    
    public ViewAdmin(){}
    
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
  
   
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
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
        btnAdd = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtTelefono = new javax.swing.JTextField();
        checkExtension = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        txtCorreo = new javax.swing.JTextField();
        txtCuenta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNumCuenta = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPrincipalMouseClicked(evt);
            }
        });

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
        tblAdmin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblAdminFocusLost(evt);
            }
        });
        tblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAdmin);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nombre del Administrador"));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        lblApellido.setText("Apellido Paterno");

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
                        .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(lblApellido))
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

        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Número de cuenta", "Nombre del administrador", "Apellido paterno del administrador", "Apellido materno del administrador", "Teléfono" }));

        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel6.setText("Buscar según");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        passwordONE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordONEFocusLost(evt);
            }
        });

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
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar registro");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("Agregar administrador");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Número de teléfono"));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });

        checkExtension.setText("Extensión");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkExtension))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Correo electrónico"));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

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
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Número de cuenta:");

        jLabel9.setText("Nombre:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(lblNumCuenta)
                    .addComponent(lblNombre))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(33, 33, 33)
                        .addComponent(btnCancel))
                    .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnGoBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnGoBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
       limpiarCampos();
       passwordONE.setEnabled(true);
       passwordConfirm.setEnabled(true);
       btnDelete.setEnabled(false);
        
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        boolean bandera=false;
        String nombre=null,apellidoPaterno=null, apellidoMaterno=null, telefono=null, correo=null, StringPasswordONE=null, StringPasswordConfirm=null,hashedPasswordONE=null,hashedPasswordConfirm=null;
        int  numCuenta=-1;
        ///////////////////////////////////////Apellido Materno/////////////////////////////////////////////////////////////////////////////
        if(txtApellidoM.getText().isEmpty()||!txtApellidoM.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
           JOptionPane.showMessageDialog(null, "Debe de introducir su apellido materno correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true;
        }else{
            apellidoMaterno=txtApellidoM.getText();
        }
        ////////////////////////////////////////////Apellido Paterno//////////////////////////////////////////////////////////////////////////////
        if(txtApellidoP.getText().isEmpty()||!txtApellidoP.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
           JOptionPane.showMessageDialog(null, "Debe de introducir su apellido paterno correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true;
        }else{
            apellidoPaterno=txtApellidoP.getText();
        }
        ////////////////////////////////////////////Nombre/////////////////////////////////////////////////////////////////////////////////////
        if(txtNombre.getText().isEmpty()||!txtNombre.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
           JOptionPane.showMessageDialog(null, "Debe de introducir su nombre(s) correctamente", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true;
        }else{
            nombre=txtNombre.getText();
        }
        ////////////////////////////////////////////Telefono/////////////////////////////////////////////////////////////////////////////////////
        if(txtTelefono.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe de instroducir un número de teléfono\n", "ERROR", JOptionPane.ERROR_MESSAGE);
            bandera=true;
        }else{
            if(validarTelefono(txtTelefono.getText(),checkExtension.isSelected())){
                telefono=txtTelefono.getText();
            }else{
                JOptionPane.showMessageDialog(null, "El número de telefono es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
                bandera=true;
            }
        }
        ////////////////////////////////////////////Correo/////////////////////////////////////////////////////////////////////////////////////
        if(txtCorreo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe de introducir un correo electrónico", "ERROR", JOptionPane.ERROR_MESSAGE);
            bandera=true;
        }else{
            correo=txtCorreo.getText();
            if(!validarCorreo(correo)){
                JOptionPane.showMessageDialog(null, "El correo electrónico es invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
                bandera=true;
            }
        }
        ////////////////////////////////////////////Número de cuenta/////////////////////////////////////////////////////////////////////////////////////
        if(txtCuenta.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Debe de introducir su número de cuenta valido", "Error", JOptionPane.ERROR_MESSAGE);
            bandera=true;
        }else{
            try{
            numCuenta=Integer.parseInt(txtCuenta.getText());
            }catch(NumberFormatException err){
                JOptionPane.showMessageDialog(null,"El número de cuenta es valido","Error",JOptionPane.ERROR_MESSAGE);
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
        if (!bandera) {
            Administrador newAdmin = new Administrador();
            newAdmin.setCuentaAdmin(numCuenta);
            if (crudAdmin.ValidarAdministrador(newAdmin.getCuentaAdmin())) {
                JOptionPane.showMessageDialog(null, "El administrador ya esta dado de alta en el sistema", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                newAdmin.setApellidoPaterno(apellidoPaterno);
                newAdmin.setApellidoMaterno(apellidoMaterno);
                newAdmin.setNombre(nombre);
                newAdmin.setTelefono(telefono);
                newAdmin.setCorreo(correo);
                newAdmin.setContrasenia(hashedPasswordONE);
                crudAdmin.save(newAdmin);
                JOptionPane.showMessageDialog(null,"Se dio de alta el siguiente administrador: \n"+newAdmin,"INFO", JOptionPane.INFORMATION_MESSAGE);
                char[] hashedPasswordChars = hashedPasswordONE.toCharArray();//Convertir la hashesPassword en carateres para limpiarlo
                Arrays.fill(hashedPasswordChars, '\0');//Limpiar la contraseña encriptada
                limpiarCampos();
                createTable();
            }
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void txtCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuentaActionPerformed
        
    }//GEN-LAST:event_txtCuentaActionPerformed

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
     
    }//GEN-LAST:event_txtTelefonoFocusLost

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
       
    }//GEN-LAST:event_txtCorreoFocusLost

    private void tblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdminMouseClicked
       
       txtApellidoP.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),1).toString());
       txtApellidoM.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),2).toString());
       txtNombre.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),3).toString());
       txtTelefono.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),5).toString());
       txtCorreo.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),4).toString());
       txtCuenta.setText(tblAdmin.getValueAt(tblAdmin.getSelectedRow(),0).toString());
       txtApellidoP.setEditable(false);
       txtApellidoM.setEditable(false);
       txtNombre.setEditable(false);
       txtTelefono.setEditable(false);
       txtCorreo.setEditable(false);
       txtCuenta.setEditable(false);
       passwordONE.setEnabled(false);
       passwordConfirm.setEnabled(false);
       btnDelete.setEnabled(true);
       btnAdd.setEnabled(false);
       updateDelete=true;
       
       
    }//GEN-LAST:event_tblAdminMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
 /***       
        if(txtCuenta.getText().isEmpty()){     
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro para eliminarlo", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
 
            if (admin.getCuentaAdmin() == Integer.parseInt(tblAdmin.getValueAt(tblAdmin.getSelectedRow(), 0).toString())) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar a si mismo\n Si quiere eliminar su cuenta vaya a Ajustes de perfil", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (JOptionPane.showConfirmDialog(null, "Esta a punto de eliminar el administrador con los siguientes datos: \n"
                        +"Número de cuenta: "+ tblAdmin.getValueAt(tblAdmin.getSelectedRow(),0).toString()+"\n"
                        +"Apellido Paterno: "+ tblAdmin.getValueAt(tblAdmin.getSelectedRow(),1).toString()+"\n"
                        +"Apellido Materno: "+ tblAdmin.getValueAt(tblAdmin.getSelectedRow(),2).toString()+"\n"
                        +"Nombre: "+tblAdmin.getValueAt(tblAdmin.getSelectedRow(),3).toString()+"\n"
                        +"Correo: "+tblAdmin.getValueAt(tblAdmin.getSelectedRow(),4).toString()+"\n"
                        +"Telefono: "+tblAdmin.getValueAt(tblAdmin.getSelectedRow(),5).toString(),"Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    crudAdmin.delete(Integer.parseInt(tblAdmin.getValueAt(tblAdmin.getSelectedRow(), 0).toString()));
                    limpiarCampos();
                    createTable();
                    btnDelete.setEnabled(false);
                    txtApellidoP.setEditable(true);
                    txtApellidoM.setEditable(true);
                    txtNombre.setEditable(true);
                    txtTelefono.setEditable(true);
                    txtCorreo.setEditable(true);
                    txtCuenta.setEditable(true);
                    btnAdd.setEnabled(true);
                    passwordONE.setEnabled(true);
                    passwordConfirm.setEnabled(true);
                }
            }
        }

 ***/    
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void passwordONEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordONEFocusLost
        
    }//GEN-LAST:event_passwordONEFocusLost

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        createTable();
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        if(updateDelete){
            limpiarCampos();
            passwordONE.setEnabled(true);
            passwordConfirm.setEnabled(true);
            updateDelete=true;
            pnlPrincipal.requestFocus();
        }else{
            pnlPrincipal.requestFocus();
        }
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        if(updateDelete){
            limpiarCampos();
            passwordONE.setEnabled(true);
            passwordConfirm.setEnabled(true);
            updateDelete=true;
            pnlPrincipal.requestFocus();
        }else{
            pnlPrincipal.requestFocus();
        }
    }//GEN-LAST:event_jPanel5MouseClicked

    private void pnlPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPrincipalMouseClicked
        if(updateDelete){
            limpiarCampos();
            passwordONE.setEnabled(true);
            passwordConfirm.setEnabled(true);
            updateDelete=true;
            pnlPrincipal.requestFocus();
        }else{
            pnlPrincipal.requestFocus();
        }
    }//GEN-LAST:event_pnlPrincipalMouseClicked

    private void tblAdminFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblAdminFocusLost
        if(!updateDelete){
            limpiarCampos();
        }
    }//GEN-LAST:event_tblAdminFocusLost

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        if(updateDelete){
            limpiarCampos();
            passwordONE.setEnabled(true);
            passwordConfirm.setEnabled(true);
            updateDelete=true;
            pnlPrincipal.requestFocus();
        }else{
            pnlPrincipal.requestFocus();
        }
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        if(updateDelete){
            limpiarCampos();
            passwordONE.setEnabled(true);
            passwordConfirm.setEnabled(true);
            updateDelete=true;
            pnlPrincipal.requestFocus();
        }else{
            pnlPrincipal.requestFocus();
        }
    }//GEN-LAST:event_jPanel4MouseClicked

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        if(updateDelete){
            limpiarCampos();
            btnDelete.setEnabled(false);
            updateDelete=false;
        }
    }//GEN-LAST:event_txtBuscarFocusGained

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new MenuAdmin(admin).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

  
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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JCheckBox checkExtension;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumCuenta;
    private javax.swing.JPasswordField passwordConfirm;
    private javax.swing.JPasswordField passwordONE;
    private javax.swing.JPanel pnlPrincipal;
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
