
public class Account {

    private double balance;
    private String name;
    
    public Account(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

}
