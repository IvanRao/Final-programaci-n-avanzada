package atmSystemTest;

import java.util.Scanner;

import atmSystem.Account;
import atmSystem.Bank;
import hardwareDevices.CashDispenser;
import hardwareDevices.DepositeSlot;

public class Test {
	public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        CashDispenser cashDispenser = CashDispenser.getInstance();
        DepositeSlot depositSlot = DepositeSlot.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean logged = false;
        
        createCustomers(bank);  
        
        do {
        	logged = loginCustomer(scanner, bank);
        } while(logged == false);
        Options(scanner, bank, cashDispenser, depositSlot);
    }
	
	private static boolean loginCustomer(Scanner scanner, Bank bank) {
		  
        System.out.println("Ingrese su número de cuenta");
        
        String accountNumber = scanner.nextLine();
        if(accountNumber.chars().allMatch( Character::isDigit )) {
        	if (bank.searchAccountNumber(Integer.parseInt(accountNumber))) {
            	System.out.println("Ingrese su número de identificación personal");
            	String nip = scanner.nextLine(); 
            	if(accountNumber.chars().allMatch( Character::isDigit )) {
	            	if (bank.validateNip(Integer.parseInt(nip))) {
	            		return true;
	    			}
            	}
        	}        
		}
        return false;
	}
	
	private static void Options(Scanner scanner, Bank bank, CashDispenser cashDispenser, DepositeSlot depositeSlot) {
		System.out.println("Ingrese la operación que desea realizar: \n1-Consulta de saldo \n2-Extracción \n3-Deposito \n4-Salir");
		String option = scanner.nextLine();  
		
		switch (option) {
		case "1": // Consulta de saldo
			System.out.println(bank.getBalance());
			break;
		case "2": // Extracción de dinero
//			cashDispenser(bank.);
			break;
		case "3": // Deposito
//			depositCash(balance, amount);
			break;
		case "4": // Salir
			break;
		default:
			break;
		}
	}
	
	private static void depositCash(double balance, double ammout) {
		
	}
	
	private static void createCustomers(Bank bank) {
		bank.addCustomer("Juan", "Rodriguez", new Account(1,500), 1234);
		bank.addCustomer("Ignacio", "Calvo", new Account(2,2500), 6789);
		bank.addCustomer("Manuel", "Iñiguez", new Account(3,500), 4321);
		bank.addCustomer("Pedro", "Lopez", new Account(4,500), 9876);
		bank.addCustomer("Alan", "Sanchez", new Account(5,500), 5217);
	}
}
