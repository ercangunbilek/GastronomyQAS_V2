public class AnswerFactory {
    public AnswerItem getAnswerItem(String answerType){
        if (answerType==null)
            return null;
        if (answerType.equalsIgnoreCase("Recipe"))
            return new Recipe();
        else if(answerType.equalsIgnoreCase("Ingredient"))
            return new Ingredient();
        else if (answerType.equalsIgnoreCase("Nutrition"))
            return new Nutrition();
        else if (answerType.equalsIgnoreCase("Wine"))
            return new Wine();
        return null;
    }
}
