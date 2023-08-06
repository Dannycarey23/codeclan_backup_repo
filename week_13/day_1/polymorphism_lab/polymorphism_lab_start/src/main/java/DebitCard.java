public class DebitCard {
    private String cardNumber;
    private int sortCode;
    private int accountNumber;
    private String expiryDate;
    private int securityNumber;

    public DebitCard(String cardNumber, int sortCode, int accountNumber, String expiryDate, int securityNumber) {
        this.cardNumber = cardNumber;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.expiryDate = expiryDate;
        this.securityNumber = securityNumber;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public int getSortCode() {
        return this.sortCode;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public int getSecurityNumber() {
        return this.securityNumber;
    }

    public String scan() {
        return "Payment Complete";
    }
}
