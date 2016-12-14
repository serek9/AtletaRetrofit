import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class RestAsync {
    private static Retrofit retrofit;

    public static void main(String[] args) {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AtletaService atletaService = retrofit.create(AtletaService.class);

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
    }
}
