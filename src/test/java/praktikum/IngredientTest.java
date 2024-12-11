package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    // Тестирование конструктора и геттеров
    @Test
    public void testConstructorAndGettersSauce() {
        // Создаем стаб объекта Ingredient
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 50.0f);

        // Проверяем, что значения правильно сохраняются и возвращаются геттерами
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
    @Test
    public void testConstructorAndGettersIngredient() {
        // Создаем стаб объекта Ingredient
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 50.0f);

        // Проверяем, что значения правильно сохраняются и возвращаются геттерами
        assertEquals("Ketchup", ingredient.getName());
    }
    @Test
    public void testConstructorAndGettersPrice() {
        // Создаем стаб объекта Ingredient
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 50.0f);

        // Проверяем, что значения правильно сохраняются и возвращаются геттерами
        assertEquals(50.0f, ingredient.getPrice(), 0.01f);
    }
}
