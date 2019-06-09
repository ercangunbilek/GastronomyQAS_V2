import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONArray;

import java.util.*;

public class Recipe implements AnswerItem {
    private String instruction;
    private int recipeTime;
    private boolean vegan,glutenFree,vegeterian,ketogenic;
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    public int getRecipeTime() {
        return recipeTime;
    }

    public void setRecipeTime(int recipeTime) {
        this.recipeTime = recipeTime;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isVegeterian() {
        return vegeterian;
    }

    public void setVegeterian(boolean vegeterian) {
        this.vegeterian = vegeterian;
    }

    public boolean isKetogenic() {
        return ketogenic;
    }

    public void setKetogenic(boolean ketogenic) {
        this.ketogenic = ketogenic;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /*  public Recipe(){
              ingredientList=new ArrayList<Ingredient>();
          }*/
    public Recipe(String instruction, int recipeTime, boolean vegan, boolean glutenFree, boolean vegeterian, boolean ketogenic, ArrayList<Ingredient> ingredients) {

        setInstruction(instruction);
        setRecipeTime(recipeTime);
        setVegan(vegan);
        setGlutenFree(glutenFree);
        setVegeterian(vegeterian);
        setKetogenic(ketogenic);
        setIngredients(ingredients);
    }


    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    @Override
    public void print() {
        System.out.println(("Recipe Time=" + recipeTime + "min\n" +
                "Instruction='" + instruction + "\n"));

             /*   "Vegan=" +vegan+'\n'+
                "Gluten Free=" + glutenFree +"\n"+
                "Vegeterian=" + vegeterian +"\n"+
                "Ketogenic=" + ketogenic +"\n"+
                "Ingredients=" + ingredients+"\n"*/;
    }
}