import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONArray;

import java.util.*;

public class Recipe extends AnswerItem {
    private String name;
    private String instruction;
    private double instructionTime;
    private List<Ingredient>ingredientList=null;
    /*  public Recipe(){
          ingredientList=new ArrayList<Ingredient>();
      }*/
    public Recipe(HttpResponse<JsonNode> response){
        //fill properties with response
        name=response.getBody().getObject().getString("name");
        instruction = response.getBody().getObject().getString("instructions");
        instructionTime= response.getBody().getObject().getInt("readyInMinutes");
        ingredientList = new ArrayList<Ingredient>();
       // ArrayList<Nutrition> nutritionArrayList = new ArrayList<Nutrition>();
        JSONArray ingredientJsonArray = response.getBody().getObject().getJSONObject("nutrition").getJSONArray("ingredients");

        for(int i = 0;i<ingredientJsonArray.length();i++){
            ingredientList.add(new Ingredient(response));
        }

    }
    //getter setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public double getInstructionTime() {
        return instructionTime;
    }

    public void setInstructionTime(double instructionTime) {
        this.instructionTime = instructionTime;
    }
}