import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Answer {
    String questionType;
    public Answer parse(HttpResponse<JsonNode> response){
        AnswerItem answerItem=new AnswerItem();
        switch (questionType){
            case "Recipe":
                Recipe recipe=new Recipe(response);
                break;
            case "Ingredient":
                Ingredient ingredient=new Ingredient(response);
                break;
            case "Nutrition":
                Nutrition nutrition=new Nutrition(response);
                break;
            case "Wine":
                Wine wine=new Wine(response);
                break;
        }
        return new Answer();
    }
}
