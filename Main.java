import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	private static List<Account> _accounts = new ArrayList<Account>();

	public static void main(String[] args) {
		Menu mainMenu = Menu.MainMenu();
		int op = -1;
		while (op != 4){
			op = mainMenu.getSelection();
			Menu.WritePopUp(String.format("Opção %s selecionada", op));
		}

		System.out.println("Fechando aplicativo.");
	}

}