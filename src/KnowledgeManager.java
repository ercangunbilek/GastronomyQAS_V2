import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class KnowledgeManager
{
    private Cache _cache;

    public KnowledgeManager()
    {
        init();
    }
    private void init()
    {
        _cache = Cache.getInstance();
    }
    public Answer findAnswer(Question question)
    {
        Answer answer = _cache.searchAnswer(question);
        if(answer == null)
        {
            APIHelper helper = new APIHelper();
            HttpResponse<JsonNode> response = helper.request(question);
            answer = answer.parse(response);
        }
        return answer;
    }
}
