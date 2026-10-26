import java.math.BigDecimal;

public class BankAccount {

    private final String accountNumber;
    private String name;
    private BigDecimal balance;

    BankAccount(String accountNumber, String name)
    {
        this.accountNumber = accountNumber;
        this.name = name;
    }

    public BigDecimal getBalance()
    {
        return this.balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(new BigDecimal(0)) < 0) {
            throw new IllegalArgumentException("Amount can't be less than 0");
        }

        this.balance.add(amount);
    }

    public  BigDecimal withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        this.balance.subtract(amount);

        return amount;
    }

    public Boolean transferTo(BankAccount target, BigDecimal amount)
    {
        if(balance.compareTo(amount) < 0)
        {
            throw new IllegalArgumentException("Insufficient balance");
        }

        withdraw(amount);
        target.deposit(amount);
        return true;
    }


}
