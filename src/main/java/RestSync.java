import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class RestSync {
    private static Retrofit retrofit;

    public static void main(String[] args) throws IOException {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AtletaService atletaService = retrofit.create(AtletaService.class);


        //EJ GET ALL ATLETAS

        Call<List<Atleta>> call = atletaService.getAllAtletas();
        Response<List<Atleta>> response = call.execute();

        if (response.isSuccessful()){
            List<Atleta> atletaList = response.body();
            System.out.println("Status code: " + response.code() + System.lineSeparator()
             + "GET all atletas: " + atletaList);
        }else {
            System.out.println("Status code: " + response.code() + " Message error: " + response.errorBody());
        }

        //EJ DE LLAMADA A UN ENDPOINT INEXISTENTE

        call = atletaService.getError();
        response = call.execute();

        if (!response.isSuccessful()){
            System.out.println("Status code: " + response.code() + " Message error: " + response.raw());
        }

        //EJ DE POST ATLETA

        Atleta atleta = new Atleta();
        atleta.setNombre("Sergio");
        atleta.setApellidos("Diaz");
        atleta.setFechan(LocalDate.of(1996,8,8));
        atleta.setNacionalidad("Mundo");
        Call<Atleta> callAtleta = atletaService.createAtleta(atleta);
        Response<Atleta> responseAtleta = callAtleta.execute();

        if (responseAtleta.isSuccessful()){
            Atleta atletaResp = responseAtleta.body();
            System.out.println("Status code: " + responseAtleta.code() + System.lineSeparator() +
            "POST atleta: " + atletaResp);

            //Actualizar atleta utilizando response
            atletaResp.setNombre("Ruben");
            callAtleta = atletaService.updateAtleta(atletaResp);
            responseAtleta = callAtleta.execute();
            System.out.println("Status code: " + responseAtleta.code() + System.lineSeparator() +
                    "PUT atleta: " + responseAtleta.body());

            //Ejemplo de delete
            Call<Void> callDelete = atletaService.deleteAtleta(atletaResp.getId());
            Response<Void> responseDelete = callDelete.execute();
            System.out.println("DELETE status code: " + responseDelete.code());

            //Get all para comprobar si se ha eliminado.
            call = atletaService.getAllAtletas();
            response = call.execute();
            System.out.println("Comprobacion del delete " + "Status code: " +
                    response.code() + System.lineSeparator()
                    + "GET atletas: " + response.body());
        }else {
            System.out.println("Status code: " + responseAtleta.code() + "Message error: "
                    + responseAtleta.errorBody());
        }

        //EJ DE GET DE UN ATLETA
        callAtleta = atletaService.getAtleta(2L);
        responseAtleta = callAtleta.execute();

        if (responseAtleta.isSuccessful()){
            System.out.println("GET ONE->Status code: " + responseAtleta.code()
                    + " Atleta: " + responseAtleta.body());
        }
    }
}
