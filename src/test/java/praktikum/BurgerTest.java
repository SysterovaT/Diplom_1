package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredientFirst;

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun , bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(burger.ingredients.get(0), ingredient);
        Assert.assertEquals(burger.ingredients.size(), 1);
        burger.addIngredient(ingredientFirst);
        Assert.assertEquals(burger.ingredients.get(1), ingredientFirst);
        Assert.assertEquals(burger.ingredients.size(), 2);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientFirst);

        burger.removeIngredient(0);
        Assert.assertEquals(burger.ingredients.size(), 1);

    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientFirst);

        burger.moveIngredient(1,0);

        Assert.assertEquals(burger.ingredients.get(0), ingredientFirst);
        Assert.assertEquals(burger.ingredients.get(1), ingredient);
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(500f);
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(300f);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientFirst);
        burger.setBuns(bun);
        float price = burger.getPrice();
        Assert.assertEquals(price, 1500f, 0);

    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Булка");
        Mockito.when(bun.getPrice()).thenReturn(500f);
        Mockito.when(ingredient.getName()).thenReturn("Соус");
        Mockito.when(ingredient.getPrice()).thenReturn(200f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientFirst.getName()).thenReturn("Котлета");
        Mockito.when(ingredientFirst.getPrice()).thenReturn(300f);
        Mockito.when(ingredientFirst.getType()).thenReturn(IngredientType.FILLING);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientFirst);
        burger.setBuns(bun);

        Assert.assertNotNull(burger.getReceipt());
    }
}