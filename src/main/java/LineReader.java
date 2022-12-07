
import java.io.InputStream;
import java.util.Scanner;

public class LineReader {

    private final Scanner scanner;

    public LineReader(InputStream inputStream) {
        scanner= new Scanner(inputStream);
    }

    public String readNext(){
        return scanner.nextLine();
    }
}
