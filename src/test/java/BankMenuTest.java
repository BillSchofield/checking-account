import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.*;
public class BankMenuTest {



    @Test
    void shouldPromptCustomerToSelectAnOptionWhenTheApplicationOpens(){
        AccountManager accountManager = mock(AccountManager.class);
        PrintStream printStream = mock(PrintStream.class);
        LineReader lineReader = mock(LineReader.class);
        BankMenu bankMenu = new BankMenu(accountManager,printStream,lineReader);
        bankMenu.selection();

        verify(printStream).println(contains("Please choose an option:"));
        verify(printStream).println(contains("CREATE an account"));
    }
}
