import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AccountManagementTest {
	@Test
	void shouldConfirmAccountCreationWhenApplicationSubmittedToAccountManagement() {
		PrintStream printStream = mock(PrintStream.class);
		AccountManagement accountManagement = new AccountManagement(printStream);
		String accountHolderName = "Account Holder Name";

		accountManagement.submit(accountHolderName);

		verify(printStream).println(contains(accountHolderName));
		verify(printStream).println(contains("created"));
	}

	@Test
	void shouldCreateAccountWithZeroBalanceWhenApplicationIsSubmitted() {
		PrintStream printStream = mock(PrintStream.class);
		AccountManagement accountManagement = new AccountManagement(printStream);

		CheckingAccount newAccount = accountManagement.submit("name");

		assertThat(newAccount.balance()).isEqualTo(0.0f);
	}


}