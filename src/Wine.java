import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Wine extends AnswerItem  {
    private String name;
    private double price;
    private String color;
    public Wine(HttpResponse<JsonNode> response){
        //fill properties with response
    }
    //getter setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
