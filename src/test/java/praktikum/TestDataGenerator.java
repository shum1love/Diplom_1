package praktikum;

import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {
    public static List<Ingredient> createDefaultIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        //ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        Ingredient cheese = new Ingredient(IngredientType.SAUCE, "Cheese", 200);
        Ingredient tomato = new Ingredient(IngredientType.FILLING, "Tomato", 100);
        Ingredient meat = new Ingredient(IngredientType.FILLING,"Meat", 300);

        ingredients.add(cheese);
        ingredients.add(tomato);
        ingredients.add(meat);

        return ingredients;
    }
}
