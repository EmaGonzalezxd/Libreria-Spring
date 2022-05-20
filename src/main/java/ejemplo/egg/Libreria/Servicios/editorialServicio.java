package ejemplo.egg.Libreria.Servicios;

import ejemplo.egg.Libreria.Entidades.Editorial;
import ejemplo.egg.Libreria.Repositorio.repositorioEditorial;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class editorialServicio {

    @Autowired
    private repositorioEditorial repositorioEditorial;

    @Transactional(propagation = Propagation.NESTED)
    public void crearEditorial(String nombre) throws Exception {

        try {
            
            validar(nombre);

            //Instancio la editorial
            Editorial editorial = new Editorial();

            //seteo valores
            editorial.setNombre(nombre);
            editorial.setAlta(Boolean.TRUE);

            repositorioEditorial.save(editorial);

        } catch (Exception e) {
            throw new Exception("Algo malio sal xd");
        }
    }

    //FALTA HACER METODOS PARA MODIFICAR Y ELIMINAR EDITORIALES
    
        //MOSTRAR EDITORIALES//
    @Transactional(readOnly = true)
    public List<Editorial> listarEditoriales() {
        List<Editorial> listarEditoriales = repositorioEditorial.findAll();
        return listarEditoriales;
    }
    
    public void validar(String nombre) throws Exception {

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
