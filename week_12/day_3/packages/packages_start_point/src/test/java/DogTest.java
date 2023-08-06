import animal.Dog;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DogTest {

    Dog dog;

    @Before
    public void before(){
        dog = new Dog("Rex");
    }

    @Test
    public void hasName() {
        assertEquals("Rex", dog.getName());
    }

    @Test
    public void canBark() {
        assertEquals("Bark!", dog.bark());
    }
}
