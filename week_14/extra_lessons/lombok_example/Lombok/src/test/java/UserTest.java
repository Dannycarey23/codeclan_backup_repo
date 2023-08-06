import WithLombok.EricsUser;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserTest {
    //User exampleUser;
    EricsUser exampleUser;
    @Before
    public void before(){

//        exampleUser = new User.builder("Spongebob","Roundpants")
//                .address("2 PineApple grove, Bikini bottom, Nuclear Corner")
//                .age(42)
//                .build();
        exampleUser = EricsUser
                .builder()
                .firstName("Spongebob")
                .lastName("Roundpants")
                .address("2 PineApple grove, Bikini bottom, Nuclear Corner")
                .age(42)
                .build();
        System.out.println(exampleUser);
    }

    @Test
    public void checkHasFirstName(){
        assertEquals("Spongebob",exampleUser.getFirstName());
    }

    @Test
    public void checkHasLastName(){
        assertEquals("Roundpants",exampleUser.getLastName());
    }

    @Test
    public void checkHasAge(){
        assertEquals(42,exampleUser.getAge());
    }

    @Test
    public void checkHasAddress(){
        assertEquals("2 PineApple grove, Bikini bottom, Nuclear Corner",exampleUser.getAddress());
    }

    @Test
    public void checkPhoneIsNull(){
        assertNull(exampleUser.getPhone());
    }
}
