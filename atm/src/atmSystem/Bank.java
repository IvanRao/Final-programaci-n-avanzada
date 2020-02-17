package atmSystem;

public class Bank {
	private static final Bank instance = new Bank();
	
	private Customer[] customers;
	private int numberOfCustomers;
	private Customer customer;
	
	private Bank() {
        customers = new Customer[5];
        numberOfCustomers = 0;
    }
    
    public static Bank getInstance() {
        return instance;
    }

    public void addCustomer(String firstName, String lastName, Account account, int nip) {
        int i = numberOfCustomers++;
        customers[i] = new Customer(firstName, lastName, account, nip);
    }

	public boolean searchAccountNumber(Integer accountNumber) {
		for (Customer customer : customers) {
			if (customer.account.accountNumber == accountNumber) {
				this.customer = customer;
				return true;
			} 
		}
		return false;
	}

	public boolean validateNip(int nip) {	
		int customerNip = this.customer.nip;
		if (customerNip == nip) {
			return true; 
		}	
		return false;
	}

	public double getBalance() {
		return this.customer.account.balance;
	}
    
    

}
