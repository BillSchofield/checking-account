import java.io.PrintStream;

public class BankMenu {

    private final AccountManager accountManager;
    private final LineReader linereader;
    private PrintStream printStream;

    public BankMenu(AccountManager accountManager, PrintStream printStream, LineReader lineReader){
        this.accountManager = accountManager;
        this.printStream = printStream;
        this.linereader = lineReader;
    }

    public void selection(){
        printStream.println("""
                Please choose an option:
                1. CREATE an account
                """);
        accountManager.submit();
    }
}
