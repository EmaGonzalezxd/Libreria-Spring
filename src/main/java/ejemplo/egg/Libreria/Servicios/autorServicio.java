package ejemplo.egg.Libreria.Servicios;

import ejemplo.egg.Libreria.Entidades.Autor;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ejemplo.egg.Libreria.Repositorio.repositorioAutor;
import java.util.List;

@Service
public class autorServicio {

    @Autowired
    private repositorioAutor repositorioAutor;

    @Transactional(propagation = Propagation.NESTED)
    public void crearAutor(String nombre) throws Exception {

        try {

            validar(nombre, Boolean.FALSE, Boolean.TRUE);

            //Creo una instancia del autor
            Autor autor = new Autor();

            //Seteo valores
            autor.setNombre(nombre);
            autor.setAlta(Boolean.TRUE);

            //guardo
            repositorioAutor.save(autor);

        } catch (Exception e) {
            throw new Exception("Algo malio sal xd");
        }
    }

    @Transactional(propagation = Propagation.NESTED)
    public void actualizarAutor(String nombre, Boolean alta, Boolean baja) throws Exception {

        try {

            //Valido
            validar(nombre, Boolean.FALSE, Boolean.TRUE);

            Optional<Autor> respuesta = repositorioAutor.findById(nombre);
            if (respuesta.isPresent()) {
                Autor autor = respuesta.get();

                //seteo de valores
                autor.setNombre(nombre);
                autor.setAlta(Boolean.TRUE);

                //guardo los cambios 
                repositorioAutor.save(autor);

            } else {
                throw new Exception("No se pudo modifica el autor solicitado.");
            }
        } catch (Exception e) {
            throw new Exception("Algo malio sal xd");
        }
    }

    @Transactional(propagation = Propagation.NESTED)
    public void eliminarAutor(String nombre, Boolean baja) throws Exception {

        try {

            Optional<Autor> respuesta = repositorioAutor.findById(nombre);
            if (respuesta.isPresent()) {
                Autor autor = respuesta.get();
                autor.setAlta(Boolean.FALSE);

                //guardo los cambios 
                repositorioAutor.save(autor);

            } else {
                throw new Exception("No se pudo eliminar el autor solicitado.");
            }
        } catch (Exception e) {
            throw new Exception("Algo malio sal xd");
        }
    }

    //MOSTRAR AUTORES//
    @Transactional(readOnly = true)
    public List<Autor> listarAutores() {
        List<Autor> listarAutores = repositorioAutor.findAll();
        return listarAutores;
    }

    private void validar(String nombre, Boolean alta, Boolean baja) throws Exception {

        //VALIDACIONES
        if (nombre == null | nombre.trim().isEmpty()) {
            throw new Exception("El nombre ingresado no es valido.");
        }
//        if (alta == true | nombre.trim().isEmpty()) {
//            throw new Exception("Error de sistema.");
//        }
//
//        if (baja == true | nombre.trim().isEmpty()) {
//            throw new Exception("Error de sistema.");
//        }

    }
}
