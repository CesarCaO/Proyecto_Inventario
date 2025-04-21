/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author darwi
 */
public class ViewBarcode extends javax.swing.JFrame {

    byte[] barcodeBytes;
    String numInventario;
    public ViewBarcode(byte[] barcodeBytes, String numInventario) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.numInventario = numInventario;
        this.barcodeBytes = barcodeBytes;
        ImageIcon originalIcon = BytesToImage(barcodeBytes);
        int lblWidth = lblBarcode.getWidth(),
            lblHeigth = lblBarcode.getHeight();
        Image scaledImg = originalIcon.getImage().getScaledInstance(lblWidth, lblHeigth, Image.SCALE_SMOOTH);
        lblBarcode.setIcon(new ImageIcon(scaledImg));
    }
    
    public ViewBarcode() {
    }

    public ImageIcon BytesToImage(byte[] imageBytes) {

        if (imageBytes == null || imageBytes.length == 0) {
            return new ImageIcon();
        }
        try (ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes)) {
            BufferedImage imagen = ImageIO.read(bis);

            int newWidth = 300;
            int newHeight = (imagen.getHeight() * newWidth) / imagen.getWidth();

            Image imagenEscalada = imagen.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            return new ImageIcon(imagenEscalada);
        } catch (IOException err) {
            return new ImageIcon();
        }
    }
    
    //Metodo para convertir un arreglo de bytes en una BufferedImage
    public BufferedImage convertToBufferedImage(byte[] imageBytes){
        try(ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes)){//Crear un Stream de entrada para un arreglo de bytes
            return ImageIO.read(bis);//Leer el stream de bytes
        }catch(IOException err){
            err.printStackTrace();
            return null;
        }
    }
    
    //Metodo encontrar una impresora 
    
    public PrintService findPrintService(String printerName){
        for(PrintService service : PrintServiceLookup.lookupPrintServices(null, null)){
            if(service.getName().equalsIgnoreCase(printerName)){
                return service;
            }
        }
        
        return null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        lblBarcode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir)
                .addContainerGap())
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

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        BufferedImage barcodeImage = convertToBufferedImage(barcodeBytes);
        if (barcodeImage == null) {
            JOptionPane.showMessageDialog(null, "No se pudo convertir el código de barras en una imagen", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /**
        for (PrintService service : PrintServiceLookup.lookupPrintServices(null, null)) {
            System.out.println(service.getName());
        }
        * */
         //Configuración de la impresión
        
         try{
             PrintService printService = findPrintService("4BARCODE 4B-2054N");
             if(printService == null){
                  JOptionPane.showMessageDialog(null,"No se encontró ninguna impresora","ERROR", JOptionPane.ERROR_MESSAGE);
                  return;
             }
             
            PrinterJob job = PrinterJob.getPrinterJob();//Establece el trabajo de impresión
            job.setPrintService(printService);//Establecer el servicio de impresión como trabajo de impresión
            
     
            Paper paper = new Paper();//Crear una hoja a configurar
            double widthCm = 5.08;
            double heightCm = 2.54;
            double marginCm = 0.3;
            //Convertir centimetros a puntos
            
            double widthPoints = widthCm * 28.35;
            double heightPoints = heightCm * 28.35;
            double marginPoints = marginCm * 28.35;
           
            paper.setSize(widthPoints, heightPoints);
            paper.setImageableArea(
                    marginPoints, marginPoints, 
                    widthPoints - 2*marginPoints, 
                    heightPoints - 2*marginPoints
            );
            
            PageFormat pageFormat = job.defaultPage();
            pageFormat.setPaper(paper);
            
            job.setPrintable((graphics, pf, pageIndex)->{
                if (pageIndex > 0) return Printable.NO_SUCH_PAGE;
                
                Graphics2D g2d = (Graphics2D) graphics;
                AffineTransform originalTransform = g2d.getTransform();
                
                //Escalar proporcionalmente con respecto a la imagen de barcode
                double scaleX = pf.getImageableWidth() / barcodeImage.getWidth();
                double scaleY = pf.getImageableHeight() / barcodeImage.getHeight();
                g2d.scale(scaleX, scaleY);
                
                //Centrar el código de barras
                int x = (int) ((pf.getImageableWidth() - barcodeImage.getWidth()) / 2);
                int y = (int) ((pf.getImageableHeight() - barcodeImage.getHeight()) / 2);
                g2d.drawImage(barcodeImage, x, y, null);
                
                //Agregar texto
               g2d.setTransform(originalTransform);
               g2d.setFont(new Font("Arial", Font.PLAIN, 12));
               g2d.drawString(numInventario,(int)pf.getImageableX(), (int)(pf.getImageableY()+pf.getImageableHeight()-10));
               
               return Printable.PAGE_EXISTS;
            },pageFormat);
            
            PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
            attributes.add(OrientationRequested.PORTRAIT);
            job.print(attributes);
            System.out.println("Impresión exitosa");
            
             
         }catch(PrinterException err){
             JOptionPane.showMessageDialog(null, "Hubo un error en la impresión: "+"\nerr", "ERROR", JOptionPane.ERROR_MESSAGE);
         }
         
    }//GEN-LAST:event_btnImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(ViewBarcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBarcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBarcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBarcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBarcode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel lblBarcode;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
