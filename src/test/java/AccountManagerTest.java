import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.HashMap;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.*;

class AccountManagerTest {

	private PrintStream printStream;
	private AccountManager accountManager ;
	private LineReader reader;
	private Account account;

	@BeforeEach
	void setUp(){
		account = mock(Account.class);
		reader = mock(LineReader.class);
		printStream = mock(PrintStream.class);
		accountManager = new AccountManager(printStream,reader, new HashMap<>());
		when(reader.readNextInput()).thenReturn("Kane");
		accountManager.submit();
	}


	@Test
	void shouldPromptForCustomersNameWhenTheySubmitForAccount(){



		verify(printStream).println(contains("Please enter a name for the account."));
	}
	@Test
	void shouldReturnTheCustomersNameWhenTheyEnterTheirName(){

		when(reader.readNextInput()).thenReturn("Bill");

		accountManager.submit();

		verify(printStream).println(contains("Bill"));
	}

	@Test
	void shouldReturnTheCustomersBalanceWhenTheAccountIsCreated(){
		verify(printStream).println(contains("Current balance is $0.00"));
	}
	@Test
	void shouldReturnCustomersAccountNumberWhenAccountIsCreated(){

		verify(printStream).println(contains("#000"));
	}

	@Test
	void shouldShowAccountBalanceWhenAskedFor(){


		//when(reader.readNext()).thenReturn("1").thenReturn("3");
		accountManager.viewBalance(0);
		verify(printStream).println(contains("Balance"));
	}

	@Test
	void shouldIncreaseAccountBalanceWhenDepositMoney(){
		accountManager.deposit(0, 110.);
		accountManager.viewBalance(0);
		verify(printStream).println(contains("new"));
	}

	@Test
	void shouldDecreaseAccountBalanceWhenWithdrawalMoney(){
		accountManager.deposit(0, 200.);
		accountManager.withdraw(0, 110.);
		accountManager.viewBalance(0);
		verify(printStream).println(contains("lower"));
	}

	@Test
	void shouldStopFromOverDraftingWhenTryingToOverdraft(){
		accountManager.withdraw(0, 1000.);
		verify(printStream).println(contains("Insufficient"));
	}




}