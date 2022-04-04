import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import java.io.IOException;

public class test_get_304 {
    @Test
    public static void return_base_url_304() throws IOException {
        HttpGet get = new HttpGet("https://api.github.com/");
        CloseableHttpClient client=  HttpClientBuilder.create().build();

        HttpResponse response =  client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(200, actualStatus);
    }
}
