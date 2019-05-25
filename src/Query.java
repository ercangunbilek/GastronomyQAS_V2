import java.util.Hashtable;

public class Query {

    private Question question;
    private String url;
    private static Hashtable<String,String> urlTable = new Hashtable<String,String>();

    public Query(Question question) {
        setQuestion(question);
        setUrl();
    }


    public void executeQuery(){

    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    private void setUrl(){
        url = urlTable.get(question.getQuestionPattern().getQuestionType());
    }

    public String getUrl() {
        return url;
    }

    private static void initUrlTable(){
        urlTable.put("GetRecipe","https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/search?number=1&query={queryKeyword}");
        urlTable.put("GetIngredientCalorie","https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/parseIngredients?includeNutrition=true");
        urlTable.put("GetIngredientList","https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/search?number=1&query={queryKeyword}");
        urlTable.put("GetWine","https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/wine/pairing?maxPrice=50&food={food}");
    }


}
