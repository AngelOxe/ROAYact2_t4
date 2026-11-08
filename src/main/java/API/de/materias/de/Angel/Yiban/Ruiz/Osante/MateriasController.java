package API.de.materias.de.Angel.Yiban.Ruiz.Osante;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MateriasController {

    private final List<String> materias = List.of(
       
        "Conmutación y Enrutamiento de Redes de Datos",
        "Software para Toma de Decisiones",
        "Programación Web",
        "Gestión de Proyectos de Software",
        "Programacion Logica Funcional",
        "Sistemas Programables",
        "Lenguajes y Autómatas II"
    );

    @GetMapping("/materias")
    public List<String> obtenerMaterias() {
        return materias;
    }

    @GetMapping("/materias/total")
    public int obtenerTotal() {
        return materias.size();
    }
}