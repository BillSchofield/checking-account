import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class BankMenu {

    private final AccountManager accountManager;
    private final LineReader linereader;
    private final PrintStream printStream;
    private Map<String, Command> commandMap;

    public BankMenu(AccountManager accountManager, PrintStream printStream, LineReader lineReader, Map<String, Command> commandMap){
        this.accountManager = accountManager;
        this.printStream = printStream;
        this.linereader = lineReader;
        this.commandMap = commandMap;
    }

    public void selection() {
        String option = "0";
        while (!option.equals("5")) {

            printStream.println("""
                    Please choose an option:
                    1. CREATE an account
                    2. Check Account Balance
                    3. Deposit
                    4. Withdraw
                    5. Quit
                    """);

            option = linereader.readNextInput();

//            commandMap.put("1", new SubmitApplicationCommand(accountManager));
//            commandMap.put("2", new ViewBalanceCommand(accountManager, printStream, linereader));
//            commandMap.put("3", new DepositCommand(accountManager, printStream, linereader));
//            commandMap.put("4", new WithdrawCommand(accountManager, printStream, linereader));
//            commandMap.put("5", new QuitCommand(printStream));
            if (commandMap.containsKey(option)){
                commandMap.get(option).execute();
            }
        }

    }

}
