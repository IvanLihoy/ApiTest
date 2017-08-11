import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;


public class FindFacebookId {
    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpResponse response = httpclient.execute(new HttpGet("https://www.7xter.com/ads/findmyid/index.php?username=joe.colella.397?fref=grp_mmbr_list.html"));
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        System.out.println(responseString.replaceAll("[a-zA-Z\\s]", ""));
    }


    public void getFacebookUrl(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpResponse response = httpclient.execute(new HttpGet(url));
    }
}
