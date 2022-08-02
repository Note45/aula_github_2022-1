import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Menu mainMenu = Menu.MainMenu();
		int op = -1;

		while (true){
			op = mainMenu.getSelection();
		}
	}	
}