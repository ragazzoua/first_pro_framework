package http_client;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;


public class HttpClient {
    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void sendGetRequest(String url) {
        HttpGet request = new HttpGet(url);
        request.addHeader("", "");
        try {
            CloseableHttpResponse response = httpClient.execute(request);

            System.out.println(response.getProtocolVersion());
            System.out.println(response.getStatusLine().getStatusCode());
            System.out.println(response.getStatusLine().getReasonPhrase());
            System.out.println(response.getStatusLine().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendPostRequest(String url) throws IOException {
        HttpPost post = new HttpPost(url);
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("username", ""));
        nameValuePairs.add(new BasicNameValuePair("password", ""));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        CloseableHttpResponse response = httpClient.execute(post);
    }

    public static void sendDeleteRequest(String url) throws IOException {
        HttpDelete delete = new HttpDelete(url);
        CloseableHttpResponse response = httpClient.execute(delete);
    }

    public static void sendPutRequest(String url) throws IOException {
        HttpPut put = new HttpPut(url);
        CloseableHttpResponse response = httpClient.execute(put);
    }

}
