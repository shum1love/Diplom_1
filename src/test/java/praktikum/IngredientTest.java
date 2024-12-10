package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    // Тестирование конструктора и геттеров
    @Test
    public void testConstructorAndGetters() {
        // Создаем стаб объекта Ingredient
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 50.0f);

        // Проверяем, что значения правильно сохраняются и возвращаются геттерами
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("Ketchup", ingredient.getName());
        assertEquals(50.0f, ingredient.getPrice(), 0.01f);
    }
}
