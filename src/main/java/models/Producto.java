
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
    private int numInventario;
    
    @ManyToOne
    @JoinColumn(name="idCatpro", foreignKey=@ForeignKey(name="id_catpro"), nullable=false)
    private CatalogoProductos catalogoProducto;
    
    @ManyToOne
    @JoinColumn(name="idMarca", foreignKey=@ForeignKey(name="id_marca"),nullable=false)
    private Marca marca;
    
    @ManyToOne
    @JoinColumn(name="idTipoProducto", foreignKey=@ForeignKey(name="id_TipoProducto"),nullable=false)
    private TipoProducto tipoProducto;
    
    @ManyToOne
    @JoinColumn(name="idGabinete", foreignKey=@ForeignKey(name="id_gabinete"),nullable=false)
    private Gabinete gabinete;
    
    @ManyToOne
    @JoinColumn(name="idEstadoProducto", foreignKey=@ForeignKey(name="id_estadoProducto"),nullable=false)
    private EstadoProducto estadoProducto;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @Column(name="cantidadStock")
    private int cantidadStock;
    
    @Column(name="cantidadPrestada")
    private int cantidadPrestada;
    
    @Column(name="cantidadUtilizada")
    private int cantidadUtilizada;
    
    @Column(name="fechaRegistro")
    private Date fechaRegistro;
    
    @Column(name="imagen")
    private Object image;
    
    @ManyToOne
    @JoinColumn(name="idAdmin",foreignKey=@ForeignKey(name="idAdmin"),nullable=false)
    private Administrador administrador;

    public Producto(int idProducto, int numInventario, CatalogoProductos catalogProducto, Marca marca, TipoProducto tipoProducto, Gabinete gabinete, EstadoProducto estadoProducto, String descripcion, int cantidadStock, int cantidadPrestada, int cantidadUtulizada, Date fechaRegistro, Object image, Administrador administrador) {
        this.idProducto = idProducto;
        this.numInventario = numInventario;
        this.catalogoProducto = catalogProducto;
        this.marca = marca;
        this.tipoProducto = tipoProducto;
        this.gabinete = gabinete;
        this.estadoProducto = estadoProducto;
        this.descripcion = descripcion;
        this.cantidadStock = cantidadStock;
        this.cantidadPrestada = cantidadPrestada;
        this.cantidadUtilizada = cantidadUtulizada;
        this.fechaRegistro = fechaRegistro;
        this.image = image;
        this.administrador = administrador;
    }

    public Producto(){}

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNumInventario(int numInventario) {
        this.numInventario = numInventario;
    }

    public void setCatalogProducto(CatalogoProductos catalogProducto) {
        this.catalogoProducto = catalogProducto;
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

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public void setCantidadPrestada(int cantidadPrestada) {
        this.cantidadPrestada = cantidadPrestada;
    }

    public void setCantidadUtulizada(int cantidadUtulizada) {
        this.cantidadUtilizada = cantidadUtulizada;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getNumInventario() {
        return numInventario;
    }

    public CatalogoProductos getCatalogProducto() {
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

    public int getCantidadStock() {
        return cantidadStock;
    }

    public int getCantidadPrestada() {
        return cantidadPrestada;
    }

    public int getCantidadUtulizada() {
        return cantidadUtilizada;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public Object getImage() {
        return image;
    }

    public Administrador getAdministrador() {
        return administrador;
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
                "Cantidad en stock: "+cantidadStock+"\n"+
                "Cantidad prestada: "+cantidadPrestada+"\n"+
                "Cantidad utilizada: "+cantidadUtilizada+"\n"+
                "Administrador: "+administrador+"\n";
    }
}

