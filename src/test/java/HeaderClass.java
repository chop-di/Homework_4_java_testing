import entities.BaseClass;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HeaderClass extends BaseClass {
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
    public void testContentTypeHeader() throws IOException {

        HttpGet get = new HttpGet(BASE_URL);

        response = client.execute(get);

        Header contentType = response.getEntity().getContentType();
        assertEquals(contentType.getValue(), "application/json");


    }
    @Test
    public void testContentTypeMIME() throws IOException {

        HttpGet get = new HttpGet(BASE_URL);

        response = client.execute(get);

       ContentType ct = ContentType.getOrDefault(response.getEntity());
        assertEquals(ct.getMimeType(), "application/json");


    }
    @Test
    public void testContentLengthHeader() throws IOException {

        HttpGet get = new HttpGet(BASE_URL);

        response = client.execute(get);

String headerValue = ResponseUtils.getHeader(response,"x-ratelimit-reset");
//assertEquals(ContentLengthHeader(response ,"1647680798");


    }
    @Test
    public void testPresentHeader() throws IOException {

        HttpGet get = new HttpGet(BASE_URL);

        response = client.execute(get);


        Assert.assertEquals(true, ResponseUtils.headerIsPresent(response,"x-ratelimit-limit"));


    }
}

