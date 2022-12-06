import java.io.PrintStream;

public class AccountManagement {
	private final PrintStream printStream;
	private final LineReader lineReader;

	private double balance = 0;


	public AccountManagement(PrintStream printStream, LineReader lineReader) {
		this.printStream = printStream;
		this.lineReader = lineReader;
	}

	public void submit() {
		printStream.println("Please provide account holder name");
		String accountHolderName = lineReader.readLine();
		printStream.println("Account for " + accountHolderName + " was created.");
		printStream.println("Current balance is $" + balance + ".");
	}

	public void menu() {
		printStream.println("Please choose an option: ");
		printStream.println("- Create an account");
		printStream.println("Quit");
		String input = lineReader.readLine();
		if(input.equals("create")) {
			submit();
		} else if (input.equals("quit")) {
			System.exit(0);
		}

	}
}
