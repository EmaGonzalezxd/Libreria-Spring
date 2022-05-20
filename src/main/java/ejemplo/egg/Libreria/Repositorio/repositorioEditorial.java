package ejemplo.egg.Libreria.Repositorio;

import ejemplo.egg.Libreria.Entidades.Editorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface repositorioEditorial extends JpaRepository<Editorial, String>{
    
    @Query("SELECT c FROM Editorial c WHERE c.id = :id")
    public List<Editorial> buscarAutorPorId(@Param("id") String id);
    
    @Query("SELECT c FROM Editorial c WHERE c.nombre = :nombre")
    public List<Editorial> buscarEditorialPorNombre(@Param("nombre") String nombre);
    
}
