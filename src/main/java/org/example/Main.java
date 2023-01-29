package org.example;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Main {
    public static void main(String[] args) {
        try{
            FetchDataUsingJava_1();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void FetchDataUsingJava_1() throws Exception {
        String URL = "https://api.chucknorris.io/jokes/random";
        //building a request .
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(URL)).build();
        //getting the httpclient object
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
        System.out.println(httpResponse.statusCode());
        JSONObject jsonObject = new JSONObject(httpResponse.body());
        System.out.println("This is a json Response");
        System.out.println(jsonObject);
        String updated = jsonObject.getString("updated_at");
        System.out.println("This is updated time:"+updated);
        String Created = jsonObject.getString("created_at");
        System.out.println("This is Created time:"+Created);
        String Value = jsonObject.getString("value");
        System.out.println("This is the value:"+Value);
    }
}