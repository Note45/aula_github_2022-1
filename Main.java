import java.io.Console;
import java.nio.channels.ClosedSelectorException;
import java.util.Arrays;

public class Main {

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