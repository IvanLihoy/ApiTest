import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;


public class FindFacebookId {
    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpResponse response = httpclient.execute(new HttpGet("http://soft.it-hillel.com.ua:3000/api/users"));
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        System.out.println(responseString);
        //System.out.println(responseString.replaceAll("[a-zA-Z\\s]", ""));
    }


    public void getFacebookUrl(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpResponse response = httpclient.execute(new HttpGet(url));
    }
}
