import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Ingredient implements AnswerItem  {
    private double amount;
    private String unit;
    List<Nutrition> nutritionList =null;
    public Ingredient(){

    }
    //getter setter methods
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public void add(HttpResponse<JsonNode> response) {
        //fill properties with response

        nutritionList =new ArrayList<Nutrition>();
        JSONArray nutritionJsonArray;
        try {
            nutritionJsonArray = response.getBody().getObject().getJSONObject("nutrition").getJSONArray("nutrients");
        } catch (Exception e) {
            nutritionJsonArray=response.getBody().getObject().getJSONArray("nutrients");
        }
        for(int i=0;i<nutritionJsonArray.length();i++){

            JSONObject nutritionJsonObject = nutritionJsonArray.getJSONObject(i);
            //Must create through factory
            Nutrition nutrition = new Nutrition();
            nutritionList.add(nutrition);

        }
    }
}
