package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void values() {
        Assert.assertEquals(IngredientType.values().length , 2);
    }

    @Test
    public void valueOf() {
        Assert.assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
        Assert.assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}