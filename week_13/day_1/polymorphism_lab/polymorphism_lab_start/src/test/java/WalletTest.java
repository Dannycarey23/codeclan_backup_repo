import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WalletTest {
    private Wallet wallet;
    private CreditCard creditCard;
    private DebitCard debitCard;
    private LoyaltyCard loyaltyCard;
    private Ticket ticket;

    @Before()
    public void before(){
        wallet = new Wallet("Isa's Wallet");
        creditCard = new CreditCard("1111222233334444", "12/23", 234);
        debitCard = new DebitCard("1111222233334444", 909090, 12345678, "12/23", 234);
        loyaltyCard = new LoyaltyCard("123456787890", "Harrid's Stores");
        ticket = new Ticket("AB12345", "QWERTY123456", "26/01/2020");
    }

    @Test
    public void canGetWalletName() {
        assertEquals("Isa's Wallet", wallet.getName());
    }

    @Test
    public void walletStartsEmpty() {
        assertEquals(0, wallet.getNumberOfItems());
    }

    @Test
    public void canAddCreditCardToWallet() {
        wallet.addItem(creditCard);
        assertEquals(1, wallet.getNumberOfItems());
    }

    @Test
    public void canAddDebitCardToWallet() {
        wallet.addItem(debitCard);
        assertEquals(1, wallet.getNumberOfItems());
    }

    @Test
    public void canAddLoyaltyCardToWallet() {
        wallet.addItem(loyaltyCard);
        assertEquals(1, wallet.getNumberOfItems());
    }

    @Test
    public void canAddTicketCardToWallet() {
        wallet.addItem(ticket);
        assertEquals(1, wallet.getNumberOfItems());
    }

    @Test
    public void canAddEverythingToWallet() {
        wallet.addItem(creditCard);
        wallet.addItem(debitCard);
        wallet.addItem(loyaltyCard);
        wallet.addItem(ticket);
        assertEquals(4, wallet.getNumberOfItems());
    }
}
