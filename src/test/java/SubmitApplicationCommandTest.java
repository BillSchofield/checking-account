import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SubmitApplicationCommandTest {
    @Test
    void shouldSubmitApplicationWhenExecuting() {
        AccountManager accountManager = mock(AccountManager.class);

        new SubmitApplicationCommand(accountManager).execute();

        verify(accountManager).submit();
    }
}