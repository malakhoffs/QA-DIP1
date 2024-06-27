import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;import org.junit.runner.RunWith;
import org.mockito.Mock;import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;import praktikum.Burger;
import praktikum.Ingredient;import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.Constants.DELTA;


@RunWith(MockitoJUnitRunner.class)public class BurgerTest {


    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1, ingredient2, ingredient3;

    Burger burger = new Burger();
    IngredientType ingredientType;

    @Before
    public void ingredientSetUp (){
        when(bun.getPrice()).thenReturn(100F);
        when(bun.getName()).thenReturn("black bun");
        when(ingredient1.getPrice()).thenReturn(100.00F);
        when(ingredient2.getPrice()).thenReturn(200.00F);
        when(ingredient3.getPrice()).thenReturn(300.00F);
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient2.getName()).thenReturn("sour cream");
        when(ingredient3.getName()).thenReturn("sausage");
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient3.getType()).thenReturn(IngredientType.FILLING);
    }


    @Test
    public void setBunNameTest(){
        burger.setBuns(bun);
        assertEquals("bun names should be equals", bun.getName(), burger.bun.getName());
    }

    @Test
    public void setBunPriceTest(){
        burger.setBuns(bun);
        assertEquals("bun prices should be equals", bun.getPrice(), burger.bun.getPrice(), DELTA);
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals("ingredients amount should be changeable", 3, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(3, burger.ingredients.size());
        burger.removeIngredient(1);
        assertEquals(2, burger.ingredients.size());
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        burger.removeIngredient(0);
        assertEquals("ingredients should be removable", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(0,2);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals("ingredients should be movable", ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        Assert.assertEquals("prices should exact", 800.00F,burger.getPrice(), DELTA);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        String expectedReceipt = "(==== black bun ====)\r\n= sauce hot sauce =\r\n= sauce sour cream =\r\n= filling sausage =\r\n(==== black bun ====)\r\n\r\nPrice: 800,000000\r\n";
        assertEquals("receipt string should be exact", expectedReceipt, burger.getReceipt());
    }
}