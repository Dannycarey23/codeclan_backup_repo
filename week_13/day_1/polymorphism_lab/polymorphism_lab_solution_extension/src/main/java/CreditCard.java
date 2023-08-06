public class CreditCard extends PaymentCard {
    private int securityNumber;

    public CreditCard(String cardNumber, String expiryDate, int securityNumber) {
        super(cardNumber, expiryDate);
        this.securityNumber = securityNumber;
    }

    public int getSecurityNumber() {
        return this.securityNumber;
    }

    public String scan() {
        return "Payment Successful";
    }
}
