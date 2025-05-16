/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Views.ViewBarcode;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HexFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableColumn;
import javax.swing.text.NumberFormatter;
import models.Administrador;
import models.CatalogoProductos;
import models.EstadoProducto;
import models.Gabinete;
import models.Marca;
import models.Producto;
import models.TipoProducto;
import opCRUD.CRUDCatalogoProductos;
import opCRUD.CRUDEstadoProducto;
import opCRUD.CRUDGabinete;
import opCRUD.CRUDMarca;
import opCRUD.CRUDProducto;
import opCRUD.CRUDTipoProducto;

/**
 *
 * @author darwi
 */
public class ViewProducto extends javax.swing.JFrame {
    CRUDProducto crudProducto = new CRUDProducto();
    CRUDMarca crudMarca = new CRUDMarca();
    CRUDGabinete crudGabinete = new CRUDGabinete();
    CRUDCatalogoProductos crudCatPro = new CRUDCatalogoProductos();
    CRUDTipoProducto crudTipPro = new CRUDTipoProducto();
    CRUDEstadoProducto crudEstPro = new CRUDEstadoProducto();
    Administrador admin;
    public File selectFile;
    String updateNumInventario = null;
    boolean updateDelete=false;
    public ViewProducto(Administrador admin) {
        initComponents();
        this.admin=admin;
        createTable();
        rellenarCMBMarca();
        rellenarCatPro();
        rellenarGabinete();
        rellenarTipoProducto();
        estadoPro();
        tblProducto.setRowHeight(100);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        txtDireccion.setEditable(false);
        spnCantidad.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        scrollPane.requestFocusInWindow();
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnCancel.setEnabled(false);
        tblProducto.getTableHeader().setReorderingAllowed(false);
        ///Configuración de para que el spinner no acepte texto
        JFormattedTextField ftf = ((JSpinner.NumberEditor)spnCantidad.getEditor()).getTextField();
        NumberFormatter fmt= (NumberFormatter) ftf.getFormatter();
        fmt.setAllowsInvalid(false);
        /////////////////////////////////////////////////////////
        
        //Apartado de datos de la sesión del administrador
        lblNumCuenta.setText(String.valueOf(admin.getCuentaAdmin()));
        String nombreCompleto=admin.getNombre()+" "+admin.getApellidoPaterno()+" "+admin.getApellidoMaterno();
        lblNombre.setText(nombreCompleto);
        pnlPrincipal.requestFocus();
        
        setIconImage(new ImageIcon(getClass().getResource("/garza.png")).getImage());
    
    }
    public ViewProducto(){} 
    
    public void createTable(){
        tblProducto.setModel(crudProducto.opBuscar(cmbBuscar.getSelectedItem().toString(),txtBuscar.getText()));
    }
    
    public void rellenarCMBMarca(){
        List<Marca>marcaList=crudMarca.opRead("","");
        for(Marca marca : marcaList){
            cmbMarca.addItem(marca.getNombreMarca());
        }
    }
    
    public void rellenarCatPro(){
        List<CatalogoProductos>catproList=crudCatPro.opRead("");
        for(CatalogoProductos catpro: catproList){
            cmbCatPro.addItem(catpro.getNombre_producto());
        }
    }
    
    public void rellenarGabinete(){
        List<Gabinete> gabineteList=crudGabinete.opRead("","");
        for(Gabinete gabinete:gabineteList){
           cmbGabinete.addItem(String.valueOf(gabinete.getNumGabinete()));
        }
    }
    
    public void rellenarTipoProducto(){
        List<TipoProducto> tipProList=crudTipPro.opRead("","");
        for(TipoProducto tipoPro:tipProList){
            cmbTipoPro.addItem(tipoPro.getTipo());
        }
    }
    public void estadoPro(){
        List<EstadoProducto> estProList=crudEstPro.opRead("","");
        for(EstadoProducto estpro: estProList ){
            cmbEstadoPro.addItem(estpro.getEstado());
            
        }
    }
    
