import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void setUp() {
        bedroom = new Bedroom(1, RoomType.DOUBLE, 55.00);
        guest1 = new Guest("Sandy");
        guest2 = new Guest("Juan");
        guest3 = new Guest("John");
    }

    @Test
    public void hasRoomNo() {
        assertEquals(1, bedroom.getRoomNumber());
    }

    @Test
    public void hasCapacity() {
        assertEquals(2, bedroom.getCapacity());
    }

    @Test
    public void hasType() {
        assertEquals(RoomType.DOUBLE, bedroom.getType());
    }

    @Test
    public void hasNightlyRate() {
        assertEquals(55.00, bedroom.getNightlyRate(), 0.01);
    }

    @Test
    public void guestListSizeStartsAt0() {
        assertEquals(0, bedroom.guestListSize());
    }

    @Test
    public void canCheckInGuest_underCapacity() {
        bedroom.checkInGuest(guest1);
        assertEquals(1, bedroom.guestListSize());
    }

    @Test
    public void canCheckInGuest_atCapacity() {
        bedroom.checkInGuest(guest1);
        bedroom.checkInGuest(guest2);
        assertEquals(2, bedroom.guestListSize());
    }

    @Test
    public void cantCheckInGuest_overCapacity() {
        bedroom.checkInGuest(guest1);
        bedroom.checkInGuest(guest2);
        bedroom.checkInGuest(guest3);
        assertEquals(2, bedroom.guestListSize());
    }

    @Test
    public void canCheckOutGuests() {
        bedroom.checkInGuest(guest1);
        bedroom.checkInGuest(guest2);
        bedroom.checkOutGuests();
        assertEquals(0, bedroom.guestListSize());
    }

    @Test
    public void checkIsVacant_true() {
        assertEquals(true, bedroom.isVacant());
    }

    @Test
    public void checkIsVacant_false() {
        bedroom.checkInGuest(guest1);
        assertEquals(false, bedroom.isVacant());
    }

    @Test
    public void checkBedroomHasSize(){
        //Allows for equals checking to 0.001 decimal point precision (change as required for higher precision)
        assertEquals(30
                ,Bedroom.calculateRoomSize(5,6),0.001);
    }
}
