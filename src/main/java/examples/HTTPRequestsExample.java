package examples;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequestsExample {
    HttpURLConnection getConnection(String urlString) throws IOException {

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("accept", "application/json");

        return connection;
    }

    public APOD getXKCD(HttpURLConnection connection) throws IOException {
        InputStream responseStream = connection.getInputStream();

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(responseStream, APOD.class);
    }
}
