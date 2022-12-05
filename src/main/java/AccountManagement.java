import java.io.PrintStream;
import java.util.HashMap;

public class AccountManagement {

    private String name;
    private HashMap<String, Account> accounts;
    private PrintStream printStream;
    private LineReader reader;

    public AccountManagement(PrintStream printStream, LineReader reader) {
        this.printStream = printStream;
        this.reader = reader;
        this.accounts = new HashMap<>();
    }

    public void submit() {
        this.printStream.println("Please enter account holder name:");
        this.name = reader.readLine();    

        Account account = new Account(0.0, name);
        accounts.put(name, account);
    }

    public String getName() {
        return this.name;
    }

    public Account getIndividualAccount(String accountHolder) {
        return accounts.get(accountHolder);
    }

    public void menu() {
        System.out.println("""

                1. Create Account
                2. Quit

                Option: """);

        int selection = reader.readInt();
        
    }

}
