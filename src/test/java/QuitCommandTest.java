import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class QuitCommandTest {
    private LineReader lineReader;

    @Test
    void shouldTellCustomerTheSessionEndedWhenTheCustomerSelectsQuit(){
        PrintStream printStream = mock(PrintStream.class);

       new QuitCommand(printStream).execute();

        verify(printStream).println(contains("ended"));
    }
}
