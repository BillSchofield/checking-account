import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}