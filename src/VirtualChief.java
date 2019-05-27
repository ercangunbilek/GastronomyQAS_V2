public class VirtualChief {

    static Cache cache;
    public VirtualChief()
    {
        init();
    }
    private void init()
    {
        cache = Cache.getInstance();
    }
    public static void askQuestion(String questionText){


        Decoder decoder = new Decoder();
        Question question = decoder.decodeQuestionText(questionText);

        if(question!=null) {
            Query query = question.produceQuery();
            query.executeQuery();
            Answer answer = cache.getAnswer();
        }
    }
}