    public void limpiarCampos(){
        lblImagen.setIcon(null);
        txtDireccion.setText("");
        txtDescripcion.setText("");
        cmbCatPro.setSelectedIndex(0);
        cmbMarca.setSelectedIndex(0);
        cmbTipoPro.setSelectedIndex(0);
        spnCantidad.setValue(0);
        cmbGabinete.setSelectedIndex(0);
        cmbEstadoPro.setSelectedIndex(0);
        tblProducto.clearSelection();
        txtBuscar.setText("");
        btnUpdate.setEnabled(false);
        btnCancel.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(false); 
        checkModelo.setSelected(false);
        checkSerie.setSelected(false);
        checkInstitucional.setSelected(false);
        txtModelo.setText("");
        txtNumSerie.setText("");
        txtInstitucional.setText("");
    }
    /**
    public byte[] generarCodigoBarras(String data) throws IOException, Exception{
        try{
            int width = 10 * data.length();
            int height = 100;
            BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.CODE_128,width,height);
             
            //Convertir el código de barras en un stream sin guardarlo en disco
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            return outputStream.toByteArray();
            
        }catch(WriterException | IOException err){
            
            throw new Exception("Error al generar el código: " + err.getMessage());
        }
    }
    **/
    
    public byte[] ToBytes(File selectedFile) throws IOException{
        System.out.print("Dentro de la funcioon ToBytes");
        try(FileInputStream fis = new FileInputStream(selectedFile)){
            byte[] bytes = new byte[(int)selectedFile.length()];
            fis.read(bytes);
            return bytes;
        }
    }
    
    public String generarNumInventario(int ID){
        
        DecimalFormat df = new DecimalFormat("000000");
        String numeroFormateado = df.format(ID);
        return numeroFormateado;
    }
    
    public Date obtenerFechaActual(){
        LocalDate fechaActual = LocalDate.now();
        return Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    public String obtenerModelo() {
        String modelo;
        if (checkModelo.isSelected() || txtModelo.getText().isEmpty()) {
            modelo = "N/A";
        } else {
            modelo = txtModelo.getText();
        }
        return modelo;
    }

    public String obtenerSerie() {
        String serie;
        if (checkSerie.isSelected() || txtNumSerie.getText().isEmpty()) {
            serie = "N/A";
        } else {
            serie = txtNumSerie.getText();
        }
        return serie;
    }

    public String obtenerSerieInstitucional() {
        String serieInst;
        if(checkInstitucional.isSelected() || txtInstitucional.getText().isEmpty()){
            serieInst="N/A";
        }else{
            serieInst=txtInstitucional.getText();
        }
        return serieInst;
    }
    
    @Override
    public Component add(Component comp) {
        return super.add(comp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        pnlPrincipal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbMarca = new javax.swing.JComboBox<>();
        cmbTipoPro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbGabinete = new javax.swing.JComboBox<>();
        spnCantidad = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbEstadoPro = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnExplorar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbCatPro = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cmbBuscar = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblNumCuenta = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtNumSerie = new javax.swing.JTextField();
        txtInstitucional = new javax.swing.JTextField();
        checkModelo = new javax.swing.JCheckBox();
        checkSerie = new javax.swing.JCheckBox();
        checkInstitucional = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar un producto en el inventario"));

        pnlPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPrincipalMouseClicked(evt);
            }
        });

        jLabel2.setText("Marca");

        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una marca" }));
        cmbMarca.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbMarcaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cmbTipoPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el tipo de producto" }));
        cmbTipoPro.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbTipoProPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel3.setText("Tipo de producto");

        jLabel4.setText("Gabinete");

        cmbGabinete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un gabiente" }));

        jLabel6.setText("Cantidad");

        jLabel8.setText("Estado del producto");

        cmbEstadoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoProActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel5.setText("Descripción");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Puede subir una imagen del producto si así lo desea"));

