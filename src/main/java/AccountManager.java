import java.io.PrintStream;
import java.util.HashMap;

public class AccountManager {

    private final PrintStream printStream;
    private final LineReader reader;
    private Integer accountNumber = 0;

    private HashMap<Integer, Account> accountHashMap;
    public AccountManager(PrintStream printStream, LineReader reader,HashMap<Integer,Account> accountsHashMap){
        this.printStream=printStream;
        this.reader=reader;
        this.accountHashMap=accountsHashMap;

    }

    public void submit(){

        printStream.println("Please enter a name for the account.");

        String accountName = reader.readNextInput();
        String accountNumberString = String.format("%08d", accountNumber);
        printStream.println("Account #"+accountNumberString +"for "+accountName+" was created.");

        printStream.println("Current balance is $0.00");

        accountHashMap.put(accountNumber, new Account(accountName, accountNumber, 0.00));
        accountNumber = accountNumber+1;
    }

    public void viewBalance(int accountNumber){
        Account accountToShow = accountHashMap.get(accountNumber);
        printStream.println("Balance $" + accountToShow.getBalance());

        //printStream.println("Balance $" + account.getBalance());
    }

    public void deposit(Integer accountNumber, Double amountToIncrease){
        Account accountToIncrease = accountHashMap.get(accountNumber);
        Double updatedBalance = accountToIncrease.getBalance()+ amountToIncrease;
        accountToIncrease.setBalance(updatedBalance);
        accountHashMap.put(accountNumber, accountToIncrease);
        printStream.println("Your new balance is $"+ accountToIncrease.getBalance());
    }

    public void withdraw(Integer accountNumber, Double amountToDecrease){
        Account accountToDecrease = accountHashMap.get(accountNumber);
        Double updatedBalance = accountToDecrease.getBalance()- amountToDecrease;
        if (accountToDecrease.getBalance() < amountToDecrease){
            printStream.println("Insufficient funds in your account");
        } else {
            accountToDecrease.setBalance(updatedBalance);
            accountHashMap.put(accountNumber, accountToDecrease);
            printStream.println("Your lower balance is $" + accountToDecrease.getBalance());
        }
    }

}
