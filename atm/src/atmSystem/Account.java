package atmSystem;

public class Account {
	protected int accountNumber;
    protected double balance;
    
    public Account(int _accountNumber, double _balance) {
        this.accountNumber = _accountNumber;
    	this.balance = _balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
	public int getAccountNumber() {
		return accountNumber;
	}
    
    @Override
    public String toString() {
        return "Checking account: current balance is " + balance;
    }
    	
}
