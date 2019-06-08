import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import java.util.*;

public class Cache {
private Map<Question,Answer> _answerTable;
private APIHelper _apiHelper;

private static Cache cache;
public void init()
{
    _answerTable = new HashMap<>();
    _apiHelper = new APIHelper();
}
private Cache()
{
    init();
}
public static Cache getInstance()
{
    if(cache!=null)
        cache = new Cache();
    return cache;
}
    public Answer searchAnswer(Question question)
{
    Answer answer = _answerTable.get(question);
    if(answer == null)
    {
        HttpResponse<JsonNode> response = _apiHelper.request(question);
        answer = new Answer(response);
       // answer = answer.parse(response);
        if(answer != null)
        {
            _answerTable.put(question,answer);
        }

    }
    return answer;
}
}

