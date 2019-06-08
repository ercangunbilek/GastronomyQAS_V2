import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public interface AnswerItem {
    public void add(HttpResponse<JsonNode> response);

}
