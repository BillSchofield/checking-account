import java.io.PrintStream;

public class AccountManager {

    private final PrintStream printStream;
    private final LineReader reader;
    private String accountName;
    private float balance;
    public AccountManager(PrintStream printStream, LineReader reader){
        this.printStream=printStream;
        this.reader=reader;
    }
    public void submit(){
        printStream.println("Please enter a name for the account.");
        accountName = reader.readNext();
        printStream.println("Account for "+accountName+" was created.");

        printStream.println("Current balance is $0.00");
    }
}
