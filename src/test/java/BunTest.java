import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static praktikum.Constants.DELTA;

@RunWith(Parameterized.class)
public class BunTest {


    private final String name;
    private final float price;

    @Parameterized.Parameters(name = "{index} Value = {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    public BunTest (String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Test
    public void checkBunName() {
        Bun burgerBun = new Bun(name, price);
        Assert.assertEquals("bun names are should be equals", name, burgerBun.getName());
    }
    @Test
    public void checkBunPrice() {
        Bun burgerBun = new Bun(name, price);
        Assert.assertEquals("bun prices are should be equals", price, burgerBun.getPrice(), DELTA);
    }
}
