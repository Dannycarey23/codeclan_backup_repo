import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    Booking booking;
    Bedroom bedroom;

    @Before
    public void before() {
        bedroom = new Bedroom(1, RoomType.DOUBLE, 55.00);
        booking = new Booking(2, bedroom);
    }

    @Test
    public void hasNumberOfNights() {
        assertEquals(2, booking.getNumberOfNights());
    }

    @Test
    public void hasBedroom() {
        assertEquals(bedroom, booking.getBedroom());
    }

    @Test
    public void canGetTotalBill() {
        assertEquals(110.00, booking.getTotalBill(), 0.01);
    }
}
