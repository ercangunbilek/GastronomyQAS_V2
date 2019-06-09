import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Nutrition implements AnswerItem  {
    private String name;
    private double amount;
    private String unit;
    public Nutrition(String name, double amount, String unitNutrition) {
        setName(name);
        setAmount(amount);
        setUnit(unitNutrition);
    }
    //getter setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        System.out.println("Nutrition{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", unitNutrition=" + unit +
                '}');
    }
}
