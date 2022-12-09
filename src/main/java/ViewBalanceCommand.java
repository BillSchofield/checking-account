import java.io.PrintStream;

public class ViewBalanceCommand implements Command {
    private final PrintStream printStream;
    private final LineReader linereader;
    private final AccountManager accountManager;

    public ViewBalanceCommand(AccountManager accountManager, PrintStream printStream, LineReader linereader) {
        this.accountManager = accountManager;
        this.printStream = printStream;
        this.linereader = linereader;
    }

    @Override
    public void execute() {
        printStream.println("Enter your account number");
        String accNum = linereader.readNextInput();
        int num = Integer.parseInt(accNum);
        accountManager.viewBalance(num);

    }
}
