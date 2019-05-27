import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import java.util.*;

public class Cache {
private Answer answer;
private Map<Query,Answer> _answerTable;
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
public void searchAnswer(Query query)
{
    answer = _answerTable.get(query);
    if(answer == null)
    {
        HttpResponse<JsonNode> response = _apiHelper.request(query);
        answer = new Answer();
        answer = answer.parse(response);
        if(answer != null)
        {
            _answerTable.put(query,answer);
        }

    }
}
public Answer getAnswer()
{
    return answer;
}

}

