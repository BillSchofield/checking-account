import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.*;

class AccountManagementTest {

	private PrintStream printStream;
	private LineReader reader;
	private AccountManagement accountManagement;

	@BeforeEach
	void setUp() {
		printStream = mock(PrintStream.class);
		InputStream inputStream = System.in;
		reader = mock(LineReader.class);
		accountManagement = new AccountManagement(printStream, reader);
	}

	@Test
	void shouldPromptForUsersNameWhenApplicationIsSubmitted() {
		accountManagement.submit();
		verify(printStream).println(contains("name"));
	}

	@Test
	void shouldSeeAccountHolderNameInConfirmationWhenApplicationIsSubmit() {
		String accountHolderName = "Bill";
		when(reader.readLine()).thenReturn(accountHolderName);
		accountManagement.submit();
		verify(printStream).println(contains(accountHolderName));
	}

	@Test
	void shouldSeeAccountBalanceWhenAccountIsCreated() {
		String accountHolderName = "Bill";
		when(reader.readLine()).thenReturn(accountHolderName);
		accountManagement.submit();
		verify(printStream).println(contains("Current balance is $0.00"));
	}

	@Test
	void shouldBeGivenChoiceToCreateAccountWhenMenuShows() {
		when(reader.readLine()).thenReturn("1");
		accountManagement.menu();
		verify(printStream).println(contains("choose an option"));
		verify(printStream).println(contains("Create an account"));
	}

	@Test
	void shouldBeGivenChoiceToQuitWhenMenuShows() {
		when(reader.readLine()).thenReturn("2");
		accountManagement.menu();
		verify(printStream).println(contains("choose an option"));
		verify(printStream).println(contains("1. Create an account"));
		verify(printStream).println(contains("2. Quit"));
		verify(printStream).println(contains("Quitting"));
	}

	@Test
	void shouldBeAbleToChooseNextOptionWhenQuitExitProgramOnly() {
		String accountHolderName = "Bill";
		when(reader.readLine()).thenReturn("1");
		when(reader.readLine()).thenReturn("bill");
		when(reader.readLine()).thenReturn("2");
		accountManagement.menu();
		verify(printStream).println(contains("choose an option"));
		verify(printStream).println(contains("1. Create an account"));
		verify(printStream).println(contains("2. Quit"));
		verify(printStream).println(contains("Quitting"));

	}

	@Test
	void shouldShouldCreateAccountNumberWhenNewAccountIsCreated() {
		accountManagement.submit();
		Account accountOne = new Account(1);
		assertEquals(1, accountOne.getId());
	}

}