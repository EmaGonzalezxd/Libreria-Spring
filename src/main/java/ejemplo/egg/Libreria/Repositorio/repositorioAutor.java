package ejemplo.egg.Libreria.Repositorio;

import ejemplo.egg.Libreria.Entidades.Autor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface repositorioAutor extends JpaRepository<Autor, String> {

    @Query("SELECT c FROM Autor c WHERE c.id = :id")
    public List<Autor> buscarAutorPorId(@Param("id") String id);

    @Query("SELECT c FROM Autor c WHERE c.nombre = :nombre")
    public List<Autor> buscarAutorPorNombre(@Param("nombre") String nombre);

}