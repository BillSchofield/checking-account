import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.HashMap;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.*;
public class BankMenuTest {

    private PrintStream printStream;
    private AccountManager accountManager;
    private LineReader lineReader;
    private BankMenu bankMenu;
    private HashMap<String, Command> commandMap;
    private QuitCommand QuitCommand;
    private ViewBalanceCommand ViewBalanceCommand;
    private SubmitApplicationCommand SubmitApplicationCommand;

    @BeforeEach
    void setUp(){
         accountManager = mock(AccountManager.class);
         printStream = mock(PrintStream.class);
         lineReader = mock(LineReader.class);
         QuitCommand = mock(QuitCommand.class);
         ViewBalanceCommand = mock(ViewBalanceCommand.class);
         SubmitApplicationCommand = mock(SubmitApplicationCommand.class);
        commandMap = new HashMap<>();
        bankMenu = new BankMenu(accountManager,printStream,lineReader, commandMap);
    }


    @Test
    void shouldExecuteCommandWhenOptionIsChosen() {
        Command command = mock(Command.class);
        String key = "key";
        commandMap.put(key, command);
        when(lineReader.readNextInput()).thenReturn(key).thenReturn("5");

        bankMenu.selection();

        verify(command).execute();

    }

    @Test
    void shouldPromptCustomerToSelectAnOptionWhenTheApplicationOpens(){
        when(lineReader.readNextInput()).thenReturn("").thenReturn("5");

        bankMenu.selection();

        verify(printStream,times(2)).println(contains("Please choose an option:"));
        verify(printStream,times(2)).println(contains("CREATE an account"));
        verify(printStream,times(2)).println(contains("Quit"));
    }

    @Test
    void shouldReadTheOptionWhenAnOptionWasChosen(){
        when(lineReader.readNextInput()).thenReturn("1").thenReturn("5");

        bankMenu.selection();

        verify(lineReader,times(2)).readNextInput();
    }
}
