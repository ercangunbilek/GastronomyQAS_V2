import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Answer {
    AnswerFactory answerFactory;
    AnswerItem answerItem;

   public Answer(){
       answerFactory = new AnswerFactory();

   }
   public void produceAnswer(HttpResponse<JsonNode> response,String questionType)
   {
       answerItem = answerFactory.getAnswerItem(response,questionType);
   }

}