        btnExplorar.setText("Explorar");
        btnExplorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExplorarbtnExplorarActionPerformed(evt);
            }
        });

        jLabel11.setText("Imagen seleccionada");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnExplorar)
                        .addGap(18, 18, 18)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnExplorar)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setText("Nombre del producto");

        cmbCatPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar un nombre" }));
        cmbCatPro.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbCatProPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbCatPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCatProActionPerformed(evt);
            }
        });

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProducto);

        jLabel7.setText("Buscar por");

        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Número de Inventario", "Nombre", "Marca", "Tipo de producto", "Gabinete", "Estado del producto", "Número de serie", "Número de inventario institucional" }));
        cmbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBuscarActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Acciones"));

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
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
                .addGap(21, 21, 21)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnCancel)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel9.setText("Cuenta:");

        jLabel12.setText("Nombre:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos del producto"));

        jLabel10.setText("Modelo:");

        jLabel13.setText("Número de serie");

        jLabel14.setText("Número de inventario:");

        txtInstitucional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInstitucionalActionPerformed(evt);
            }
        });

        checkModelo.setText("Sin modelo");
        checkModelo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkModeloStateChanged(evt);
            }
        });
        checkModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkModeloActionPerformed(evt);
            }
        });

        checkSerie.setText("Sin número de serie");
        checkSerie.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkSerieStateChanged(evt);
            }
        });
        checkSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSerieActionPerformed(evt);
            }
        });

        checkInstitucional.setText("Sin número de inventario");
        checkInstitucional.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkInstitucionalStateChanged(evt);
            }
        });
        checkInstitucional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInstitucionalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInstitucional, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkInstitucional, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkModelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkSerie))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtInstitucional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkInstitucional))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbGabinete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTipoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbEstadoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCatPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(83, 83, 83)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(20, 20, 20)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(lblNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbCatPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbTipoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbGabinete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbEstadoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addGap(32, 32, 32)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))))
                .addGap(20, 20, 20)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addContainerGap())
        );

        scrollPane.setViewportView(pnlPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnExplorarbtnExplorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExplorarbtnExplorarActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        int result = fileChooser.showOpenDialog(null);

        if(result == JFileChooser.APPROVE_OPTION){
            selectFile = fileChooser.getSelectedFile();
            try{
                Image img = ImageIO.read(selectFile);
                if(img == null){
                    JOptionPane.showMessageDialog(null,"El formato del archivo es incorrecto, debe de introducir una imagen", "Error", JOptionPane.ERROR);

                }else{
                    txtDireccion.setText(selectFile.getAbsolutePath());
                    ImageIcon originalIcon = new ImageIcon(img);
                    int lblwidth = lblImagen.getWidth();
                    int lblheight= lblImagen.getHeight();
                    Image scaledImage = originalIcon.getImage().getScaledInstance(lblwidth,lblheight, Image.SCALE_SMOOTH);
                    lblImagen.setIcon(new ImageIcon(scaledImage));
                }
            }catch(Exception err){
                JOptionPane.showMessageDialog(null,"Error: "+ err.toString());
            }
        }
    }//GEN-LAST:event_btnExplorarbtnExplorarActionPerformed

    private void cmbEstadoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoProActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new MenuAdmin(admin).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        String modelo = tblProducto.getValueAt(tblProducto.getSelectedRow(), 7).toString(), 
                serie = tblProducto.getValueAt(tblProducto.getSelectedRow(), 8).toString(), 
                institucional = tblProducto.getValueAt(tblProducto.getSelectedRow(), 9).toString();
        cmbCatPro.setSelectedItem(tblProducto.getValueAt(tblProducto.getSelectedRow(), 1));
        cmbMarca.setSelectedItem(tblProducto.getValueAt(tblProducto.getSelectedRow(), 2));
        cmbTipoPro.setSelectedItem(tblProducto.getValueAt(tblProducto.getSelectedRow(), 3));
        cmbGabinete.setSelectedItem(tblProducto.getValueAt(tblProducto.getSelectedRow(), 4).toString());
        txtDescripcion.setText(tblProducto.getValueAt(tblProducto.getSelectedRow(), 6).toString());
        spnCantidad.setValue(tblProducto.getValueAt(tblProducto.getSelectedRow(), 10));
        
        if(modelo.equals("N/A")){
            txtModelo.setText("");
            checkModelo.setSelected(true);
        }else{
            
            txtModelo.setText(modelo);
            checkModelo.setSelected(false);
        }
        
        if(serie.equals("N/A")){
            txtNumSerie.setText("");
            checkSerie.setSelected(true);
        }else{
            
            txtNumSerie.setText(serie);
            checkSerie.setSelected(false);
        }
        
        if(institucional.equals("N/A")){
            txtInstitucional.setText("");
            checkInstitucional.setSelected(true);
        }else{
            
            txtInstitucional.setText(institucional);
            checkInstitucional.setSelected(false);
        }
        updateDelete = true;
        btnUpdate.setEnabled(true);
        btnCancel.setEnabled(true);
        btnDelete.setEnabled(true);
        
    }//GEN-LAST:event_tblProductoMouseClicked

    private void cmbCatProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCatProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCatProActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(txtBuscar.getText().isEmpty()){
            createTable();
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        createTable();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cmbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBuscarActionPerformed

    private void pnlPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPrincipalMouseClicked
       pnlPrincipal.requestFocus();
    }//GEN-LAST:event_pnlPrincipalMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        boolean bandera = false, cambioImagen=false;

        if (cmbCatPro.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(null, "Debe elegir un nombre para el producto", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        }
        if (cmbMarca.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe elegir una marca para el producto", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        }
        if (cmbTipoPro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe elegir el tipo del producto", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        }
        if (cmbGabinete.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe elegir el gabinete donde el producto se ubicará", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        }
        if (spnCantidad.getValue().equals('0')) {
            JOptionPane.showMessageDialog(null, "La cantidad no es valida", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        }
        if (txtDescripcion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe de agregar una descripción para el producto", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        }

        if (!bandera) {
            System.out.print(tblProducto.getSelectedRow());
             int row=-1;
             row=tblProducto.getSelectedRow();
            if (row != -1) {
                int numGabinete = Integer.parseInt(cmbGabinete.getSelectedItem().toString());
                String catpro = cmbCatPro.getSelectedItem().toString(),
                        marca = cmbMarca.getSelectedItem().toString(),
                        tipoPro = cmbTipoPro.getSelectedItem().toString(),
                        estadoPro = cmbEstadoPro.getSelectedItem().toString(),
                        numInventario=tblProducto.getValueAt(tblProducto.getSelectedRow(), 0).toString(),
                        modelo=obtenerModelo(),
                        serie=obtenerSerie(),
                        serieInst=obtenerSerieInstitucional();
                byte[] barcodeBytes = null;

                Producto newProducto = new Producto();

                newProducto.setNumInventario(numInventario);
                newProducto.setDescripcion(txtDescripcion.getText());
                newProducto.setCantidadStock(Integer.valueOf(spnCantidad.getValue().toString()));
                newProducto.setFechaRegistro(obtenerFechaActual());
                newProducto.setModelo(modelo);
                newProducto.setSerie(serie);
                newProducto.setInventario_institucional(serieInst);
                newProducto.setFechaRegistro(obtenerFechaActual());
                if (!txtDireccion.getText().isEmpty()) {
                    try {
                        newProducto.setImagen(ToBytes(selectFile));
                    } catch (IOException ex) {
                        
                    }
                }
                /**
                //Generación del código de barras
                try {
                    barcodeBytes = generarCodigoBarras(numInventario);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al generar el código de barras /n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                * */
                if (JOptionPane.showConfirmDialog(null, "El siguiente producto se actualizará en el inventario\n"
                        + "Nombre: " + catpro + "\n"
                        + "Numero de inventario: " + numInventario + "\n"
                        + "Marca: " + marca + "\n"
                        + "Tipo de producto: " + tipoPro + "\n"
                ) == JOptionPane.YES_OPTION) {
                    if(crudProducto.update(newProducto, marca, tipoPro, catpro, numGabinete, estadoPro, tblProducto.getValueAt(tblProducto.getSelectedRow(), 0).toString())){
                        createTable();
                    limpiarCampos();
                    checkModelo.setSelected(false);
                    checkSerie.setSelected(false);
                    checkInstitucional.setSelected(false);
                    //ViewBarcode viewBarcode = new ViewBarcode(barcodeBytes, numInventario);
                    //viewBarcode.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Registro actualizado exitosamente", "INFO", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null,"Hubo un error en la actualización del próducto", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
                
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = -1;
        row = tblProducto.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Debe de seleccionar un producto para eliminarlo", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            if (JOptionPane.showConfirmDialog(null, "¿Desea eliminar el siguiente producto?: \n"
                    + "Número de inventario: " + tblProducto.getValueAt(tblProducto.getSelectedRow(), 0) + "\n"
                    + "Nombre del producto: " + tblProducto.getValueAt(tblProducto.getSelectedRow(), 1) + "\n"
            ) == JOptionPane.YES_OPTION) {

                if (crudProducto.delete(tblProducto.getValueAt(tblProducto.getSelectedRow(), 0).toString())) {
                    limpiarCampos();
                    createTable();
                    JOptionPane.showMessageDialog(null, "El producto se eliminó correctamente", "INFO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error en la eliminación del próducto", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cmbCatProPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbCatProPopupMenuWillBecomeInvisible
        if (cmbCatPro.getSelectedIndex() != 0 && !updateDelete) {
            btnAdd.setEnabled(true);
            btnCancel.setEnabled(true);
        } else {
            btnAdd.setEnabled(false);
            btnCancel.setEnabled(false);
        }
    }//GEN-LAST:event_cmbCatProPopupMenuWillBecomeInvisible

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        boolean bandera = false;

        if (cmbCatPro.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(null, "Debe elegir un nombre para el producto", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        }
        if (cmbMarca.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe elegir una marca para el producto", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        }
        if (cmbTipoPro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe elegir el tipo del producto", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        }
        if (cmbGabinete.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe elegir el gabinete donde el producto se ubicará", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        }
        if (spnCantidad.getValue().equals('0')) {
            JOptionPane.showMessageDialog(null, "La cantidad no es valida", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        } else {
            try {
                spnCantidad.getValue();
            } catch (NumberFormatException err) {
                JOptionPane.showMessageDialog(null, "La cantidad no es valida", "Error", JOptionPane.ERROR_MESSAGE);
                bandera = true;
            }
        }
        if (txtDescripcion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe de agregar una descripción para el producto", "Error", JOptionPane.ERROR_MESSAGE);
            bandera = true;
        }
        

        if (!bandera) {
            int maxID = crudProducto.getMaxID(), numGabinete = Integer.parseInt(cmbGabinete.getSelectedItem().toString());
            String catpro = cmbCatPro.getSelectedItem().toString(),
                    marca = cmbMarca.getSelectedItem().toString(),
                    tipoPro = cmbTipoPro.getSelectedItem().toString(),
                    estadoPro = cmbEstadoPro.getSelectedItem().toString(),
                    numInventario = generarNumInventario(maxID + 1),
                    modelo=obtenerModelo(),
                    serie=obtenerSerie(),
                    serieInst=obtenerSerieInstitucional();
            byte[] barcodeBytes = null;

            Producto newProducto = new Producto();

            newProducto.setNumInventario(numInventario);
            newProducto.setDescripcion(txtDescripcion.getText());
            newProducto.setCantidadStock(spnCantidad.getComponentCount());
            newProducto.setModelo(modelo);
            newProducto.setSerie(serie);
            newProducto.setInventario_institucional(serieInst);
            newProducto.setFechaRegistro(obtenerFechaActual());
            if (!txtDireccion.getText().isEmpty()) {
                try {
                    newProducto.setImagen(ToBytes(selectFile));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al obtener la imagen /n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            /**
            //Generar el código de barras
            try {
                barcodeBytes = generarCodigoBarras(numInventario);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al generar el código de barras /n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            **/
            if (JOptionPane.showConfirmDialog(null, "El siguiente producto se agregara al inventario\n"
                    + "Nombre: " + catpro + "\n"
                    + "Numero de inventario: " + numInventario + "\n"
                    + "Marca: " + marca + "\n"
                    + "Tipo de producto: " + tipoPro + "\n"
            ) == JOptionPane.YES_OPTION) {
                if (crudProducto.save(newProducto, marca, tipoPro, catpro, numGabinete, estadoPro)) {
                    createTable();
                    limpiarCampos();
                    checkModelo.setSelected(false);
                    checkSerie.setSelected(false);
                    checkInstitucional.setEnabled(false);
                    //ViewBarcode viewBarcode = new ViewBarcode(barcodeBytes, numInventario);
                    //viewBarcode.setVisible(true);
                    JOptionPane.showMessageDialog(null, "El producto se agregó correctamente", "INFO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error en el registro del próducto", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void cmbMarcaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbMarcaPopupMenuWillBecomeInvisible
       
        if (cmbMarca.getSelectedIndex() != 0 && !updateDelete) {
            btnAdd.setEnabled(true);
            btnCancel.setEnabled(true);
        } else {
            btnAdd.setEnabled(false);
            btnCancel.setEnabled(false);
        }
        
    }//GEN-LAST:event_cmbMarcaPopupMenuWillBecomeInvisible

    private void cmbTipoProPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbTipoProPopupMenuWillBecomeInvisible
        if (cmbTipoPro.getSelectedIndex() != 0 && !updateDelete) {
            btnAdd.setEnabled(true);
            btnCancel.setEnabled(true);
        } else {
            btnAdd.setEnabled(false);
            btnCancel.setEnabled(false);
        }
    }//GEN-LAST:event_cmbTipoProPopupMenuWillBecomeInvisible

    private void checkModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkModeloActionPerformed

    private void checkSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkSerieActionPerformed

    private void checkInstitucionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInstitucionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkInstitucionalActionPerformed

    private void txtInstitucionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInstitucionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInstitucionalActionPerformed

    private void checkModeloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkModeloStateChanged
        if(checkModelo.isSelected()){
            txtModelo.setEnabled(false);
        }else{
            txtModelo.setEnabled(true);
        }
    }//GEN-LAST:event_checkModeloStateChanged

    private void checkSerieStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkSerieStateChanged
        if(checkSerie.isSelected()){
            txtNumSerie.setEnabled(false);
        }else{
            txtNumSerie.setEnabled(true);
        }
    }//GEN-LAST:event_checkSerieStateChanged

    private void checkInstitucionalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkInstitucionalStateChanged
        if(checkInstitucional.isSelected()){
            txtInstitucional.setEnabled(false);
        }else{
            txtInstitucional.setEnabled(true);
        }
    }//GEN-LAST:event_checkInstitucionalStateChanged

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
            java.util.logging.Logger.getLogger(ViewProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExplorar;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox checkInstitucional;
    private javax.swing.JCheckBox checkModelo;
    private javax.swing.JCheckBox checkSerie;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbCatPro;
    private javax.swing.JComboBox<String> cmbEstadoPro;
    private javax.swing.JComboBox<String> cmbGabinete;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JComboBox<String> cmbTipoPro;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumCuenta;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtInstitucional;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumSerie;
    // End of variables declaration//GEN-END:variables
}
