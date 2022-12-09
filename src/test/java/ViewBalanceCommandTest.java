import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ViewBalanceCommandTest {
    @Test
    void shouldBeAbleToDisplayAccountBalance(){

        bankMenu.selection();

        verify(ViewBalanceCommand).execute();

    }
}
