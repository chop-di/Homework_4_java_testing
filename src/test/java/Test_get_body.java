import entities.BaseClass;
import entities.User;
import netscape.javascript.JSObject;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Test_get_body extends BaseClass {
    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void setup() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {
        client.close();
        response.close();
    }

    @Test
    public void returnsCorrectID() throws IOException {

        HttpGet get = new HttpGet(BASE_URL + "/users/chop-di");

        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);
        Integer idValue = (Integer) jsonObject.get("id");

        Integer expectedID = 79254984;
        assertEquals(idValue, expectedID);


    }

    @Test
    public void returnsFollowers() throws IOException {

        HttpGet get = new HttpGet(BASE_URL + "/users/chop-di/followers");

        response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);
        Integer idValue = (Integer) jsonObject.get("followers");


    }

    @Test
    public void returnsCorrectID_unmarshall() throws IOException {

        HttpGet get = new HttpGet(BASE_URL + "/users/chop-di");

        response = client.execute(get);
        User user = ResponseUtils.unmarshall(response, User.class);

        assertEquals(user.getId(), 79254984);
    }
}