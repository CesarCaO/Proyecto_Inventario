
package models;

import java.util.Date;


public class ProductoReportDTO {
    
    private String numInventario;
    private String nombreProducto;
    private String marca;
    private String tipoProducto;
    private int numGabinete;
    private String estadoProducto;
    private String descripcion;
    private String modelo;
    private String serie;
    private String inventario_institucional;
    private int cantidadStock;
    private Date fechaRegistro;

    public ProductoReportDTO(String numInventario, String nombreProducto, String marca, String tipoProducto, int numGabinete, String estadoProducto, String descripcion, String modelo, String serie, String inventario_institucional, int cantidadStock, Date fechaRegistro) {
        this.numInventario = numInventario;
        this.nombreProducto = nombreProducto;
        this.marca = marca;
        this.tipoProducto = tipoProducto;
        this.numGabinete = numGabinete;
        this.estadoProducto = estadoProducto;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.serie = serie;
        this.inventario_institucional = inventario_institucional;
        this.cantidadStock = cantidadStock;
        this.fechaRegistro = fechaRegistro;
    }

    public ProductoReportDTO() {
    }

    public void setNumInventario(String numInventario) {
        this.numInventario = numInventario;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setNumGabinete(int numGabinete) {
        this.numGabinete = numGabinete;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setInventario_institucional(String inventario_institucional) {
        this.inventario_institucional = inventario_institucional;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNumInventario() {
        return numInventario;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public int getNumGabinete() {
        return numGabinete;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getModelo() {
        return modelo;
    }

    public String getSerie() {
        return serie;
    }

    public String getInventario_institucional() {
        return inventario_institucional;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    
}
