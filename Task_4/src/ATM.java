public class ATM {
    Account account = new Account();

    public double getBalance(){
        return account.getBalance();
    }

    public void deposit(double amount){
        double balance = account.getBalance();
        balance += amount;
        account.setBalance(balance);
    }

    public void withdraw(double amount){
        double balance = account.getBalance();
        balance -= amount;
        account.setBalance(balance);
    }

    public boolean isValidWithdrawal(double withdraw){
        double balance = account.getBalance();
        if (balance-withdraw < 0) {
            return false;
        } else {
            return true;
        }
    }
}
