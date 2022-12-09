import java.io.PrintStream;

public class DepositCommand implements Command {
    private AccountManager accountManager;
    private PrintStream printStream;
    private LineReader linereader;

    public DepositCommand(AccountManager accountManager, PrintStream printStream, LineReader linereader) {
        this.accountManager = accountManager;
        this.printStream = printStream;
        this.linereader = linereader;
    }

    @Override
    public void execute() {
        printStream.println("Enter account number");
        String accountToDeposit = linereader.readNextInput();
        int accToDeposit = Integer.parseInt(accountToDeposit);
        printStream.println("Enter deposit amount");
        String amountToDeposit = linereader.readNextInput();
        Double amountToDep = Double.parseDouble(amountToDeposit);
        accountManager.deposit(accToDeposit, amountToDep);
    }
}
