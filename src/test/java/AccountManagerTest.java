import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.*;

class AccountManagerTest {

	private PrintStream printStream;
	private AccountManager accountManager ;
	private LineReader reader;

	@BeforeEach
	void setUp(){
		reader = mock(LineReader.class);
		printStream = mock(PrintStream.class);
		accountManager =new AccountManager(printStream,reader);
	}


	@Test
	void shouldPromptForCustomersNameWhenTheySubmitForAccount(){

		accountManager.submit();

		verify(printStream).println(contains("Please enter a name for the account."));
	}
	@Test
	void shouldReturnTheCustomersNameWhenTheyEnterTheirName(){

		when(reader.readNext()).thenReturn("Bill");

		accountManager.submit();

		verify(printStream).println(contains("Account for Bill was created."));
	}

	@Test
	void shouldReturnTheCustomersBalanceWhenTheAccountIsCreated(){

		when(reader.readNext()).thenReturn("Bill");

		accountManager.submit();

		verify(printStream).println(contains("Current balance is $0.00"));
	}



}