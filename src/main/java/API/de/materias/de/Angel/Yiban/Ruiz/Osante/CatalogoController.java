package API.de.materias.de.Angel.Yiban.Ruiz.Osante;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class CatalogoController {

    private final CatalogoMaterias catalogo;

    @Value("${catalogo.autor}")
private String autor;

    @GetMapping("/catalogo/{id}")
public String mostrarDetalle(@PathVariable("id") Long id, Model model) {
    MateriaDTO materia = catalogo.listar().stream()
            .filter(elemento -> id.equals(elemento.getId()))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Materia no encontrada"));

    model.addAttribute("materia", materia);
    return "detalle";
}

    public CatalogoController(CatalogoMaterias catalogo) {
        this.catalogo = catalogo;
    }

    @GetMapping("/catalogo")
    public String mostrarCatalogo(
            @RequestParam(name = "area", defaultValue = "") String area,
            Model model) {

        List<MateriaDTO> materias = catalogo.listar();

        if (!area.isBlank()) {
            materias = materias.stream()
                    .filter(materia -> materia.getArea().equalsIgnoreCase(area.trim()))
                    .toList();
        }

        model.addAttribute("materias", materias);
        model.addAttribute("autor", autor);
        return "catalogo";
    }

    @GetMapping("/catalogo/nueva")
public String mostrarFormulario(Model model) {
    model.addAttribute("materia", new MateriaDTO());
    return "formulario";
}

@PostMapping("/catalogo")
public String guardarMateria(@ModelAttribute("materia") MateriaDTO materia) {
    catalogo.agregar(materia);
    return "redirect:/catalogo";
}


}