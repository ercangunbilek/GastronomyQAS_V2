import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class APIHelper {

    public static HttpResponse<JsonNode> request(Question question) {

        HttpResponse<JsonNode> response = null;
        switch (question.getQuestionPattern().getQuestionType()) {
            case "Recipe":
                QueryStrategy recipeStrategy = new RecipeStrategy();
                return recipeStrategy.execute(question.getKeyword());
            case "GetIngredientList":
                QueryStrategy recipeIngredientStrategy = new RecipeStrategy();
                return recipeIngredientStrategy.execute(question.getKeyword());
            case "GetIngredientCalorie":
                QueryStrategy ingredientStrategy = new IngredientStrategy();
                return ingredientStrategy.execute(question.getKeyword());
            case "Wine":
                QueryStrategy wineStrategy = new WineStrategy();
                return wineStrategy.execute(question.getKeyword());
        }
        return response;
    }
}
