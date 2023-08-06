import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketTest {
   private Ticket ticket;

   @Before
   public void before() {
      ticket = new Ticket("AB12345", "QWERTY123456", "26/01/2020");
   }

   @Test
   public void canGetBookingRef() {
      assertEquals("AB12345", ticket.getBookingRef());
   }

   @Test
   public void canGetDate() {
      assertEquals("26/01/2020", ticket.getDate());
   }

   @Test
   public void canScanTicket() {
      assertEquals("QWERTY123456", ticket.scan());
   }
}
