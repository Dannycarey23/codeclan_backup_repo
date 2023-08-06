import org.junit.Before;
import org.junit.Test;
import people.crew.CrewRank;
import people.crew.Pilot;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    Pilot pilot;

    @Before
    public void before(){
        pilot  = new Pilot("Leslie Nielsen", CrewRank.CAPTAIN, "Sh1RL3Y");
    }

    @Test
    public void canGetLicenseNumber(){
        assertEquals("Sh1RL3Y", pilot.getLicenseNumber());
    }

    @Test
    public void canFly(){
        assertEquals("*Flying Noises*", pilot.fly());
    }

}
