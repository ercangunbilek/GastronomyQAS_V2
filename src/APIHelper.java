import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class APIHelper {
    private String _apiKey = "1563e9f4a1msh2533481dd7de3b9p160ed6jsn20956f9b1e97";

    public HttpResponse<JsonNode> request(Query query){
        try {
            return Unirest.get(query.getUrl())
                    .header("X-RapidAPI-Key", _apiKey)
                    .routeParam("keyword1",query.getQuestion().getKeyword()).asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }
    }

