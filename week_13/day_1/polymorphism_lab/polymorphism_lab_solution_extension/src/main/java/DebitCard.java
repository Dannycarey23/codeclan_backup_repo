public class DebitCard extends PaymentCard {
    private int sortCode;
    private int accountNumber;
    private int securityNumber;

    public DebitCard(String cardNumber, int sortCode, int accountNumber, String expiryDate, int securityNumber) {
        super(cardNumber, expiryDate);
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.securityNumber = securityNumber;
    }

    public int getSortCode() {
        return this.sortCode;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public int getSecurityNumber() {
        return this.securityNumber;
    }

    public String scan() {
        return "Payment Complete";
    }
}
