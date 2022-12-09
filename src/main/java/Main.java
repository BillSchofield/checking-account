import java.io.PrintStream;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		PrintStream printStream = new PrintStream(System.out);
		LineReader lineReader = new LineReader(System.in);
		AccountManager accountManager = new AccountManager(printStream,lineReader,new HashMap<>());

		HashMap<String, Command> commandMap = new HashMap<>();
		commandMap.put("1", new SubmitApplicationCommand(accountManager));
		commandMap.put("2", new ViewBalanceCommand(accountManager, printStream,lineReader));
		commandMap.put("3", new DepositCommand(accountManager, printStream, lineReader));
		commandMap.put("4", new WithdrawCommand(accountManager, printStream, lineReader));
		commandMap.put("5", new QuitCommand(printStream));

		BankMenu bankMenu = new BankMenu(accountManager, printStream,lineReader, commandMap);
		bankMenu.selection();
	}
}
