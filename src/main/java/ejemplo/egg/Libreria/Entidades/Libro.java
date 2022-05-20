package ejemplo.egg.Libreria.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Libro {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private Long ISBN;

    @Column(unique = false)
    private String titulo;

    @Column(unique = false)
    private Integer anio;

    private Integer ejemplares;
    private Integer ejemplaresPrestados;
    private Integer ejemplaresRestantes;
    private Boolean alta;
    private Boolean baja;

    @ManyToOne
    Autor autor;
    @ManyToOne
    Editorial editorial;

    public Libro() {
    }

    public Libro(Long ISBN, String titulo, Integer anio, Boolean alta, Boolean baja, Autor autor, Editorial editorial) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.anio = anio;
        this.alta = alta;
        this.baja = baja;
        this.autor = autor;
        this.editorial = editorial;
    }

    public String getId() {
        return id;
    }

    public Long getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
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

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public void setBaja(Boolean baja) {
        this.baja = baja;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", ISBN=" + ISBN + ", titulo=" + titulo + ", anio=" + anio + ", ejemplares=" + ejemplares + ", ejemplaresPrestados=" + ejemplaresPrestados
                + ", ejemplaresRestantes=" + ejemplaresRestantes + ", alta=" + alta + ", baja=" + baja + '}';
    }

}
