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
    private List<Account> accounts = new ArrayList<Account>();

    public Menu(List<String> options) {
        this.title = "Menu";
        this.options = options;
    }

    public Menu(String title, List<String> options) {
        this.title = title;
        this.options = options;
    }

    public static Menu MainMenu() {

        return new Menu("Menu Principal", 
            Arrays.asList("Sair", "Criar Conta", "Depositar na conta", 
                    "Sacar da conta", "Excluir conta", "Bloquear conta", "Desbloquear conta", 
                    "Numero de Contas Bloqueadas", "Tranferência entre contas", "Extrato da conta"));

    }

    public int getSelection() {
        int op = 0;

        while (op == 0) {
            System.out.println("\n" + title + "\n");
            int i = 1;
            for (String option : options) {
                System.out.println(i++ + " - " + option);
            }

            System.out.println("Informe a opcao desejada. ");
            Scanner s = new Scanner(System.in);
            String str = s.nextLine();

            try {
                op = Integer.parseInt(str);

                switch (op) {
                    case 1:
                        System.exit(0);
                        break;
                    case 2:
                        Scanner input = new Scanner(System.in);
                        System.out.println("Nome completo do titular: ");
                        String accountName = input.nextLine();
                        System.out.println("Tipo[Corrente, Poupanca]: ");
                        String accountType = input.nextLine();

                        int newAccountId = this.accounts.size();

                        Account accountCreated = new Account();
                        accountCreated.Create(accountName, accountType, newAccountId);

                        this.accounts.add(accountCreated);
                        System.out.println("\n" + "Conta adicionada com sucesso!");
                        System.out.println("Conta: ");
                        System.out.println("Id: " + accountCreated.ID);
                        System.out.println("Nome titular: " + accountCreated.CompleteName);
                        System.out.println("Bloqueada: " + accountCreated.Blocked);
                        System.out.println("Tipo: " + accountCreated.Type);
                        System.out.println("Saldo: " + accountCreated.Money);
                        break;
                    case 3:
                        Scanner inputId = new Scanner(System.in);
                        System.out.println("Digite o id da conta: ");
                        int accountId = inputId.nextInt();
                        System.out.println("Digite o valor do deposito(Ex: 100.10): ");
                        double depositValue = inputId.nextDouble();

                        for (Account account : this.accounts) {
                            if (account.ID == accountId) {
                                account.Deposit(depositValue);

                                System.out.println("\n" + "Deposito realizado com sucesso!");
                                System.out.println("Saldo atual da conta: " + account.Money);
                            }
                        }
                        break;
                    case 4:
                        Scanner inputIdToWithdraw = new Scanner(System.in);
                        System.out.println("Digite o id da conta: ");
                        int accountIdToWithDraw = inputIdToWithdraw.nextInt();
                        System.out.println("Digite o valor do saque(Ex: 100.10): ");
                        double withdrawValue = inputIdToWithdraw.nextDouble();

                        for (Account account : this.accounts) {
                            if (account.ID == accountIdToWithDraw) {
                                account.Withdraw(withdrawValue);

                                System.out.println("\n" + "Saque realizado com sucesso!");
                                System.out.println("Saldo atual da conta: " + account.Money);
                            }
                        }
                        break;

                    case 5:
                        inputId = new Scanner(System.in);
                        System.out.println("Digite o id da conta que deseja excluir: ");
                        accountId = inputId.nextInt();
                        for (Account account : this.accounts) {
                            int aux = account.ID;
                            if (account.ID == accountId) {
                                accounts.remove(account);
                                System.out.printf("\n" + "A conta de ID: %d foi excluida com sucesso!", aux);

                            }
                        }
                        break;

                    case 6:
                        inputId = new Scanner(System.in);
                        System.out.println("Digite o id da conta que deseja bloquear: ");
                        accountId = inputId.nextInt();
                        for (Account account : this.accounts) {
                            if (account.ID == accountId) {
                                account.SetAccountStatus(true);
                                System.out.printf("\n" + "A conta de ID: %d foi bloqueada com sucesso!", accountId);
                            } else {
                                System.out.println("Nenhuma conta encontrada para o id informado!");
                            }
                        }
                        break;

                    case 7:
                        Scanner entrada = new Scanner(System.in);
                        System.out.println("Digite o id da conta: ");
                        int contaId = entrada.nextInt();
                        Account conta = getAccountById(contaId);
                        if (conta != null) {
                            conta.SetAccountStatus(false);
                            System.out.printf("\n" + "A conta de ID: %d foi desbloqueada com sucesso!", conta.ID);
                        } else System.out.printf("\n" + "Conta nao encontrada!");
                        break;

                    case 8:
                        int aux = 0;
                        for (Account account : this.accounts) {
                            if (account.Blocked == true) {
                                aux++;
                            }
                        }
                        System.out.printf("\n" + "%d Contas estao bloqueadas!", aux);
                        break;
                    
                    case 9:
                        input = new Scanner(System.in);
                        System.out.println("Digite o id da conta que vai receber a transferencia: ");
                        accountId = input.nextInt();
                        System.out.println("Digite o valor da transferência(Ex: 100.10): ");
                        double transferValue = input.nextDouble();

                        for (Account account : this.accounts) {
                            if (account.ID == accountId) {
                                account.Transfer(account, transferValue);

                                System.out.println("\n" + "Tranferência realizada com sucesso!");
                                System.out.println("Saldo atual da conta: " + account.Money);
                            }
                        }
                    break;
                    case 10:
                        input = new Scanner(System.in);
                        System.out.println("Digite o id da conta : ");
                        accountId = input.nextInt();
                        
                        for (Account account : this.accounts) 
                            if (account.ID == accountId) 
                                account.Statement();
                    break;
                    default:
                        System.out.println("Opcao errada!");
                }
            } catch (NumberFormatException e) {
                op = 0;
            }

            if (op >= i) {
                System.out.println("Opcao errada!");
                System.console().readLine();
                ClearConsole();
                op = 0;
            }

        }
        return op;
    }

    private static void ClearConsole() {
        System.out.print("\033\143");
    }

    private Account getAccountById(int id) {
        for (Account account : this.accounts) {
            if (account.ID == id) {
                return account;
            }
        }
        return null;
    }

    public static void WritePopUp(String message) {
        ClearConsole();
        System.out.println(message);
        System.console().readLine();
        ClearConsole();
    }
}