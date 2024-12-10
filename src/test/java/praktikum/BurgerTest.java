package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @InjectMocks
    private Burger burger;
    @Mock
    Bun bunMock;
    @Mock
    Ingredient mockedIngredient;
    @Test
    public void testSetBuns(){
        when(bunMock.getPrice()).thenReturn(10.0f);
        // Установка булочки через метод setBuns
        burger.setBuns(bunMock);
        // Проверяем, что булочка была успешно установлена
        assertEquals(bunMock, burger.bun);
        // Проверяем, что метод getPrice() булочки был вызван
        burger.getPrice();
        verify(bunMock).getPrice();
    }
    // Тестовый метод для проверки добавления ингредиента
    @Test

    public void testAddIngredient() {
        // Добавляем ингредиент
        burger.addIngredient(mockedIngredient);

        // Проверяем, что ингредиент был добавлен
        assertEquals(1, burger.ingredients.size());
        assertSame(mockedIngredient, burger.ingredients.get(0));
    }
    @Test
    public void testRemoveIngredient(){
        burger.addIngredient(mockedIngredient);
        burger.addIngredient(mockedIngredient);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());

   }
    @Test
    public void testMoveIngredient(){
        // Получаем список ингредиентов
        List<Ingredient> ingredients = TestDataGenerator.createDefaultIngredients();

        // Устанавливаем ингредиенты в объекте Burger
        burger.ingredients = ingredients;

        // Перемещаем ингредиент с индекса 0 на индекс 2
        burger.moveIngredient(0, 2);

        // Проверка нового порядка ингредиентов
        assertEquals(burger.ingredients.get(0).getName(), "Tomato");   // теперь на месте 0 Tomato
        assertEquals(burger.ingredients.get(1).getName(), "Meat");     // на месте 1 Meat
        assertEquals(burger.ingredients.get(2).getName(), "Cheese");   // на месте 2 Cheese
    }
    @Test
    public void testGetPrice(){
        // Создали второй мок игредиента
        Ingredient mockedIngredient2 = mock(Ingredient.class);
        // Назначаем цену за 1 булку
        when(bunMock.getPrice()).thenReturn(50f);
        // Назначаем цену за игредиенты
        when(mockedIngredient.getPrice()).thenReturn(20f);
        when(mockedIngredient2.getPrice()).thenReturn(30f);
        // Добавляем игредиенты
        burger.setBuns(bunMock);
        burger.addIngredient(mockedIngredient);
        burger.addIngredient(mockedIngredient2);
        // Сравниваем
        float rightPrice = 150f;
        assertThat(burger.getPrice(), is(rightPrice));

    }
    @Test
    public void testGetReceipt() {
        // Создаем моки для булочки и ингредиентов
        Bun mockBun = mock(Bun.class);
        when(mockBun.getName()).thenReturn("Classic Bun");
        when(mockBun.getPrice()).thenReturn(5.0f);

        Ingredient mockIngredient1 = mock(Ingredient.class);
        when(mockIngredient1.getName()).thenReturn("Lettuce");
        when(mockIngredient1.getPrice()).thenReturn(2.0f);
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);

        Ingredient mockIngredient2 = mock(Ingredient.class);
        when(mockIngredient2.getName()).thenReturn("Ketchup");
        when(mockIngredient2.getPrice()).thenReturn(1.0f);
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);

        // Создаем объект Burger и наполняем данными
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Ожидаемый результат
        String expectedReceipt = String.format(
                "(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n%n" +
                        "Price: %f%n",
                "Classic Bun",
                "filling", "Lettuce",
                "sauce", "Ketchup",
                "Classic Bun",
                burger.getPrice()
        );

        // Проверяем результат работы getReceipt
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}