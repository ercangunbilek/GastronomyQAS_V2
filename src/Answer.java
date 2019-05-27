import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Answer {
    public Answer parse(HttpResponse<JsonNode> response)
    {
        return new Answer();
    }
}
