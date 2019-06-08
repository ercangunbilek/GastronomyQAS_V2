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
    public static Answer askQuestion(String questionText){
        Answer answer = null;
        KnowledgeManager knowledgeManager = new KnowledgeManager();
        Decoder decoder = new Decoder();
        Question question = decoder.decodeQuestionText(questionText);

        if(question!=null) {
            answer = knowledgeManager.findAnswer(question);
        }
        return answer;
    }

    public static VirtualChief getInstance(){
        if(virtualChief==null)
            virtualChief = new VirtualChief();
        return virtualChief;

    }
}
