import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Nutrition implements AnswerItem  {
    private String name;
    private double amount;
    private String unit;
    public Nutrition(){


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
    public void add(HttpResponse<JsonNode> response) {
        //fill properties with response
        try {
            name = response.getBody().getObject().getString("title");
        }catch (Exception e){
            name = response.getBody().getObject().getString("name");
        }
        amount= response.getBody().getObject().getDouble("amount");
        unit = response.getBody().getObject().getString("unit");
    }
}
