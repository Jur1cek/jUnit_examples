package examples;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.*;

class HTTPRequestsExampleTest {
    HTTPRequestsExample httpRequestsExample = new HTTPRequestsExample();
    HttpURLConnection connection;
    @BeforeEach
    void setUp() throws IOException {
        this.connection = Mockito.mock(HttpURLConnection.class);

        String jsonString = "{\"month\": \"10\", \"num\": 2371, \"link\": \"\", \"year\": \"2020\", \"news\": \"\", \"safe_title\": \"Election Screen Time\", \"transcript\": \"\", \"alt\": \"Feels like I picked a bad year to try to start having a healthy relationship with political news.\", \"img\": \"https://imgs.xkcd.com/comics/election_screen_time.png\", \"title\": \"Election Screen Time\", \"day\": \"12\"}";
        InputStream inputStream = new ByteArrayInputStream(jsonString.getBytes());

        Mockito.when(connection.getInputStream()).thenReturn(inputStream);
    }

    @Test
    void getConnectionTest() {
        assertDoesNotThrow(() -> httpRequestsExample.getConnection("https://xkcd.com/info.0.json"));
    }

    @Test
    void getXKCDTitleMocked() throws IOException {
        assertEquals("Election Screen Time", httpRequestsExample.getXKCD(this.connection).title);
    }

    @Test
    void getXKCDNewsMocked() throws IOException {
        assertEquals("", httpRequestsExample.getXKCD(this.connection).news);
    }


    @Test
    void getXKCDMonthMockedValue() throws IOException {
        assertEquals(10, httpRequestsExample.getXKCD(this.connection).month);
    }

    @Test
    @DisplayName("Is this really necessary?")
    void getXKCDMonthMockedType() throws IOException {
        assertTrue(httpRequestsExample.getXKCD(this.connection).month instanceof String);
    }
}