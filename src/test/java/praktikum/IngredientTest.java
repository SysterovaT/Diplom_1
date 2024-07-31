package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final Ingredient ingredient;
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    public IngredientTest( IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][] {
                { IngredientType.SAUCE, "Сырный соус", 50f},
                { IngredientType.SAUCE, "Чесночный соус", 40f},
                { IngredientType.FILLING, "Бекон", 5f},
                { IngredientType.FILLING, "Лук", 1f},
        };

    }
    @Test
    public void getPrice() {
        assertEquals(ingredient.getPrice(), this.ingredientPrice, 0);
    }

    @Test
    public void getName() {
        assertEquals(ingredient.getName(), this.ingredientName);
    }

    @Test
    public void getType() {
        assertEquals(ingredient.getType(), this.ingredientType);
    }
}