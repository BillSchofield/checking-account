import java.io.PrintStream;

public class AccountManagement {
	private final PrintStream printStream;

	public AccountManagement(PrintStream printStream) {
		this.printStream = printStream;
	}

	public CheckingAccount submit(String accountHolderName) {
		printStream.println("Account for " + accountHolderName + " was created");
		return new CheckingAccount();
	}
}
