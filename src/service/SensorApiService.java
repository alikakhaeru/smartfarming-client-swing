package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Sensor;
import java.util.List;

public class SensorApiService {

    private final Gson gson = new Gson();

    public List<Sensor> getAll() throws Exception {
        String json = ApiClient.get("/sensor.php");
        return gson.fromJson(json, new TypeToken<List<Sensor>>(){}.getType());
    }

    public void save(Sensor s) throws Exception {
        ApiClient.post("/sensor.php", gson.toJson(s));
    }

    public void delete(int id) throws Exception {
        ApiClient.delete("/sensor.php?id=" + id);
    }
}
