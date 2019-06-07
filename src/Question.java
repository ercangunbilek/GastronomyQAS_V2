import java.util.Hashtable;

public class Question {

    private QuestionPattern questionPattern;
    private String keyword;

    public Question(QuestionPattern questionPattern, String keyword) {
        setQuestionPattern(questionPattern);
        setKeyword(keyword);
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








}
