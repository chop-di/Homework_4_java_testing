import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertEquals;
import java.io.IOException;
import entities.BaseClass;
public class test_401 extends BaseClass{
    CloseableHttpClient client;
    CloseableHttpResponse response;
@BeforeMethod
public void setup() {
    client=  HttpClientBuilder.create().build();
}
@AfterMethod
public void teardown() throws IOException {
    client.close();
    response.close();
}
    @Test(dataProvider = "endpoints")
    public void return_base_url_401(String endpoint) throws IOException {

        HttpGet get = new HttpGet(BASE_URL+endpoint);


        response =  client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(403, actualStatus);
    }

    @DataProvider
    private Object[][] endpoints(){
        return new Object[][]  {
                {"/user"},
                {"/user/followers"},
                {"/notifications"}
        };
    }
}

