import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.*;
public class BankMenuTest {

    private PrintStream printStream;
    private AccountManager accountManager;
    private LineReader lineReader;
    private BankMenu bankMenu;

    @BeforeEach
    void setUp(){
         accountManager = mock(AccountManager.class);
         printStream = mock(PrintStream.class);
         lineReader = mock(LineReader.class);
         bankMenu = new BankMenu(accountManager,printStream,lineReader);
    }


    @Test
    void shouldPromptCustomerToSelectAnOptionWhenTheApplicationOpens(){
        when(lineReader.readNext()).thenReturn("");

        bankMenu.selection();

        verify(printStream).println(contains("Please choose an option:"));
        verify(printStream).println(contains("CREATE an account"));
        verify(printStream).println(contains("Quit"));
    }

    @Test
    void shouldReadTheOptionWhenAnOptionWasChosen(){
        when(lineReader.readNext()).thenReturn("1");

        bankMenu.selection();

        verify(lineReader).readNext();
    }
    @Test
    void shouldCreateNewAccountSubmissionWhenCreateAccountOptionIsChosen(){
        when(lineReader.readNext()).thenReturn("1");

        bankMenu.selection();

        verify(accountManager).submit();
    }
    @Test
    void shouldTellCustomerTheSessionEndedWhenTheCustomerSelectsQuit(){
        when(lineReader.readNext()).thenReturn("2");

        bankMenu.selection();

        verify(printStream).println("Your session has ended");
    }
}
