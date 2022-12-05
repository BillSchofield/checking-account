import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;

import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountManagmentTests {
    
    private PrintStream printStream;
    private LineReader reader;
    private AccountManagement accountManagement;

    @BeforeEach
    void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(LineReader.class);
        System.setOut(printStream);
        
        accountManagement = new AccountManagement(printStream, reader);
    }

    @Test
    public void testAccountIsCreatedWhenUserNameIsGiven() {
        when(reader.readLine()).thenReturn("Bill");

        accountManagement.submit();
        
        assertEquals("Bill", accountManagement.getName());
    }

    @Test
    public void canCreateNewAccountWithBalanceAndName() {
        Account account = new Account(0, "Bill");

        assertEquals("Bill", account.getName());
        assertEquals(0.00, account.getBalance());
    }

    @Test
    public void enteringAccountHolderNameReturnsAccount() {
        when(reader.readLine()).thenReturn("Bill");

        accountManagement.submit();
        Account account = accountManagement.getIndividualAccount("Bill");

        assertEquals("Bill", account.getName());
        assertEquals(0.00, account.getBalance());
    }

    @Test
    public void menuOptionSelectCreateAccountStartsCreateAccountProcess() {
        accountManagement.menu();
        
        verify(printStream).println(contains("Create Account"));
        verify(printStream).println(contains("Quit"));
    }


}
