import java.io.Console;

public class Account {
    public enum AccountType {Corrente, Poupança}
    public static int AccountIDCounter = 0;

    public int ID;
    public double Money;
    public String CompleteName;
    public AccountType Type;
    public Boolean Blocked;

    public Account
    (String name, AccountType type){
        
        this.CompleteName = name;
        this.Type = type;
        this.ID = ++AccountIDCounter;
    }

    public void Transfer(Account dest, double value)
    {
        value = Math.abs(value);

        if (Money >= value && dest.Deposit(value)){
            DecreaseMoney(value);
        }
    }

    public Boolean Deposit(double value){
        value = Math.abs(value);

        if (Blocked)
        {
            System.out.println("Conta bloqueada!");
            return false;
        }

        IncreaseMoney(value);
        return true;
    }

    public void SetAccountStatus(Boolean blocked){
        this.Blocked = blocked;
    }

    private void IncreaseMoney(double value){
        Money += value;
    }

    private void DecreaseMoney(double value){
        Money -= value;
    }
}
