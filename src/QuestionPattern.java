public class QuestionPattern {
    private String patternText;
    private String questionType;

    public QuestionPattern(String questionType, String patternText) {
        setPatternText(patternText);
        setQuestionType(questionType);
    }

    public String getPatternText() {
        return patternText;
    }

    public void setPatternText(String patternText) {
        this.patternText = patternText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }
}
