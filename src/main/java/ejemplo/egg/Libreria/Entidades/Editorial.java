package ejemplo.egg.Libreria.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Editorial {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(unique = true)
    private String nombre;

    private Boolean alta;
    private Boolean baja;

    @OneToOne
    Autor autor;
    @ManyToOne
    Libro libro;

    public Editorial() {
    }

    public Editorial(String nombre, Boolean alta, Boolean baja) {
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

    public Boolean getBaja() {
        return baja;
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
     
    @Override
    public String toString() {
        return "Editorial{" + "id=" + id + ", nombre=" + nombre + ", alta=" + alta + ", baja=" + baja + ", autor=" + autor + ", libro=" + libro + '}';
    }


}
