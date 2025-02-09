import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Main {
    public static final String URL = "https://jsonplaceholder.typicode.com/posts/1";
    public static void main(String[] args){
        System.out.println("Hello Fucker");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(URL))
                .build();
    }
}
