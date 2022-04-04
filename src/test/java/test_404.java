import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import java.io.IOException;
import entities.BaseClass;
public class test_404 extends BaseClass{


    @Test
    public static void return_base_url_404() throws IOException {

        HttpGet get = new HttpGet(BASE_URL+"/nonExistingName");
        CloseableHttpClient client=  HttpClientBuilder.create().build();

        HttpResponse response =  client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(404, actualStatus);
    }
}
