import java.time.LocalDate;

public class Atleta {
    private Long id;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private LocalDate fechan;

    public Atleta(String nombre, String apellidos, String nacionalidad, LocalDate fechan) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.fechan = fechan;
    }

    public Atleta(){
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

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechan() {
        return fechan;
    }
    public void setFechan(LocalDate fechan) {
        this.fechan = fechan;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fechan=" + fechan +
                '}';
    }
}
