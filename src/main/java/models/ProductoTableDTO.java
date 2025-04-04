
package models;

import java.util.Date;


public class ProductoTableDTO {
    
    private int idProducto;
    private String numInventario;
    private String nombreProducto;
    private String marca;
    private String tipoProducto;
    private int numGabinete;
    private String estadoProducto;
    private String descripcion;
    private int cantidadStock;
    private Date fechaRegistro;
    private byte[] imagen;

    public ProductoTableDTO() {
    }

    public ProductoTableDTO(int idProducto, String numInventario, String nombreProducto, String marca, String tipoProducto, int numGabinete, String estadoProducto, String descripcion, int cantidadStock, Date fechaRegistro, byte[] imagen) {
        this.idProducto = idProducto;
        this.numInventario = numInventario;
        this.nombreProducto = nombreProducto;
        this.marca = marca;
        this.tipoProducto = tipoProducto;
        this.numGabinete = numGabinete;
        this.estadoProducto = estadoProducto;
        this.descripcion = descripcion;
        this.cantidadStock = cantidadStock;
        this.fechaRegistro = fechaRegistro;
        this.imagen = imagen;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getIdProducto() {
        return idProducto;
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

    public int getCantidadStock() {
        return cantidadStock;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public byte[] getImagen() {
        return imagen;
    }

   
}
