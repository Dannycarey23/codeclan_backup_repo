import machine.components.Code;
import machine.components.Drawer;
import org.junit.Before;
import org.junit.Test;
import products.Sweet;

import static org.junit.Assert.assertEquals;

public class DrawerTest {

    Drawer drawer;
    Sweet sweet;

    @Before
    public void before(){
        drawer = new Drawer(Code.A1, 0.65);
        sweet = new Sweet("Mars");
    }

    @Test
    public void hasCode() {
        assertEquals(Code.A1, drawer.getCode());
    }

    @Test
    public void hasPrice() {
        assertEquals(0.65, drawer.getPrice(), 0.01);
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, drawer.itemCount());
    }

    @Test
    public void canAddItem(){
        drawer.addItem(sweet);
        assertEquals(1, drawer.itemCount());
    }

    @Test
    public void canVendItem(){
        drawer.addItem(sweet);
        Sweet sweet = (Sweet)drawer.vendProduct();
        assertEquals("Mars", sweet.getName());
    }

}
