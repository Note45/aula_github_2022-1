import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	private static List<Account> _accounts = new ArrayList<Account>();

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes"));
		System.out.println(mainMenu.getSelection() + "foi selecionada");
		System.out.println("Fim");
	}

	public void removeAccount(Account account){
		_accounts.remove(account);
	}

}