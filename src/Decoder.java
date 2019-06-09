import java.sql.SQLOutput;
import java.util.ArrayList;

public class Decoder {

    public Decoder(){
        initPatternList();
    }

    public static ArrayList<QuestionPattern> patternList = new ArrayList<QuestionPattern>();

    public static Question decodeQuestionText(String questionText){


        for(int i=0;i<patternList.size();i++){


            QuestionPattern questionPattern = patternList.get(i);
            Regex.compile(questionPattern);
            Boolean condition = Regex.isMatch(questionText);

            if(condition){
                String keyword = Regex.findKeyword();

                if(keyword!=null){
                Question question = new Question(questionPattern,keyword);
                return question;
                }else{
                    return null;
                }
            }

        }

        System.out.println("Please,ask valid question!");
        return null;
    }

    public void initPatternList(){
        patternList.add(new QuestionPattern("Recipe","([a-z]*)?((\\s)[a-z]*(\\s))*([a-z]*(\\s))?(?<verb>make[a-z]*|prep[a-z]*|cook[a-z]*){1}((\\s)[a-z]*)?((\\s)[a-z]*)?((\\s)[a-z]*)?"));
        patternList.add(new QuestionPattern("GetIngredientCalorie","([a-z]*)?((\\s)[a-z]*(\\s))*([a-z]*(\\s))?(?<verb>cal[a-z]*){1}((\\s)[a-z]*)?((\\s)[a-z]*)?((\\s)[a-z]*)?"));
        patternList.add(new QuestionPattern("GetIngredientList","([a-z]*)?((\\s)[a-z]*(\\s))*([a-z]*(\\s))?(?<verb>ingre[a-z]*|need[a-z]*){1}((\\s)[a-z]*)?((\\s)[a-z]*)?((\\s)[a-z]*)?"));
        patternList.add(new QuestionPattern("Wine","([a-z]*)?((\\s)[a-z]*(\\s))*([a-z]*(\\s))?(?<verb>wine[a-z]*){1}((\\s)[a-z]*)?((\\s)[a-z]*)?((\\s)[a-z]*)?"));
    }
}
