package ejemplo.egg.Libreria.Servicios;

import ejemplo.egg.Libreria.Entidades.Autor;
import ejemplo.egg.Libreria.Entidades.Editorial;
import ejemplo.egg.Libreria.Entidades.Libro;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ejemplo.egg.Libreria.Repositorio.repositorioLibro;

@Service
public class libroServicio {

    @Autowired
    private repositorioLibro repositorioLibro;

    @Transactional(propagation = Propagation.NESTED)
    public void crearLibro(Long ISBN, String titulo, Integer anio, Autor autor, Editorial editorial) throws Exception {

        try {

            validar(ISBN, titulo, anio, autor, editorial);

            //CREO UNA INSTANCIA DEL LIBRO
            Libro libro = new Libro();

            //SETEO LOS VALORES
            libro.setISBN(ISBN);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setAutor(autor);
            libro.setEditorial(editorial);

            repositorioLibro.save(libro);

        } catch (Exception e) {
            throw new Exception("Algo malio sal xd");
        }
    }

    @Transactional(propagation = Propagation.NESTED)
    public void actualizarLibro(String id, Long ISBN, String titulo, Integer anio, Autor autor, Editorial editorial) throws Exception {

        try {

            validar(ISBN, titulo, anio, autor, editorial);

            Optional<Libro> respuesta = repositorioLibro.findById(id);
            if (respuesta.isPresent()) {
                Libro libro = respuesta.get();

                //Le seteo los valores
                libro.setISBN(ISBN);
                libro.setTitulo(titulo);
                libro.setAnio(anio);
                libro.setAutor(autor);
                libro.setEditorial(editorial);

                //guardamos
                repositorioLibro.save(libro);

            } else {
                throw new Exception("No se encontró el libro solicitado.");
            }

        } catch (Exception e) {
            throw new Exception("Algo malio sal.");
        }
    }

    @Transactional(propagation = Propagation.NESTED)
    public void eliminarLibro(Long ISBN, String titulo, Integer anio, Autor autor, Editorial editorial) throws Exception {

        try {

            validar(ISBN, titulo, anio, autor, editorial);

            Optional<Libro> respuesta = repositorioLibro.findById(titulo);
            if (respuesta.isPresent()) {
                Libro libro = respuesta.get();
                libro.setBaja(Boolean.TRUE);

                repositorioLibro.save(libro);

            } else {
                throw new Exception("No se pudo eliminar el libro solicitado.");
            }
        } catch (Exception e) {
            throw new Exception("Algo malio sal xd");
        }
    }

    public void buscarLibroPorISBN(String ISBN) {

        
    }

    private void validar(Long ISBN, String titulo, Integer anio, Autor autor, Editorial editorial) throws Exception {

        //VALIDACIONES
        if (ISBN == null | ISBN < 13) {
            throw new Exception("El ISBN ingresado no es valido.");
        }
        
        if (titulo == null | titulo.trim().isEmpty()) {
            throw new Exception("El titulo ingresado no es valido.");
        }
        
        if (anio == null | anio < 1) {
            throw new Exception("El año ingrsado no es valido.");
        }
        
        if (autor == null) {
            throw new Exception("El autor ingresado no es valido.");
        }
        
        if (editorial == null) {
            throw new Exception("La editorial ingresada no es valida.");
        }
    }
}
