import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.regex.Pattern;


public class SoftHillel extends Requests{
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost("http://soft.it-hillel.com.ua:3000/api/users");
            String body = "{\"name\": \"MyName\", \"phone\": \"7778855\",\"role\": \"Student\"}";
            HttpEntity json = new ByteArrayEntity(body.getBytes("UTF-8"));
            httppost.addHeader("Content-Type", "application/json");
            httppost.setEntity(json);
            HttpResponse responce = httpclient.execute(httppost);
            String result = EntityUtils.toString(responce.getEntity());
            System.out.println(result);
        } finally {
            httpclient.close();
        }
    }


    public void deleteUser() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpDelete deleteRequest = new HttpDelete("http://soft.it-hillel.com.ua:3000/api/users/130");
            deleteRequest.setHeader("Content-Type", "application/json");

            HttpResponse response = httpclient.execute(deleteRequest);
            String status = response.getStatusLine().toString();
            System.out.println(status);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    String useId;
    Pattern getId = Pattern.compile("\"id\":\"(\\d+)");
    Pattern findUsers = Pattern.compile("\\{[^\\}]*\"id\":\"" + useId + "\"[^\\}]*\\}");


    @Test
    public void deleteTest() throws IOException {
        deleteUser();
    }
    

    @Test
    void getUsers() throws IOException {
        String data = Requests.sendGet();
        Assert.assertTrue(data.contains("[{)"));
    }

    @Test
    void saveUsers(String data) throws IOException{
        String data = Requests.sendPut("http://soft.it-hillel.com.ua:3000/api/users/130", "{\"name\": \"API testing\"}");
        Assert.assertTrue(Requests.getData(useId)
    }







}