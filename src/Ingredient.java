import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Ingredient implements AnswerItem  {
    private String name;
    private double amount;
    private String unit;
    private ArrayList<Nutrition> nutritions = new ArrayList<Nutrition>();

    public Ingredient(String name, double amount, ArrayList<Nutrition> nutritions,String unitIngredient) {
        setName(name);
        setAmount(amount);
        setNutritions(nutritions);
        setUnit(unitIngredient);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Nutrition> getNutritions() {
        return nutritions;
    }

    public void setNutritions(ArrayList<Nutrition> nutritions) {
        this.nutritions = nutritions;
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
    public void print() {
        System.out.println(this.getName() + " , " + this.getAmount() + " ," + this.getUnit());
        for (Nutrition nutrition : nutritions)
        {
            nutrition.print();
        }
    }
}
