import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class RecipeStrategy extends QueryStrategy {
    private String _searchRecipeURL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/search?number=1&query={queryKeyword}";
    private String _findRecipeByIdURL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/{recipeId}/information?includeNutrition=true";
    @Override
    public HttpResponse<JsonNode> execute(String keyword) {
        try {
            HttpResponse<JsonNode> recipe_id = Unirest.get(_searchRecipeURL)
                    .header("X-RapidAPI-Key", _apiKey)
                    .routeParam("queryKeyword",keyword)
                    .asJson();
            JSONObject jsonObject = recipe_id.getBody().getObject().getJSONArray("results").getJSONObject(0);
            int recipeId = jsonObject.getInt("id");
            //get recipe by id . . .
            HttpResponse<JsonNode> response = Unirest.get(_findRecipeByIdURL)
                    .header("X-RapidAPI-Key", _apiKey)
                    .routeParam("recipeId", String.valueOf(recipeId))
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }
}
