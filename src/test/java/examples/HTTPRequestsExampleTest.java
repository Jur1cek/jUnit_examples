package examples;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HTTPRequestsExampleTest {
    HTTPRequestsExample httpRequestsExample = new HTTPRequestsExample();

    @Test
    void getConnectionTest() {
        assertDoesNotThrow(() -> httpRequestsExample.getConnection("https://xkcd.com/info.0.json"));
    }

    @Test
    void getXKCDTestMocked() throws Exception {
        HttpURLConnection connection = Mockito.mock(HttpURLConnection.class);

        String jsonString = "{\"month\": \"10\", \"num\": 2371, \"link\": \"\", \"year\": \"2020\", \"news\": \"\", \"safe_title\": \"Election Screen Time\", \"transcript\": \"\", \"alt\": \"Feels like I picked a bad year to try to start having a healthy relationship with political news.\", \"img\": \"https://imgs.xkcd.com/comics/election_screen_time.png\", \"title\": \"Election Screen Time\", \"day\": \"12\"}";
        InputStream inputStream = new ByteArrayInputStream(jsonString.getBytes());

        Mockito.when(connection.getInputStream()).thenReturn(inputStream);

        assertEquals("Election Screen Time", httpRequestsExample.getXKCD(connection).title);
    }
}