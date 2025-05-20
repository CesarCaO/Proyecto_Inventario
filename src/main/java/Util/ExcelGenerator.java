
package Util;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.time.LocalDate;
import java.util.List;
import models.ProductoReportDTO;
public class ExcelGenerator {
    
    public Workbook generateProductsReport(List<ProductoReportDTO> productos) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        //Creación de la fila de encabezados
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Número de Inventario");
        header.createCell(1).setCellValue("Nombre del Producto");
        header.createCell(2).setCellValue("Marca");
        header.createCell(3).setCellValue("Tipo de Producto");
        header.createCell(4).setCellValue("Número de Gabinete");
        header.createCell(5).setCellValue("Estado del Producto");
        header.createCell(6).setCellValue("Descripción");
        header.createCell(7).setCellValue("Modelo");
        header.createCell(8).setCellValue("Serie");
        header.createCell(9).setCellValue("Inventario Institucional");
        header.createCell(10).setCellValue("Cantidad en Stock");
        header.createCell(11).setCellValue("Fecha de Registro");

        //2 Poblar datos
        int rowNum = 1;
        for (ProductoReportDTO p : productos) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(p.getNumInventario());
            row.createCell(1).setCellValue(p.getNombreProducto());
            row.createCell(2).setCellValue(p.getMarca());
            row.createCell(3).setCellValue(p.getTipoProducto());
            row.createCell(4).setCellValue(p.getNumGabinete());
            row.createCell(5).setCellValue(p.getEstadoProducto());
            row.createCell(6).setCellValue(p.getDescripcion());
            row.createCell(7).setCellValue(p.getModelo());
            row.createCell(8).setCellValue(p.getSerie());
            row.createCell(9).setCellValue(p.getInventario_institucional());
            row.createCell(10).setCellValue(p.getCantidadStock());
            // Para la fecha, podemos darle formato como cadena
            Cell dateCell = row.createCell(11);
            CreationHelper createHelper = workbook.getCreationHelper();
            CellStyle dateStyle = workbook.createCellStyle();
            dateStyle.setDataFormat(
                    createHelper.createDataFormat().getFormat("yyyy-MM-dd")
            );
            dateCell.setCellValue(p.getFechaRegistro());
            dateCell.setCellStyle(dateStyle);
        }
        
        //Auto ajustar las columnas
        
        for(int i=0; i<=11 ;i++){
            sheet.autoSizeColumn(i);
        }
        
        return workbook;

    }
     
  
    
    public void saveReport(Workbook workbook, String path) throws IOException{
        try(workbook; FileOutputStream fos = new FileOutputStream(path)){
            workbook.write(fos);
        } 
        workbook.close();
    }
    
}
