import java.sql.Date;
public class Transaction {
    String transaction_type;
    int user_id,amount,balance;
    Date date;

    public Transaction(String transaction_type, int user_id, int amount, int balance, Date date) {
        this.transaction_type = transaction_type;
        this.user_id = user_id;
        this.amount = amount;
        this.balance = balance;
        this.date = date;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
