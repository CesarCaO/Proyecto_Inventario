
package Views;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import models.Administrador;
import models.Gabinete;
import opCRUD.CRUDGabinete;


public class ViewGabinete extends javax.swing.JFrame {

   CRUDGabinete crudGabinete=new CRUDGabinete();
   boolean update=false;//Variable para la activación de los botones
   Administrador admin;
    public ViewGabinete(Administrador admin) {
        this.admin=admin;
        initComponents();
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        createTable();
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(false);
        btnCancel.setEnabled(false);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        pnlPrincipal.requestFocus();
        lblNumCuenta.setText(String.valueOf(admin.getCuentaAdmin()));
        String nombreCompleto=admin.getNombre()+" "+admin.getApellidoPaterno()+" "+admin.getApellidoMaterno();
        lblNombre.setText(nombreCompleto);
        setIconImage(new ImageIcon(getClass().getResource("/garza.png")).getImage());
        tblGabinete.getTableHeader().setReorderingAllowed(false);
    }
    public ViewGabinete(){}
    public void createTable(){
        tblGabinete.setModel(crudGabinete.opBuscar("numGabinete", txtBuscar.getText()));
    }
    
    public void limpiarCampos(){
        txtNumero.setText("");
        txtDescripcion.setText("");
        tblGabinete.clearSelection();
        update=false;
        
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNumCuenta = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Gabinete"));
        pnlPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPrincipalMouseClicked(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroKeyReleased(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });
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
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

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
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFocusLost(evt);
            }
        });
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
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

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

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Número de cuenta:");

        jLabel4.setText("Nombre:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(lblNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                        .addGroup(pnlPrincipalLayout.createSequentialGroup()
                            .addComponent(btnGoBack)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate)
                            .addGap(18, 18, 18)
                            .addComponent(btnDelete))
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap(7, Short.MAX_VALUE))
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
        
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        if (txtNumero.getText().isEmpty()) {//Validación para que el usuario elija un registro a eliminar
            JOptionPane.showMessageDialog(null, "Debe elegir un registro para eliminarlo", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este registro?.\n Todos los registros del inventario relacionados a él se eliminaran") == JOptionPane.YES_OPTION) {
                if (crudGabinete.delete(Integer.parseInt(tblGabinete.getValueAt(tblGabinete.getSelectedRow(), 0).toString()))) {
                    createTable();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error en al eliminar el registro", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        boolean bandera=false;//Bandera de errores
        int numGabinete=-1;
        String descripcion=null;
        
        if(txtNumero.getText().isEmpty()){//Si esta vacio el texto del número
           JOptionPane.showMessageDialog(null, "Debe asignar un número al gabinete", "ERROR", JOptionPane.ERROR_MESSAGE);
           bandera=true;
        }else{
            try{//Try para valida que el texto introducido sea un texto
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
                if (JOptionPane.showConfirmDialog(null, "¿Desea agregar el siguiente gabiente?:\n" +"Número de Gabinete: "+ newgabinete.getNumGabinete() + "\n" +"Descripción: "+ newgabinete.getDescripcion() + "\n") == JOptionPane.YES_OPTION) {
                    
                    if (crudGabinete.save(newgabinete)) {
   
                        limpiarCampos();
                        btnAdd.setEnabled(false);
                        btnCancel.setEnabled(false);
                        createTable();
                        JOptionPane.showMessageDialog(null, "Registro completado", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                        
                    } else {
                        
                        JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "ERROR", JOptionPane.ERROR_MESSAGE);
                        
                    }
                } 
            }
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void tblGabineteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGabineteMouseClicked
        txtNumero.setText(tblGabinete.getValueAt(tblGabinete.getSelectedRow(),0).toString());
        txtDescripcion.setText(tblGabinete.getValueAt(tblGabinete.getSelectedRow(),1).toString());
        update=true;
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnCancel.setEnabled(true);
        
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
            if(newgabinete.getNumGabinete()==Integer.parseInt(tblGabinete.getValueAt(tblGabinete.getSelectedRow(),0).toString())){//Si el número del gabinete selección entonces solo sea agrega la descripción y se guarda 
                
                newgabinete.setDescripcion(descripcion);
                if(JOptionPane.showConfirmDialog(null, "¿Desea cambiar el gabinete\n"
                            + "Número de Gabinete: "+tblGabinete.getValueAt(tblGabinete.getSelectedRow(),0)+"\n"+
                            "Descripción: "+tblGabinete.getValueAt(tblGabinete.getSelectedRow(),1)+"\n"+
                            "Por\n"+
                            newgabinete,"Confirmar Actualización",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){//Confirmación de actualización
                        
                        if (crudGabinete.update(newgabinete, Integer.parseInt(tblGabinete.getValueAt(tblGabinete.getSelectedRow(), 0).toString()))) {//Si todo sale bien en la acualización
                            btnUpdate.setEnabled(false);
                            btnDelete.setEnabled(false);
                            limpiarCampos();
                            createTable();
                            JOptionPane.showMessageDialog(null, "Registro actualizado", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                            
                        }else{//Si hubo un error en la actualización
                            
                            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "ERROR", JOptionPane.ERROR_MESSAGE);
                            
                        }
                    }
            }else {///Si el número del gabinete es distinto hay que verificar si el nuevo número no ha sido introducido en el sistema
                
                if (crudGabinete.validarGabinete(newgabinete.getNumGabinete())) {//Validar la existencia del gabinete. Verdadero: El gabinete ya esta en el sistema
                    JOptionPane.showMessageDialog(null, "Este gabinete ya esta dado de alta", "ERROR", JOptionPane.ERROR_MESSAGE);
                    System.out.print("Dentro del IF de la validación del gabinete");
                } else {//Si no esta dadod de alta en el sistema inicia el proceso de actualización
                    newgabinete.setDescripcion(descripcion);
                    System.out.print("Dentro del else de la validación del gabinete");
                    if(JOptionPane.showConfirmDialog(null, "¿Desea cambiar el gabinete\n"
                            + "Número de Gabinete: "+tblGabinete.getValueAt(tblGabinete.getSelectedRow(),0)+
                            "Descripción: "+tblGabinete.getValueAt(tblGabinete.getSelectedRow(),1)+
                            "Por\n"+
                            newgabinete,"Confirmar Actualización",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){//Confirmación de actualización
                        
                        if (crudGabinete.update(newgabinete, Integer.parseInt(tblGabinete.getValueAt(tblGabinete.getSelectedRow(), 0).toString()))) {//Si todo sale bien en la actualización se actualiza el registro
                            btnUpdate.setEnabled(false);
                            btnDelete.setEnabled(false);
                            limpiarCampos();
                            createTable();
                            JOptionPane.showMessageDialog(null, "Registro acualizado", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                            
                        }else{//En caso de que haya un error en la actualización
                            
                            JOptionPane.showMessageDialog(null, "Hubo un error en el registro", "ERROR", JOptionPane.ERROR_MESSAGE);
                            
                        }
                    }
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
        
        
    }//GEN-LAST:event_tblGabineteFocusLost

    private void txtNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyReleased
        if(txtNumero.getText().isEmpty()||update){
            btnAdd.setEnabled(false);
            btnCancel.setEnabled(false);
        }else{
            btnAdd.setEnabled(true);
            btnCancel.setEnabled(true);
        }
    }//GEN-LAST:event_txtNumeroKeyReleased

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        if(txtDescripcion.getText().isEmpty()||update){
            btnAdd.setEnabled(false);
            btnCancel.setEnabled(false);
        }else{
            btnAdd.setEnabled(true);
            btnCancel.setEnabled(true);
        }
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        update=false;
    }//GEN-LAST:event_txtBuscarFocusLost

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
         if(update){
            limpiarCampos();
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
            pnlPrincipal.requestFocus();
  
        }
    }//GEN-LAST:event_txtBuscarFocusGained

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        limpiarCampos();
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(false);
        btnCancel.setEnabled(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        pnlPrincipal.requestFocus();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        pnlPrincipal.requestFocus();
    }//GEN-LAST:event_jPanel5MouseClicked

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumCuenta;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTable tblGabinete;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
