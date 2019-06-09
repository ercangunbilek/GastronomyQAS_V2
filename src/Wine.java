import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Wine implements AnswerItem  {
    private String name;
    private double price;
    private String color;
    public Wine(){

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



    @Override
    public void print() {

        System.out.println(getName());
    }
}
