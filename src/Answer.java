import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Answer {
    AnswerFactory answerFactory;
    AnswerItem answerItem;

    private void init()
    {
        answerFactory = new AnswerFactory();
    }
   public Answer(HttpResponse<JsonNode> response,String questionType){
       init();
       answerItem = answerFactory.getAnswerItem(response,questionType);
   }

}
