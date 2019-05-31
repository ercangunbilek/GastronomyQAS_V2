import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

public class IngredientStrategy extends QueryStrategy {
    private String _searchIngredientURL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/parseIngredients?includeNutrition=true";
    public HttpResponse<JsonNode> execute(String keyword)
    {
        try {
            return Unirest.post(_searchIngredientURL)
                    .header("X-RapidAPI-Key", _apiKey)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .field("ingredientList", keyword)
                    .field("servings", 1)
                    .asJson();
        } catch (Exception e) {
            System.out.println("Undefined keyword(s)");
            return null;
        }
    }

}
