import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		AccountManagement accountManagement = new AccountManagement(System.out, new LineReader(System.in));
		accountManagement.submit();
	}
}
