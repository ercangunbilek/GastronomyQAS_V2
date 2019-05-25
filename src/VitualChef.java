public class VitualChef {


    public static void askQuestion(String questionText){

        Decoder decoder = new Decoder();
        Question question = decoder.decodeQuestionText(questionText);
        Query query = question.produceQuery();
        query.executeQuery();
    }
}
