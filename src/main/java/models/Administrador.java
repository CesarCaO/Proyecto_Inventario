
package models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="administrador")
public class Administrador implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_admin")
    private int id_admin;
    
    @Column(name="cuenta_admin")
    private int cuenta_admin;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="contrasenia")
    private String contrasenia;
    
    @Column(name="telefono")
    private String telefono;
    
    @OneToMany(mappedBy="administrador", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Producto> producto= new ArrayList<>();

    public Administrador(int id_admin, int cuenta_admin, String nombre, String contrasenia, String telefono) {
        this.id_admin = id_admin;
        this.cuenta_admin = cuenta_admin;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
    }
    
    public Administrador(){}

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setCuenta_admin(int cuenta_admin) {
        this.cuenta_admin = cuenta_admin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getId_admin() {
        return id_admin;
    }

    public int getCuenta_admin() {
        return cuenta_admin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Producto> getProducto() {
        return producto;
    }
    
    @Override
    public String toString(){
        return "Marca\n"+
                "ID: "+id_admin+"\n"+
                "Numero de cuenta: "+cuenta_admin+"\n"+
                "Nombre: "+nombre+"\n"+
                "Contrasenia: "+contrasenia+"\n"+
                "Telefono: "+telefono+"\n";
                
    }
    
}
