import org.junit.Before;
import org.junit.Test;
import people.crew.CabinCrewMember;
import people.crew.CrewRank;

import static org.junit.Assert.assertEquals;

public class CabinCrewMemberTest {

    CabinCrewMember cabinCrewMember;

    @Before
    public void before(){
        cabinCrewMember = new CabinCrewMember("Fred", CrewRank.FLIGHTATTENDANT);
    }

    @Test
    public void canReturnName(){
        assertEquals("Fred", cabinCrewMember.getName());
    }

    @Test
    public void canSetName(){
        cabinCrewMember.setName("Frederique");
        assertEquals("Frederique", cabinCrewMember.getName());
    }

    @Test
    public void canGetRank(){
        assertEquals("Flight Attendant", cabinCrewMember.getRank());
    }

    @Test
    public void canGiveAnnouncement(){
        String announcement = cabinCrewMember.giveAnnouncement("Please fasten your seatbelts");
        assertEquals("Attention all passengers: Please fasten your seatbelts", announcement);
    }

    @Test
    public void canIndicateExits(){
        assertEquals("The exits are located here, here, and here.", cabinCrewMember.indicateExits());
    }

}
