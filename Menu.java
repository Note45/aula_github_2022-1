import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String title;
	private List<String> options;

	public Menu(List<String> options) {
		this.title = "Menu";
		this.options = options;
	}

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public static Menu MainMenu() {
		return new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
	}

	public int getSelection() {
		int op = 0;
		while (op==0){
			System.out.println(title+"\n");
			int i=1;
			for (String option : options) {
				System.out.println(i++ + " - " + option);
			}

			System.out.println("Informe a opcao desejada. ");
			Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			try {
				op = Integer.parseInt(str);
			}
			catch (NumberFormatException e) {
				op =0;
			}

			ClearConsole();

			if (op>=i){
				System.out.println("Opcao errada!");
				System.console().readLine();
				ClearConsole();
				op=0;
			}

		}
		return op;
	}

	private static void ClearConsole(){
		System.out.print("\033\143");
	}

	public static void WritePopUp(String message){
		ClearConsole();
        System.out.println(message);
		System.console().readLine();
		ClearConsole();
	}
}