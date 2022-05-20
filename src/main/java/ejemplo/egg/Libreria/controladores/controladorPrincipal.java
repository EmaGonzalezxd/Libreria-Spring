package ejemplo.egg.Libreria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class controladorPrincipal {

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/menuAdmin")
    public String menu(){
        return "menuAdmin";
    }
    
    
}
