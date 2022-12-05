public class Main {
	public static void main(String[] args) {
		LineReader reader = new LineReader();
		AccountManagement accountManagement = new AccountManagement(System.out, reader );

		accountManagement.menu();

	}
}
