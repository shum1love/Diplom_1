package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.*;

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
        Mockito.when(bunMock.getPrice()).thenReturn(10.0f);
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

   }
}