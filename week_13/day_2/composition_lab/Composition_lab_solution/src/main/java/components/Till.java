package components;

public class Till {

    private double balance;

    public Till(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void addMoney(double amount){
        this.balance += amount;
    }

    public void removeMoney(double amount){
        this.balance -= amount;
    }
}
