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
    
    public String getCustomerBalance() {
        return "\nVerificando cuenta: su balance es de $" + balance;
    }
    	
}
