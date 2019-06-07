import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class APIHelper {

    public HttpResponse<JsonNode> request(Question question) {

        HttpResponse<JsonNode> response = null;
        switch (question.getQuestionPattern().getQuestionType()) {
            case "Recipe":

                break;
            case "Ingredient":

                break;
        }

        return response;
    }
}
