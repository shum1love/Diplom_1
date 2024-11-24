package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    public void testGetReceipt(){
        //
        when(bunMock.getName()).thenReturn("White");
        when(bunMock.getPrice()).thenReturn(100f);
        //
        List<Ingredient> ingredients = TestDataGenerator.createDefaultIngredients();
        //
        burger.setBuns(bunMock);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        //
        String rightReceipt =
                "(==== White ====)\n" +
                        "= sauce Cheese =\n" +
                        "= filling Tomato =\n" +
                        "= filling Meat =\n" +
                        "(==== White ====)\n\n" +
                        "Price: 800,000000\n";
        assertEquals(rightReceipt, burger.getReceipt());

    }
}