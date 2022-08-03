import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Account {
    public int ID;
    public double Money;
    public String CompleteName;
    public String Type;
    public Boolean Blocked;
    List<String> descriptions = new ArrayList<String>();

    public void Create(String name, String type, int id) {
        this.CompleteName = name;
        this.Blocked = false;
        this.Type = type;
        this.ID = id;
        this.Money = 0.0;
    }

    public void Transfer(Account dest, double value) {
        value = Math.abs(value);

        if (Money >= value && dest.Deposit(value)){
            DecreaseMoney(value);

            descriptions.add("\nTransferência realizada para:"
                          + "\nID: " + dest.ID
                          + "\nNome titular: " + dest.CompleteName
                          + "\nValor: R$" + value
                          + "\n");
        }
    }

    public Boolean Deposit(double value)
    {
        value = Math.abs(value);

        if (Blocked)
        {
            System.out.println("Conta bloqueada!");
            return false;
        }

        IncreaseMoney(value);
       
        descriptions.add("\nDeposito realizado"
                       + "\nValor: R$" + value
                       + "\n");

        return true;
    }

    public Boolean Withdraw(double value)
    {
        value = Math.abs(value);

        if (Blocked)
        {
            System.out.println("Conta bloqueada!");
            return false;
        }

        DecreaseMoney(value);

        descriptions.add("\nSaque realizado"
                       + "\nValor: R$" + value
                       + "\n");

        return true;
    }

    public void SetAccountStatus(Boolean blocked)
    {
        this.Blocked = blocked;

        String stt = "";
        if (blocked) stt = "bloqueada";
        else stt = "desbloqueada";

        descriptions.add("\nStatus atualizado"
                       + "\nConta " + stt
                       + "\n");
    }

    private void IncreaseMoney(double value)
    {
        Money += value;
    }

    private void DecreaseMoney(double value)
    {
        Money -= value;
    }

    public void Statement() {
        String stt = "";
        if (this.Blocked) stt = "bloqueada";
        else stt = "desbloqueada";

        System.out.println("\n------Extrato da conta------" 
                        + "\nID: " + this.ID
                        + "\nNome titular: " + this.CompleteName
                        + "\nStatus: " + stt
                        + "\nTipo: " + this.Type
                        + "\n");
        
        for (String description : descriptions) {
            System.out.print(description);
        }

        System.out.println("\nSaldo atual: " + this.Money
                         + "\n-----------------------------\n");
    }
}
