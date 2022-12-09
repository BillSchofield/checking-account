import java.io.PrintStream;

public class QuitCommand implements Command {
    private PrintStream printStream;

    public QuitCommand(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.println("Your session has ended");
    }
}
