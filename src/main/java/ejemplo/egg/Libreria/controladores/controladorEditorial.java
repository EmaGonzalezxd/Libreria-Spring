package ejemplo.egg.Libreria.controladores;

import ejemplo.egg.Libreria.Servicios.editorialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/editorial")
public class controladorEditorial {
    
    @Autowired
    editorialServicio editorialServicio;

    @GetMapping("/registro")
    public String formulario() {
        return "editorial";
    }

    @PostMapping("/registro")
    public String guardar(ModelMap modelo, @RequestParam String nombre) throws Exception {
        try {
            editorialServicio.crearEditorial(nombre);
            modelo.put("Autor registrado con exito.", "xd");
        } catch (Exception e) {
            modelo.put("Error al registrar autor.", "xd");
        }
        return "editorial";
    }
}
