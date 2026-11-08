package API.de.materias.de.Angel.Yiban.Ruiz.Osante;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoController {

    @GetMapping("/proyecto")
    public String mostrarProyecto() {
        return "API de materias de Ángel Yibán Ruiz Osante";
    }
}