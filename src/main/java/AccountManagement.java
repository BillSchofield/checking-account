import java.io.PrintStream;
import java.text.DecimalFormat;

public class AccountManagement {
	private final PrintStream printStream;
	private final LineReader lineReader;

	private double balance = 0;


	public AccountManagement(PrintStream printStream, LineReader lineReader) {
		this.printStream = printStream;
		this.lineReader = lineReader;
	}

	public void submit() {
		DecimalFormat df = new DecimalFormat("0.00");
		printStream.println("Please provide account holder name");
		String accountHolderName = lineReader.readLine();
		printStream.println("Account for " + accountHolderName + " was created.");
		printStream.println("Current balance is $" + df.format(balance));
	}

	public void menu() {
		//Variable that is a bool to keep track if I am done
		boolean continueLoop = true;
		//Variable goes inside here ()
		while(continueLoop) {
			printStream.println("Please choose an option: ");
			printStream.println("1. Create an account");
			printStream.println("2. Quit");
			String input = lineReader.readLine();

			//Select 1 Create Account
			if (input.equals("1"))
			{
				submit();
			}

			//Select 2 QUIT APPLICATION
			else if (input.equals("2"))
			{
				printStream.println("Quitting");
				continueLoop = false;
			}

		}
	}
}
