import java.io.Console;

public class Account {
    public int ID;
    public double Money;
    public String CompleteName;
    public String Type;
    public Boolean Blocked;

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
        return true;
    }

    public void SetAccountStatus(Boolean blocked)
    {
        this.Blocked = blocked;
    }

    private void IncreaseMoney(double value)
    {
        Money += value;
    }

    private void DecreaseMoney(double value)
    {
        Money -= value;
    }
}
