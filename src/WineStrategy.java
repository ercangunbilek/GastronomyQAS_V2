import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class WineStrategy extends QueryStrategy {
    private String _getWineUrl= "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/wine/pairing?maxPrice=50&food={food}";

    public HttpResponse<JsonNode> execute(String keyword)
    {
        try {
            return Unirest.get(_getWineUrl)
                    .header("X-RapidAPI-Key", _apiKey)
                    .routeParam("food",keyword)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }
}
