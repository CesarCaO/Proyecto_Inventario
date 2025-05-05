
package models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idProducto")
    private int idProducto;
    
    @Column(name="numInventario")
    private String numInventario;
    
    @ManyToOne
    @JoinColumn(name="idCatpro", foreignKey=@ForeignKey(name="idCatpro"), nullable=false)
    private CatalogoProductos catalogoProducto;
    
    @ManyToOne
    @JoinColumn(name="idMarca", foreignKey=@ForeignKey(name="idMarca"),nullable=false)
    private Marca marca;
    
    @ManyToOne
    @JoinColumn(name="idTipoProducto", foreignKey=@ForeignKey(name="idTipoProducto"),nullable=false)
    private TipoProducto tipoProducto;
    
    @ManyToOne
    @JoinColumn(name="idGabinete", foreignKey=@ForeignKey(name="idGabinete"),nullable=false)
    private Gabinete gabinete;
    
    @ManyToOne
    @JoinColumn(name="idEstadoProducto", foreignKey=@ForeignKey(name="idEstadoProducto"),nullable=false)
    private EstadoProducto estadoProducto;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @Column(name="modelo")
    private String modelo;
    
    @Column(name="serie")
    private String serie;
    
    @Column(name="inventario_institucional")
    private String inventario_institucional;
    
    @Column(name="cantidadStock")
    private int cantidadStock;
        
    @Column(name="fechaRegistro")
    private Date fechaRegistro;

    @Column(name="imagen")
    private byte[] imagen;

    public Producto(int idProducto, String numInventario, CatalogoProductos catalogoProducto, Marca marca, TipoProducto tipoProducto, Gabinete gabinete, EstadoProducto estadoProducto, String descripcion, String modelo, String serie, String inventario_institucional, int cantidadStock, Date fechaRegistro, byte[] imagen) {
        this.idProducto = idProducto;
        this.numInventario = numInventario;
        this.catalogoProducto = catalogoProducto;
        this.marca = marca;
        this.tipoProducto = tipoProducto;
        this.gabinete = gabinete;
        this.estadoProducto = estadoProducto;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.serie = serie;
        this.inventario_institucional = inventario_institucional;
        this.cantidadStock = cantidadStock;
        this.fechaRegistro = fechaRegistro;
        this.imagen = imagen;
    }

    public Producto() {
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNumInventario(String numInventario) {
        this.numInventario = numInventario;
    }

    public void setCatalogoProducto(CatalogoProductos catalogoProducto) {
        this.catalogoProducto = catalogoProducto;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setGabinete(Gabinete gabinete) {
        this.gabinete = gabinete;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
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

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNumInventario() {
        return numInventario;
    }

    public CatalogoProductos getCatalogoProducto() {
        return catalogoProducto;
    }

    public Marca getMarca() {
        return marca;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public Gabinete getGabinete() {
        return gabinete;
    }

    public EstadoProducto getEstadoProducto() {
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

    public byte[] getImagen() {
        return imagen;
    }

   
   
    @Override
    public String toString(){
        return "Producto\n"+
                "ID: "+idProducto+"\n"+
                "Número de inventario: "+numInventario+"\n"+
                "Nombre del Producto: "+catalogoProducto+"\n"+
                "Marca: "+marca+"\n"+
                "Tipo de producto: "+tipoProducto+"\n"+
                "Estado del producto: "+estadoProducto+"\n"+
                "Descripcion: "+descripcion+"\n"+
                "Cantidad en stock: "+cantidadStock+"\n";
    }
}

