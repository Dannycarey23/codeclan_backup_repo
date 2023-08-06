import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    Student student;

    @Before
    public void before(){
        student = new Student("Debi", "G6");
    }


    @Test
    public void hasName(){
        assertEquals("Debi", student.getName());
    }

    @Test
    public void hasCohort(){
        assertEquals("G6", student.getCohort());
    }

    @Test
    public void canChangeName(){
        student.setName("Rufin");
        assertEquals("Rufin", student.getName());
    }
    @Test
    public void canChangeCohort(){
        student.setCohort("G8");
        assertEquals("G8", student.getCohort());
    }

    @Test
    public void canTalk(){
        assertEquals("I love learning Java", student.talk("Java"));
    }
}