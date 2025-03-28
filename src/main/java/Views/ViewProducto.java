
package Views;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.Image;
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
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableColumn;
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


public class ViewProducto extends javax.swing.JFrame {

    CRUDProducto crudProducto = new CRUDProducto();
    CRUDMarca crudMarca = new CRUDMarca();
    CRUDGabinete crudGabinete = new CRUDGabinete();
    CRUDCatalogoProductos crudCatPro = new CRUDCatalogoProductos();
    CRUDTipoProducto crudTipPro = new CRUDTipoProducto();
    CRUDEstadoProducto crudEstPro = new CRUDEstadoProducto();
    public File selectFile;
    String updateNumInventario = null;
    public ViewProducto() {
        initComponents();
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
        TableColumn columnBarcode= tblProducto.getColumnModel().getColumn(11);
        columnBarcode.setPreferredWidth(300);
        columnBarcode.setMinWidth(100);
        columnBarcode.setMaxWidth(300);
        
    }
    
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
    }
    
    public byte[] generarCodigoBarras(String data) throws IOException, Exception{
        try{
           
            
            int width = 20 * data.length();
            int height = 200;
            BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.CODE_128,width,height);
             
            //Convertir el código de barras en un stream sin guardarlo en disco
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            return outputStream.toByteArray();
            
        }catch(WriterException | IOException err){
            
            throw new Exception("Error al generar el código: " + err.getMessage());
        }
    }
    
    
    public byte[] ToBytes(File selectedFile) throws IOException{
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbCatPro = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbMarca = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbTipoPro = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbGabinete = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        btnExplorar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmbEstadoPro = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        cmbBuscar = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Registrar productos nuevos"));

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
        jScrollPane1.setViewportView(tblProducto);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Nombre del producto");

        cmbCatPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un nombre" }));

        jLabel2.setText("Marca");

        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una marca" }));

        jLabel3.setText("Tipo de producto");

        cmbTipoPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el tipo de producto" }));

        jLabel4.setText("Gabinete");

        cmbGabinete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un gabiente" }));

        jLabel5.setText("Descripción");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel6.setText("Cantidad");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Puede subir una imagen del producto si así lo desea"));

        btnExplorar.setText("Explorar");
        btnExplorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExplorarActionPerformed(evt);
            }
        });

        jLabel7.setText("Imagen seleccionada");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnExplorar)
                        .addGap(69, 69, 69)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnExplorar)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

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

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Estado del producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1)
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbCatPro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbTipoPro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbGabinete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEstadoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd)
                        .addGap(29, 29, 29)
                        .addComponent(btnUpdate)
                        .addGap(34, 34, 34)
                        .addComponent(jButton4)
                        .addGap(22, 22, 22)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(cmbCatPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cmbTipoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbGabinete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(cmbEstadoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(jButton4))
                .addGap(17, 17, 17))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Buscar"));

        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Número de Inventario", "Nombre", "Marca", "Tipo de Producto", "Gabinete", "Estado del producto" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setText("jButton5");

        jToggleButton1.setText("jToggleButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jToggleButton1))
                .addGap(14, 14, 14))
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

    private void btnExplorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExplorarActionPerformed
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
    }//GEN-LAST:event_btnExplorarActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        boolean bandera = false;
        
        if(cmbCatPro.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Debe elegir un nombre para el producto", "Error", JOptionPane.ERROR);
            bandera =true;
        } 
        if(cmbMarca.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Debe elegir una marca para el producto", "Error", JOptionPane.ERROR);
            bandera = true;
        }
        if(cmbTipoPro.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Debe elegir el tipo del producto", "Error", JOptionPane.ERROR);
            bandera = true;
        }
        if(cmbGabinete.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Debe elegir el gabinete donde el producto se ubicará", "Error", JOptionPane.ERROR);
            bandera = true;
        }
        if(spnCantidad.getComponentCount()== 0){
            JOptionPane.showMessageDialog(null,"La cantidad no es valida", "Error", JOptionPane.ERROR);
            bandera = true;
        }
        if(txtDescripcion.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Debe de agregar una descripción para el producto", "Error", JOptionPane.ERROR);
            bandera = true; 
        }
        
        if(!bandera){
            int maxID=crudProducto.getMaxID(), numGabinete = Integer.parseInt(cmbGabinete.getSelectedItem().toString());
            String catpro = cmbCatPro.getSelectedItem().toString(),
                    marca = cmbMarca.getSelectedItem().toString(),
                    tipoPro = cmbTipoPro.getSelectedItem().toString(),
                    estadoPro= cmbEstadoPro.getSelectedItem().toString(),
                    numInventario = generarNumInventario(maxID+1);
            byte[] barcodeBytes = null; 
                    
            
            Producto newProducto = new Producto();
            
            newProducto.setNumInventario(numInventario);
            newProducto.setDescripcion(txtDescripcion.getText());
            newProducto.setCantidadStock(spnCantidad.getComponentCount());
            newProducto.setFechaRegistro(obtenerFechaActual()); 
            try {
                newProducto.setImagen(ToBytes(selectFile));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro al generar el código de barras /n"+ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
            try {
                barcodeBytes = generarCodigoBarras(numInventario);
            } catch (Exception ex) {
                Logger.getLogger(ViewProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           crudProducto.save(newProducto, marca, tipoPro, catpro, numGabinete, estadoPro);
           createTable();
           limpiarCampos();
           ViewBarcode viewBarcode = new ViewBarcode(barcodeBytes, numInventario);
           viewBarcode.setVisible(true);
           
           
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       limpiarCampos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        boolean bandera = false;
        
        if(updateNumInventario == null){
            JOptionPane.showMessageDialog(null,"Debe elegir un producto para actualizar", "Error", JOptionPane.ERROR);
            bandera = true;
        }
        
        if(cmbCatPro.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Debe elegir un nombre para el producto", "Error", JOptionPane.ERROR);
            bandera = true;
        } 
        if(cmbMarca.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Debe elegir una marca para el producto", "Error", JOptionPane.ERROR);
            bandera = true;
        }
        if(cmbTipoPro.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Debe elegir el tipo del producto", "Error", JOptionPane.ERROR);
            bandera = true;
        }
        if(cmbGabinete.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null,"Debe elegir el gabinete donde el producto se ubicará", "Error", JOptionPane.ERROR);
            bandera = true;
        }
        if(spnCantidad.getComponentCount()== 0){
            JOptionPane.showMessageDialog(null,"La cantidad no es valida", "Error", JOptionPane.ERROR);
            bandera = true;
        }
        if(txtDescripcion.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Debe de agregar una descripción para el producto", "Error", JOptionPane.ERROR);
            bandera = true; 
        }
        
        if(!bandera){
            int maxID=crudProducto.getMaxID(), numGabinete = Integer.parseInt(cmbGabinete.getSelectedItem().toString());
            String catpro = cmbCatPro.getSelectedItem().toString(),
                    marca = cmbMarca.getSelectedItem().toString(),
                    tipoPro = cmbTipoPro.getSelectedItem().toString(),
                    estadoPro= cmbEstadoPro.getSelectedItem().toString(),
                    numInventario = generarNumInventario(maxID+1);
            byte[] barcodeBytes = null; 
                    
            
            Producto newProducto = new Producto();
            
            newProducto.setNumInventario(numInventario);
            newProducto.setDescripcion(txtDescripcion.getText());
            newProducto.setCantidadStock(spnCantidad.getComponentCount());
            newProducto.setFechaRegistro(obtenerFechaActual()); 
            try {
                newProducto.setImagen(ToBytes(selectFile));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro al generar el código de barras /n"+ex,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
            try {
                barcodeBytes = generarCodigoBarras(numInventario);
            } catch (Exception ex) {
                Logger.getLogger(ViewProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           crudProducto.update(newProducto, marca, tipoPro, catpro, numGabinete, estadoPro, numInventario);
           createTable();
           limpiarCampos();
           ViewBarcode viewBarcode = new ViewBarcode(barcodeBytes, numInventario);
           viewBarcode.setVisible(true);
           
           
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        updateNumInventario = tblProducto.getValueAt(tblProducto.getSelectedRow(),0).toString();
        
        cmbCatPro.setSelectedItem(tblProducto.getValueAt(tblProducto.getSelectedRow(),0).toString());
    }//GEN-LAST:event_tblProductoMouseClicked

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
    private javax.swing.JButton btnExplorar;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbCatPro;
    private javax.swing.JComboBox<String> cmbEstadoPro;
    private javax.swing.JComboBox<String> cmbGabinete;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JComboBox<String> cmbTipoPro;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    // End of variables declaration//GEN-END:variables
}
