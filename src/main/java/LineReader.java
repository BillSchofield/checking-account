import java.util.Scanner;

public class LineReader {
    private static Scanner scanner;

    public LineReader() {
        scanner = new Scanner(System.in);
    }

    public String readLine(){
        return scanner.nextLine();
    }

}
