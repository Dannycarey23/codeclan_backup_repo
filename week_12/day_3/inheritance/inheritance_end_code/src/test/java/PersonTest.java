import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    Person person;

    @Before
    public void setup(){
        person = new Person("Colin", "G8");
    }

    @Test
    public void hasName(){
        assertEquals("Colin", person.getName());
    }

    @Test
    public void hasCohort(){
        assertEquals("G8", person.getCohort());
    }

    @Test
    public void canChangeName(){
        person.setName("Louise");
        assertEquals("Louise", person.getName());
    }

    @Test
    public void canChangeCohort(){
        person.setCohort("G6");
        assertEquals("G6", person.getCohort());
    }

    @Test
    public void canTalk(){
        assertEquals("I love java!", person.talk("java"));
    }
}
