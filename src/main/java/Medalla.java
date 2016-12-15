public class Medalla {
    private Long id;
    private TipoMedalla tipoMedalla;
    private String especialidad;
    private String competicion;
    private Atleta atleta;

    public Medalla(TipoMedalla tipoMedalla, String especialidad, String competicion) {
        this.tipoMedalla = tipoMedalla;
        this.especialidad = especialidad;
        this.competicion = competicion;
    }

    public Medalla(TipoMedalla tipoMedalla, String especialidad, String competicion, Atleta atleta) {
        this.tipoMedalla = tipoMedalla;
        this.especialidad = especialidad;
        this.competicion = competicion;
        this.atleta = atleta;
    }

    public Medalla(){}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCompeticion() {
        return competicion;
    }
    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public Atleta getAtleta() {
        return atleta;
    }
    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public TipoMedalla getTipoMedalla() {
        return tipoMedalla;
    }
    public void setTipoMedalla(TipoMedalla tipoMedalla) {
        this.tipoMedalla = tipoMedalla;
    }

    @Override
    public String toString() {
        return "Medalla{" +
                "id=" + id +
                ", tipoMedalla=" + tipoMedalla +
                ", especialidad='" + especialidad + '\'' +
                ", competicion='" + competicion + '\'' +
                ", atleta=" + atleta +
                '}';
    }
}