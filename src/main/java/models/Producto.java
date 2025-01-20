
package models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_producto")
    private int id_producto;
    
    @Column(name="num_inventario")
    private int num_inventario;
    
    @ManyToOne
    @JoinColumn(name="id_catpro", foreignKey=@ForeignKey(name="id_catpro"), nullable=false)
    private Catalogo_productos catalogo_producto;
    
    @ManyToOne
    @JoinColumn(name="id_marca", foreignKey=@ForeignKey(name="id_marca"),nullable=false)
    private Marca marca;
    
    @ManyToOne
    @JoinColumn(name="id_tipoProducto", foreignKey=@ForeignKey(name="id_TipoProducto"),nullable=false)
    private Tipo_producto tipo_producto;
    
    @ManyToOne
    @JoinColumn(name="id_gabinete", foreignKey=@ForeignKey(name="id_gabinete"),nullable=false)
    private Gabinete gabinete;
    
    @ManyToOne
    @JoinColumn(name="id_estadoProducto", foreignKey=@ForeignKey(name="id_estadoProducto"),nullable=false)
    private Estado_producto estado_producto;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @Column(name="cantidad_stock")
    private int cantidad_stock;
    
    @Column(name="cantidad_prestada")
    private int cantidad_prestada;
    
    @Column(name="cantidad_utilizada")
    private int cantidad_itulizada;
    
    @Column(name="fecha_registro")
    private Date cantidad_utilizada;
    
    @Column(name="imagen")
    private Object image;
    
    @ManyToOne
    @JoinColumn(name="id_admin",foreignKey=@ForeignKey(name="id_admin"),nullable=false)
    private Administrador administrador;

    public Producto(int id_producto, int num_inventario, Catalogo_productos catalogo_producto, Marca marca, Tipo_producto tipo_producto, Gabinete gabinete, Estado_producto estado_producto, String descripcion, int cantidad_stock, int cantidad_prestada, int cantidad_itulizada, Date cantidad_utilizada, Object image, Administrador administrador) {
        this.id_producto = id_producto;
        this.num_inventario = num_inventario;
        this.catalogo_producto = catalogo_producto;
        this.marca = marca;
        this.tipo_producto = tipo_producto;
        this.gabinete = gabinete;
        this.estado_producto = estado_producto;
        this.descripcion = descripcion;
        this.cantidad_stock = cantidad_stock;
        this.cantidad_prestada = cantidad_prestada;
        this.cantidad_itulizada = cantidad_itulizada;
        this.cantidad_utilizada = cantidad_utilizada;
        this.image = image;
        this.administrador = administrador;
    }
    
    public Producto(){}

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setNum_inventario(int num_inventario) {
        this.num_inventario = num_inventario;
    }

    public void setCatalogo_producto(Catalogo_productos catalogo_producto) {
        this.catalogo_producto = catalogo_producto;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setId_tipoProducto(Tipo_producto tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public void setGabinete(Gabinete gabinete) {
        this.gabinete = gabinete;
    }

    public void setEstado_producto(Estado_producto estado_producto) {
        this.estado_producto = estado_producto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad_stock(int cantidad_stock) {
        this.cantidad_stock = cantidad_stock;
    }

    public void setCantidad_prestada(int cantidad_prestada) {
        this.cantidad_prestada = cantidad_prestada;
    }

    public void setCantidad_itulizada(int cantidad_itulizada) {
        this.cantidad_itulizada = cantidad_itulizada;
    }

    public void setCantidad_utilizada(Date cantidad_utilizada) {
        this.cantidad_utilizada = cantidad_utilizada;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public int getId_producto() {
        return id_producto;
    }

    public int getNum_inventario() {
        return num_inventario;
    }

    public Catalogo_productos getCatalogo_producto() {
        return catalogo_producto;
    }

    public Marca getMarca() {
        return marca;
    }

    public Tipo_producto getId_tipoProducto() {
        return id_tipoProducto;
    }

    public Gabinete getGabinete() {
        return gabinete;
    }

    public Estado_producto getEstado_producto() {
        return estado_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad_stock() {
        return cantidad_stock;
    }

    public int getCantidad_prestada() {
        return cantidad_prestada;
    }

    public int getCantidad_itulizada() {
        return cantidad_itulizada;
    }

    public Date getCantidad_utilizada() {
        return cantidad_utilizada;
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
                "ID: "+id_producto+"\n"+
                "Número de inventario: "+num_inventario+"\n"+
                "Nombre del Producto: "+catalogo_producto+"\n"+
                "Marca: "+marca+"\n"+
                "Tipo de producto: "+id_tipoProducto+"\n"+
                "Estado del producto: "+estado_producto+"\n"+
                "Descripcion: "+descripcion+"\n"+
                "Cantidad en stock: "+cantidad_stock+"\n"+
                "Cantidad prestada: "+cantidad_prestada+"\n"+
                "Cantidad utilizada: "+cantidad_utilizada+"\n"+
                "Administrador: "+administrador+"\n";
    }
}

