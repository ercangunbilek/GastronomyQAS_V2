import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public abstract class QueryStrategy {
    final String _apiKey = "1563e9f4a1msh2533481dd7de3b9p160ed6jsn20956f9b1e97";

    HttpResponse<JsonNode> execute(String keyword) {
        return null;
    }
}
