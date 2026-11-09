package API.de.materias.de.Angel.Yiban.Ruiz.Osante;

public class MateriaDTO {

    private Long id;
    private String nombre;
    private String area;

    public MateriaDTO() {
    }

    public MateriaDTO(Long id, String nombre, String area) {
        this.id = id;
        this.nombre = nombre;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}