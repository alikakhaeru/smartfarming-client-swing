package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Lahan;
import java.util.List;

public class LahanApiService {
    private final Gson gson = new Gson();

    public List<Lahan> getAll() throws Exception {
        // Tanpa "/" di depan agar tidak double slash
        String json = ApiClient.get("lahan.php");
        return gson.fromJson(json, new TypeToken<List<Lahan>>(){}.getType());
    }

    public void save(Lahan l) throws Exception {
        ApiClient.post("lahan.php", gson.toJson(l));
    }

    public void update(Lahan l) throws Exception {
        // Kirim ID di URL dan object JSON di Body
        // Pastikan variabel l.id di class Lahan bersifat PUBLIC
        ApiClient.put("lahan.php?id=" + l.id, gson.toJson(l));
    }

    public void delete(int id) throws Exception {
        ApiClient.delete("lahan.php?id=" + id);
    }
}