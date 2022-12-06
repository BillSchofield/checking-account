package example;

import java.io.InputStream;
import java.util.Scanner;

public class LineReader {
	private final Scanner scanner;

	public LineReader(InputStream inputStream) {
		scanner = new Scanner(inputStream);
	}

	public String readLine() {
		return scanner.nextLine();
	}
}
