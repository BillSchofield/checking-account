import java.io.PrintStream;

public class WithdrawCommand implements Command {
    private AccountManager accountManager;
    private PrintStream printStream;
    private LineReader linereader;

    public WithdrawCommand(AccountManager accountManager, PrintStream printStream, LineReader linereader) {
        this.accountManager = accountManager;
        this.printStream = printStream;
        this.linereader = linereader;
    }

    @Override
    public void execute() {
        printStream.println("Enter account number");
        String accountToWithdraw = linereader.readNextInput();
        int accToDeduct = Integer.parseInt(accountToWithdraw);
        printStream.println("Enter withdrawal amount");
        String amountToWithdraw = linereader.readNextInput();
        Double amountToDeduct = Double.parseDouble(amountToWithdraw);
        accountManager.withdraw(accToDeduct, amountToDeduct);
    }
}
