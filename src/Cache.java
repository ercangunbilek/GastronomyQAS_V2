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
    if(cache==null)
        cache = new Cache();
    return cache;
}
    public Answer searchAnswer(Question question)
{
    return _answerTable.get(question);
}
}

