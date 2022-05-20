package ejemplo.egg.Libreria.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Autor {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private String nombre;

    private Boolean alta;
    private Boolean baja;

    @ManyToOne
    Libro libro;
    @OneToOne
    Editorial editorial;

    public Autor() {
    }

    public Autor(String nombre, Boolean alta, Boolean baja) {
        this.nombre = nombre;
        this.alta = alta;
        this.baja = baja;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public void setBaja(Boolean baja) {
        this.baja = baja;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", alta=" + alta + ", baja=" + baja + ", libro=" + libro + ", editorial=" + editorial + '}';
    }

    public Object trim() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
