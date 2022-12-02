import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		AccountManagement accountManagement = new AccountManagement(System.out);
		System.out.println("Please enter the new account holder's name");
		Scanner scanner = new Scanner(System.in);
		String accountHolderName = scanner.nextLine();
		CheckingAccount newAccount = accountManagement.submit(accountHolderName);
		System.out.println("Current balance is $" + newAccount.balance());

	}
}
