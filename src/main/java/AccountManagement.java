import java.io.PrintStream;

public class AccountManagement {
	private final PrintStream printStream;
	private final LineReader lineReader;

	public AccountManagement(PrintStream printStream, LineReader lineReader) {
		this.printStream = printStream;
		this.lineReader = lineReader;
	}

	public void submit() {
		printStream.println("Please provide account holder name");
		String accountHolderName = lineReader.readLine();
		printStream.println(accountHolderName);
	}
}
