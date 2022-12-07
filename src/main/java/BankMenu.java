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

    public void selection() {
        String option = "";
        while (!option.equals("2")) {

            printStream.println("""
                    Please choose an option:
                    1. CREATE an account
                    2. Quit
                    """);

            option = linereader.readNext();

            switch (option) {
                case "1":
                    accountManager.submit();
                    break;
                case "2":
                    printStream.println("Your session has ended");
                    break;
                default:
                    break;
            }
        }
    }

}
