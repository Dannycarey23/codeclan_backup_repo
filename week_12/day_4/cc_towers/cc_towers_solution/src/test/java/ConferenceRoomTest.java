import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void setUp() {
        conferenceRoom = new ConferenceRoom(2, "Conference Room 1");
        guest1 = new Guest("Zsolt");
        guest2 = new Guest("Louise");
        guest3 = new Guest("Sky");
    }

    @Test
    public void hasCapacity() {
        assertEquals(2, conferenceRoom.getCapacity());
    }

    @Test
    public void hasName() {
        assertEquals("Conference Room 1", conferenceRoom.getName());
    }

    @Test
    public void guestListSizeStartsAt0() {
        assertEquals(0, conferenceRoom.guestListSize());
    }

    @Test
    public void canCheckInGuest_underCapacity() {
        conferenceRoom.checkInGuest(guest1);
        assertEquals(1, conferenceRoom.guestListSize());
    }

    @Test
    public void canCheckInGuest_atCapacity() {
        conferenceRoom.checkInGuest(guest1);
        conferenceRoom.checkInGuest(guest2);
        assertEquals(2, conferenceRoom.guestListSize());
    }

    @Test
    public void cantCheckInGuest_overCapacity() {
        conferenceRoom.checkInGuest(guest1);
        conferenceRoom.checkInGuest(guest2);
        conferenceRoom.checkInGuest(guest3);
        assertEquals(2, conferenceRoom.guestListSize());
    }

    @Test
    public void canCheckOutGuests() {
        conferenceRoom.checkInGuest(guest1);
        conferenceRoom.checkInGuest(guest2);
        conferenceRoom.checkOutGuests();
        assertEquals(0, conferenceRoom.guestListSize());
    }

    @Test
    public void checkConferenceRoomHasSize(){
        //Allows for equals checking to 0.001 decimal point precision (change as required for higher precision)
        assertEquals(36
                ,ConferenceRoom.calculateRoomSize(6,6),0.001);
    }
}
