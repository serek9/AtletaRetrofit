import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.Map;

public class RestAsync {
    private static Retrofit retrofit;

    public static void main(String[] args) {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AtletaService atletaService = retrofit.create(AtletaService.class);
        MedallaService medallaService = retrofit.create(MedallaService.class);

        Call<List<Atleta>> call = atletaService.getAllAtletas();
        call.enqueue(new Callback<List<Atleta>>() {
            @Override
            public void onResponse(Call<List<Atleta>> call, Response<List<Atleta>> response) {
                System.out.println("Status code: " + response.code() + System.lineSeparator() +
                        "GET all atletas: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Atleta>> call, Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });

        String nacionalidad = "Suiza";
        Call<List<Atleta>> call1 = atletaService.findByNacionalidad(nacionalidad);
        call1.enqueue(new Callback<List<Atleta>>() {
            @Override
            public void onResponse(Call<List<Atleta>> call, Response<List<Atleta>> response) {
                System.out.println("Status code: " + response.code() + System.lineSeparator()
                        + "GET Atletas Nacionalidad = Suiza: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Atleta>> call, Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });

        String fecha = "08-05-1995";
        Call<List<Atleta>> call2 = atletaService.findByNacimientoAntes(fecha);
        call2.enqueue(new Callback<List<Atleta>>() {
            @Override
            public void onResponse(Call<List<Atleta>> call, Response<List<Atleta>> response) {
                System.out.println("Status code: " + response.code() + System.lineSeparator()
                        + "GET Atletas Fecha de nacimiento anterior a 08-05-1995: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Atleta>> call, Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });

        Call<Map<String, List<Atleta>>> call3 = atletaService.findByNacionalidadMap();
        call3.enqueue(new Callback<Map<String, List<Atleta>>>() {
            @Override
            public void onResponse(Call<Map<String, List<Atleta>>> call, Response<Map<String, List<Atleta>>> response) {
                System.out.println("Status code: " + response.code() + System.lineSeparator()
                        + "GET Atletas agrupados por nacionalidad: " + response.body());
            }

            @Override
            public void onFailure(Call<Map<String, List<Atleta>>> call, Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });

        Call<Map<TipoMedalla, List<Medalla>>> call4 = medallaService.findByTipoMedalla();
        call4.enqueue(new Callback<Map<TipoMedalla, List<Medalla>>>() {
            @Override
            public void onResponse(Call<Map<TipoMedalla, List<Medalla>>> call, Response<Map<TipoMedalla, List<Medalla>>> response) {
                System.out.println("Status code: " + response.code() + System.lineSeparator()
                        + "GET Atletas agrupados por medallas: " + response.body());
            }

            @Override
            public void onFailure(Call<Map<TipoMedalla, List<Medalla>>> call, Throwable throwable) {
                System.out.println("Error: " + throwable.getMessage());
            }
        });

    }
}
