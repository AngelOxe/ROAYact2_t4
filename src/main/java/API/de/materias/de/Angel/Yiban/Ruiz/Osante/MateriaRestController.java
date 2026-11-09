package API.de.materias.de.Angel.Yiban.Ruiz.Osante;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MateriaRestController {

    private final CatalogoMaterias catalogo;

    public MateriaRestController(CatalogoMaterias catalogo) {
        this.catalogo = catalogo;
    }

    @PostMapping("/api/materias")
    @ResponseStatus(HttpStatus.CREATED)
    public MateriaDTO crearMateria(@RequestBody MateriaDTO materia) {
        return catalogo.agregar(materia);
    }
}