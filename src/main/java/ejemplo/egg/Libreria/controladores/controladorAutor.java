package ejemplo.egg.Libreria.controladores;

import ejemplo.egg.Libreria.Servicios.autorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/autor")
public class controladorAutor {

    @Autowired
    autorServicio autorServicio;

    @GetMapping("/registro")
    public String formulario() {
        return "autor";
    }

    @PostMapping("/registro")
    public String guardar(ModelMap modelo, @RequestParam String nombre) throws Exception {
        try {
            autorServicio.crearAutor(nombre);
            modelo.put("Autor registrado con exito.", "xd");
        } catch (Exception e) {
            modelo.put("Error al registrar autor.", "xd");
        }
        return "autor";
    }

}
