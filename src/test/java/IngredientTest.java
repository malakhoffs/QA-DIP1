import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static praktikum.Constants.DELTA;


@RunWith(Parameterized.class)
public class IngredientTest {

    IngredientType ingredientType;
    String name;
    float price;

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300}
        };
    }

    public IngredientTest(IngredientType type, String name, float price) {
        this.ingredientType = type;
        this.name = name;
        this.price = price;
    }

    @Test
    public void checkIngredientType() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals("ingredient types should be equals to their types", ingredientType, ingredient.getType());
    }

    @Test
    public void checkIngredientName() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals("ingredient names are should be equals", name, ingredient.getName());
    }

    @Test
    public void checkIngredientPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals("ingredient prices are should be equals", price, ingredient.getPrice(), DELTA);
    }
}
