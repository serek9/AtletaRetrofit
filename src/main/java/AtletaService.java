import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;
import java.util.Map;

public interface AtletaService{
    @GET("/atletas")
    Call<List<Atleta>> getAllAtletas();

    @GET("/atletasError")
    Call<List<Atleta>> getError();

    @POST("/atletas")
    Call<Atleta> createAtleta(@Body Atleta atleta);

    @PUT("/atleta")
    Call<Atleta> updateAtleta(@Body Atleta atleta);

    @DELETE("/atletas/{id}")
    Call<Void> deleteAtleta(@Path("id") Long id);

    //CONSULTAS SERVIDOR
    //Obtener atletas por id
    @GET("/atletas/{id}")
    Call<Atleta> getAtleta(@Path("id") Long id);

    //Atletas de una nacionalidad determinada
    @GET("/atletas/byNacionalidad/{nacionalidad}")
    Call<List<Atleta>> findByNacionalidad(@Path("nacionalidad") String nacionalidad);

    //Atletas con una fecha de nacimiento anterior a la determinada
    @GET("/atletas/byNacimientoAntes/{nacimiento}")
    Call<List<Atleta>> findByNacimientoAntes(@Path("nacimiento") String nacimiento);

    @GET("/atletas/byNacionalidadMap")
    Call<Map<String, List<Atleta>>> findByNacionalidadMap();
}
