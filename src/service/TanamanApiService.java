package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Tanaman;
import java.util.List;

public class TanamanApiService {

    private final Gson gson = new Gson();

    public List<Tanaman> getAll() throws Exception {
        String json = ApiClient.get("/tanaman.php");
        return gson.fromJson(json, new TypeToken<List<Tanaman>>(){}.getType());
    }

    public void save(Tanaman t) throws Exception {
        ApiClient.post("/tanaman.php", gson.toJson(t));
    }

    public void update(Tanaman t) throws Exception {
        ApiClient.put("/tanaman.php?id=" + t.id, gson.toJson(t));
    }

    public void delete(int id) throws Exception {
        ApiClient.delete("/tanaman.php?id=" + id);
    }
}
