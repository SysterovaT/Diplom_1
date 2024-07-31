package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private final Bun bun;

    private final String bunName;
    private final Float bunPrice;

    public BunTest(String bunName, Float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.bun = new Bun(bunName, bunPrice);
    }
    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][] {
                { "Французкая", 500f},
                { "Хрустящая", 600f},
                { "Для бургера", 300f},
        };
    }
    @Test
    public void getName() {

        Assert.assertEquals(bun.getName(), this.bunName);
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(bun.getPrice(), this.bunPrice, 0);
    }
}