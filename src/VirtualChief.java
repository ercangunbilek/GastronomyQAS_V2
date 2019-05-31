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

        KnowledgeManager knowledgeManager = new KnowledgeManager();
        Decoder decoder = new Decoder();
        Question question = decoder.decodeQuestionText(questionText);

        if(question!=null) {
            Answer answer = knowledgeManager.findAnswer(question);
        }
    }
}
