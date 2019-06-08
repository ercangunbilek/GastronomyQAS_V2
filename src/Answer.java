import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Answer {
    AnswerFactory answerFactory=new AnswerFactory();
    String questionType;
   /* public Answer parse(HttpResponse<JsonNode> response){
        switch (questionType){
            case "Recipe":
                Recipe recipe=answerFactory.getAnswerItem(response);
                break;
            case "Ingredient":
                Ingredient ingredient=answerFactory.getAnswerItem(response);
                break;
            case "Nutrition":
                Nutrition nutrition=answerFactory.getAnswerItem(response);
                break;
            case "Wine":
                Wine wine=answerFactory.getAnswerItem(response);
                break;
       }
        return new Answer();
    }*/
   public Answer(HttpResponse<JsonNode> response){
       AnswerItem answer=answerFactory.getAnswerItem(questionType);
   }

}
