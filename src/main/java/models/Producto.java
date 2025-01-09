
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Catalogo_productos id_catpro;
    
    @ManyToOne
    @JoinColumn(name="id_marca", foreignKey=@ForeignKey(name="id_marca"),nullable=false)
    private Marca id_marca;
    
    @ManyToOne
    @JoinColumn(name="id_tipoProducto", foreignKey=@ForeignKey(name="id_TipoProducto"),nullable=false)
    private Tipo_producto id_tipoProducto;
    
    @ManyToOne
    @JoinColumn(name="id_estadoProducto", foreignKey=@ForeignKey(name="id_estadoProducto"),nullable=false)
    private Estado_producto id_estadoProducto;
    
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
    private int id_admin;

    public Producto(int id_producto, int num_inventario, Catalogo_productos id_catpro, Marca id_marca, Tipo_producto id_tipoProducto, Estado_producto id_estadoProducto, String descripcion, int cantidad_stock, int cantidad_prestada, int cantidad_itulizada, Date cantidad_utilizada, Object image, int id_admin) {
        this.id_producto = id_producto;
        this.num_inventario = num_inventario;
        this.id_catpro = id_catpro;
        this.id_marca = id_marca;
        this.id_tipoProducto = id_tipoProducto;
        this.id_estadoProducto = id_estadoProducto;
        this.descripcion = descripcion;
        this.cantidad_stock = cantidad_stock;
        this.cantidad_prestada = cantidad_prestada;
        this.cantidad_itulizada = cantidad_itulizada;
        this.cantidad_utilizada = cantidad_utilizada;
        this.image = image;
        this.id_admin = id_admin;
    }
    
    public Producto(){}

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setNum_inventario(int num_inventario) {
        this.num_inventario = num_inventario;
    }

    public void setId_catpro(Catalogo_productos id_catpro) {
        this.id_catpro = id_catpro;
    }

    public void setId_marca(Marca id_marca) {
        this.id_marca = id_marca;
    }

    public void setId_tipoProducto(Tipo_producto id_tipoProducto) {
        this.id_tipoProducto = id_tipoProducto;
    }

    public void setId_estadoProducto(Estado_producto id_estadoProducto) {
        this.id_estadoProducto = id_estadoProducto;
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

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public int getId_producto() {
        return id_producto;
    }

    public int getNum_inventario() {
        return num_inventario;
    }

    public Catalogo_productos getId_catpro() {
        return id_catpro;
    }

    public Marca getId_marca() {
        return id_marca;
    }

    public Tipo_producto getId_tipoProducto() {
        return id_tipoProducto;
    }

    public Estado_producto getId_estadoProducto() {
        return id_estadoProducto;
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

    public int getId_admin() {
        return id_admin;
    }
    
    
    
    @Override
    public String toString(){
        return "Producto\n"+
                "ID: "+id_producto+"\n"+
                "Número de inventario: "+num_inventario+"\n"+
                "Nombre del Producto: "+id_catpro+"\n"+
                "Marca: "+id_marca+"\n"+
                "Tipo de producto: "+id_tipoProducto+"\n"+
                "Estado del producto: "+id_estadoProducto+"\n"+
                "Descripcion: "+descripcion+"\n"+
                "Cantidad en stock: "+cantidad_stock+"\n"+
                "Cantidad prestada: "+cantidad_prestada+"\n"+
                "Cantidad utilizada: "+cantidad_utilizada+"\n"+
                "Administrador: "+id_admin+"\n";
    }
}

