package ejemplo.egg.Libreria.Repositorio;

import ejemplo.egg.Libreria.Entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface repositorioLibro extends JpaRepository<Libro, String> {

    @Query("SELECT c FROM Libro c WHERE c.id = :id")
    public List<Libro> buscarLibroPorId(@Param("id") String id);

    @Query("SELECT c FROM Libro c WHERE c.titulo = :titulo")
    public List<Libro> buescarLibroPorTitulo(@Param("titulo") String titulo);

    @Query("SELECT c FROM Libro c WHERE c.autor.nombre LIKE %:nombre%")//trae todo lo que este relacionado o sea parecido al libro pedido
    public List<Libro> buescarLibroPorAutor(@Param("nombre") String nombre);

    @Query("SELECT c FROM Libro c WHERE c.editorial.nombre LIKE %:nombre%")
    public List<Libro> buescarLibroPorEditorial(@Param("nombre") String nombre);
}
