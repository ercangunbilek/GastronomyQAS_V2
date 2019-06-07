public class VirtualChief {

    private static VirtualChief virtualChief;
    private static Cache cache;
    private VirtualChief()
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

    public static VirtualChief getInstance(){
        if(virtualChief==null)
            virtualChief = new VirtualChief();
        return virtualChief;

    }
}
