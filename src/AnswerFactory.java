import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class AnswerFactory {
    public AnswerItem getAnswerItem(HttpResponse<JsonNode> response,String questionType){
        if (questionType==null)
            return null;
        if (questionType.equalsIgnoreCase("Recipe"))
        {
            JSONObject recipeJsonObject = response.getBody().getObject();

            Recipe recipe = parseJsonRecipe(recipeJsonObject);
            return recipe;
        }
        else if(questionType.equalsIgnoreCase("GetIngredientList"))
        {
            JSONObject recipeJsonObject = response.getBody().getObject();

            Recipe recipe = parseJsonRecipe(recipeJsonObject);
            return recipe;
        }
        else if (questionType.equalsIgnoreCase("GetIngredientCalorie"))
        {
            JSONObject jsonObject = response.getBody().getArray().getJSONObject(0);
            return parseJsonIngredient(jsonObject);
        }
        else if (questionType.equalsIgnoreCase("Wine"))
        {
            JSONObject wineJsonObject=response.getBody().getObject();
            Wine wine =  new Wine();
            wine.setName(wineJsonObject.getString("pairingText"));
            return wine;
        }
        return null;
    }
    public Recipe parseJsonRecipe(JSONObject recipeJsonObject)
    {

        ArrayList<Ingredient> ingredientArrayList = new ArrayList<Ingredient>();
        ArrayList<Nutrition> nutritionArrayList = new ArrayList<Nutrition>();

        JSONArray ingredientJsonArray = recipeJsonObject.getJSONObject("nutrition").getJSONArray("ingredients");

        for(int i = 0;i<ingredientJsonArray.length();i++){


            JSONObject ingredientJsonObject = ingredientJsonArray.getJSONObject(i);
            Ingredient ingredient = parseJsonIngredient(ingredientJsonObject);
            ingredientArrayList.add(ingredient);

        }

        Recipe recipe = new Recipe(recipeJsonObject.getString("instructions"),
                recipeJsonObject.getInt("readyInMinutes"),
                recipeJsonObject.getBoolean("vegan"),
                recipeJsonObject.getBoolean("glutenFree"),
                recipeJsonObject.getBoolean("vegetarian"),
                recipeJsonObject.getBoolean("ketogenic"),ingredientArrayList);

        return recipe;
    }
    private Nutrition parseJsonNutritions(JSONObject nutritionJsonObject)
    {

        String nameNutrition;

        try {
            nameNutrition = nutritionJsonObject.getString("title");
        }catch (Exception e){
            nameNutrition = nutritionJsonObject.getString("name");
        }
        Double amountNutrition = nutritionJsonObject.getDouble("amount");
        String unitNutrition = nutritionJsonObject.getString("unit");

        Nutrition nutrition = new Nutrition(nameNutrition,amountNutrition, unitNutrition);


        return nutrition;
    }
    private Ingredient parseJsonIngredient(JSONObject ingredientJsonObject){
        ArrayList<Nutrition> nutritionArrayList = new ArrayList<Nutrition>();
        JSONArray nutritionJsonArray;
        try {
            nutritionJsonArray = ingredientJsonObject.getJSONObject("nutrition").getJSONArray("nutrients");
        }catch (Exception e){
            nutritionJsonArray = ingredientJsonObject.getJSONArray("nutrients");
        }


        for(int i=0;i<nutritionJsonArray.length();i++){

            JSONObject nutritionJsonObject = nutritionJsonArray.getJSONObject(i);
            Nutrition nutrition = parseJsonNutritions(nutritionJsonObject);
            nutritionArrayList.add(nutrition);

        }


        Ingredient ingredient = new Ingredient(ingredientJsonObject.getString("name"),
                ingredientJsonObject.getDouble("amount"),
                nutritionArrayList,
                ingredientJsonObject.getString("unit")
        );
        return ingredient;
    }
}
