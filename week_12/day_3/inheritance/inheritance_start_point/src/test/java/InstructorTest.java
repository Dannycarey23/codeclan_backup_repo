import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructorTest {

    Instructor instructor;

    @Before
    public void before(){
        instructor = new Instructor("Colin", "G6");
    }


    @Test
    public void hasName(){
        assertEquals("Colin", instructor.getName());
    }

    @Test
    public void hasCohort(){
        assertEquals("G6", instructor.getCohort());
    }

    @Test
    public void canChangeName(){
        instructor.setName("Louise");
        assertEquals("Louise", instructor.getName());
    }
    @Test
    public void canChangeCohort(){
        instructor.setCohort("G8");
        assertEquals("G8", instructor.getCohort());
    }

    @Test
    public void canTalk(){
        assertEquals("I love Java", instructor.talk("Java"));
    }


}