public class Account {
    private String name;
    private int number;

    private Double balance;

    public Account(String name,int number,Double balance) {
        this.name=name;
        this.number=number;
        this.balance=balance;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }
    public void setNumber(int number){
        this.number=number;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
