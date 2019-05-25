import java.util.Hashtable;

public class Question {

    private QuestionPattern questionPattern;
    private String keyword;
    private String url;
    private static Hashtable<String,String> urlTable = new Hashtable<String,String>();

    public Question(QuestionPattern questionPattern, String keyword) {
        initUrlTable();
        setQuestionPattern(questionPattern);
        setKeyword(keyword);
        url = urlTable.get(questionPattern.getQuestionType());
    }

    public QuestionPattern getQuestionPattern() {
        return questionPattern;
    }

    public void setQuestionPattern(QuestionPattern questionPattern) {
        this.questionPattern = questionPattern;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Query produceQuery(){
        Query query = new Query(this);
        return query;
    }

    public String getUrl() {
        return url;
    }

    private void initUrlTable(){
        urlTable.put("GetRecipe","https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/search?number=1&query={queryKeyword}");
        urlTable.put("GetIngredientCalorie","https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/parseIngredients?includeNutrition=true");
        urlTable.put("GetIngredientList","https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/search?number=1&query={queryKeyword}");
        urlTable.put("GetWine","https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/food/wine/pairing?maxPrice=50&food={food}");
    }


}
