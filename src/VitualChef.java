public class VitualChef {


    public static void askQuestion(String questionText){


        Decoder decoder = new Decoder();
        Question question = decoder.decodeQuestionText(questionText);

        if(question!=null) {
            Query query = question.produceQuery();
            query.executeQuery();
        }
    }
}
