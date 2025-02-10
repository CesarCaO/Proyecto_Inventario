package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Marca")
public class Marca implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idMarca")
    private int id_marca;
    
    @Column(name="nombreMarca")
    private String nombre_marca;
    
    @OneToMany(mappedBy="marca", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public Marca(int id_marca, String nombre_marca) {
        this.id_marca = id_marca;
        this.nombre_marca = nombre_marca;
    }
    
    public Marca(){}

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getId_marca() {
        return id_marca;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public List<Producto> getProducto() {
        return producto;
    }
    
    @Override
    public String toString(){
        return "Marca\n"+
                "ID: "+id_marca+"\n"+
                "Nombre de la Marca"+nombre_marca+"\n";
    }
    
    
    
    
}
