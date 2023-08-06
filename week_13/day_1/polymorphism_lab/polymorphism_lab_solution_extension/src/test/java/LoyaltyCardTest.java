import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoyaltyCardTest {
    private LoyaltyCard loyaltyCard;

    @Before
    public void before() {
        loyaltyCard = new LoyaltyCard("123456787890", "Harrid's Stores");
    }

    @Test
    public void canGetVendor() {
        assertEquals("Harrid's Stores", loyaltyCard.getVendor());
    }

    @Test
    public void canScanCard() {
        assertEquals("123456787890", loyaltyCard.scan());
    }

}
