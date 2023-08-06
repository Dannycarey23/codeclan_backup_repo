public abstract class PaymentCard implements IScan {
    protected String cardNumber;
    protected String expiryDate;

    public PaymentCard(String cardNumber, String expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public abstract String scan();
}
