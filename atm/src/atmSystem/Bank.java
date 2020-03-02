package atmSystem;

import hardwareDevices.CashDispenser;
import hardwareDevices.DepositeSlot;

public class Bank {
	private static final Bank instance = new Bank();
	
	private Customer[] customers;
	private int numberOfCustomers;
	private Customer customer;
	private static DepositeSlot depositeSlot;
	private static CashDispenser cashDispenser;

	private Bank() {
		customers = new Customer[5];
		numberOfCustomers = 0;
	}

	public static Bank getInstance() {
		cashDispenser = new CashDispenser();
		depositeSlot = new DepositeSlot();
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

	public String getBalance() {
		return this.customer.account.getCustomerBalance();
	}
	
	public String welcomeCustomer() {
		return this.customer.welcome();
	}

	public boolean withdrawCash(double amount) {
		if (cashDispenser.withdrawCash(this.customer.account.balance, amount)){
			this.customer.account.balance -= amount;
			return true;
		}else{
			return false;
		}
	}

	public boolean depositCash(double amount) {
		if (depositeSlot.depositCash(this.customer.account.balance, amount)){
			this.customer.account.balance += amount;
			return true;
		}else{
			return false;
		}
	}

}
