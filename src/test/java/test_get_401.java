import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import java.io.IOException;

public class test_get_401 {
    public static final  String BASE_URL= "https://api.github.com/";
    @Test
    public static void return_base_url_401() throws IOException {

        HttpGet get = new HttpGet(BASE_URL+"/user");
        CloseableHttpClient client=  HttpClientBuilder.create().build();

        HttpResponse response =  client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(401, actualStatus);
    }
}
