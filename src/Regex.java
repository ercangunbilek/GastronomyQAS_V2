import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex {

    private static ArrayList<String> keywordList = new ArrayList<String>();
    private static Pattern p;
    private static Matcher m;


    public static void compile(QuestionPattern questionPattern){
        p = Pattern.compile(questionPattern.getPatternText(),Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    }

    public static boolean isMatch(String questionText){
        m = p.matcher(questionText);
        return m.matches();
    }

    public static String findKeyword(){
        for (int i = 1; i < m.groupCount();i++)
        {
            if(m.group(i) != null && !m.group(i).equals(" ") && i != 7) // 7 unique keyword (make,prepare,etc)
            {
                String word = m.group(i).trim();
                if(!keywordList.contains(word))
                {
                    return word;
                }
            }
        }

        return null;
    }

    public static void initKeywordList(){
        keywordList.add("what");
        keywordList.add("how");
        keywordList.add("to");
        keywordList.add("many");
        keywordList.add("much");
        keywordList.add("in");
        keywordList.add("an");
        keywordList.add("a");
        keywordList.add("am");
        keywordList.add("is");
        keywordList.add("are");
        keywordList.add("of");
        keywordList.add("i");
        keywordList.add("for");
        keywordList.add("suggest");
        keywordList.add("offer");
        keywordList.add("");
    }
}
