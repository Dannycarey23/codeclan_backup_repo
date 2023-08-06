import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    DiningRoom diningRoom;
    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void setUp() {
        diningRoom = new DiningRoom(2, "Family Dining");
        guest1 = new Guest("Alex");
        guest2 = new Guest("Katie");
        guest3 = new Guest("Hannah");
    }

    @Test
    public void hasName() {
        assertEquals("Family Dining", diningRoom.getName());
    }

    @Test
    public void guestListSizeStartsAt0() {
        assertEquals(0, diningRoom.guestListSize());
    }

    @Test
    public void canCheckOutGuests() {
        diningRoom.checkInGuest(guest1);
        diningRoom.checkInGuest(guest2);
        diningRoom.checkOutGuests();
        assertEquals(0, diningRoom.guestListSize());
    }

    @Test
    public void checkDiningRoomHasSize(){
        //Allows for equals checking to 0.001 decimal point precision (change as required for higher precision)
        assertEquals(152.50
                ,Bedroom.calculateRoomSize(10,15.25),0.001);
    }
}
