package ejemplo.egg.Libreria.controladores;

import ejemplo.egg.Libreria.Entidades.Autor;
import ejemplo.egg.Libreria.Entidades.Editorial;
import ejemplo.egg.Libreria.Servicios.autorServicio;
import ejemplo.egg.Libreria.Servicios.editorialServicio;
import ejemplo.egg.Libreria.Servicios.libroServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/libro")
public class controladorLibro {

    @Autowired
    libroServicio libroServicio;

    @Autowired
    autorServicio autorServicio;

    @Autowired
    editorialServicio editorialServicio;

    @GetMapping("/registro")
    public String autor(ModelMap modelo) {
        List<Autor> autores = autorServicio.listarAutores();
        List<Editorial> editorial = editorialServicio.listarEditoriales();
        modelo.addAttribute("autor", autores);
        modelo.addAttribute("editorial", editorial);
        return "libro";
    }

    @PostMapping("/registro")
    public String guardar(ModelMap modelo, @RequestParam Long ISBN, @RequestParam String titulo, @RequestParam Integer anio,
            @RequestParam Autor autor, @RequestParam Editorial editorial) throws Exception {
        try {
            libroServicio.crearLibro(ISBN, titulo, anio, autor, editorial);
            modelo.put("Autor registrado con exito.", "xd");
        } catch (Exception e) {
            modelo.put("Error al registrar autor.", "xd");
        }
        return "libro";
    }

    //LOS DE ABAJO TIENE ALGUN ERROR. !REVISAR¡

}
