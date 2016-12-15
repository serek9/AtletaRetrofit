import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface MedallaService {

    @GET("/medallas/byTipoMedalla")
    Call<Map<TipoMedalla, List<Medalla>>> findByTipoMedalla();
}
