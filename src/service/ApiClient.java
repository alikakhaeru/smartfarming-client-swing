package service;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class ApiClient {
    private static final String BASE_URL = "http://localhost/smartfarming-application-tier/public/";

    private static String request(String method, String endpoint, String json) throws IOException {
        URL url = new URL(BASE_URL + endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setConnectTimeout(5000);

        if (json != null) {
            conn.setDoOutput(true);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes(StandardCharsets.UTF_8));
            }
        }

        int status = conn.getResponseCode();
        InputStream is = (status < 400) ? conn.getInputStream() : conn.getErrorStream();
        
        if (is == null) return "[]";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) sb.append(line);
            return sb.toString();
        }
    }

    public static String get(String endpoint) throws IOException { return request("GET", endpoint, null); }
    public static String post(String endpoint, String json) throws IOException { return request("POST", endpoint, json); }
    public static String put(String endpoint, String json) throws IOException { return request("PUT", endpoint, json); }
    public static String delete(String endpoint) throws IOException { return request("DELETE", endpoint, null); }
}