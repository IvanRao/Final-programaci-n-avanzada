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
		
		int accountNumber = Integer.parseInt(scanner.nextLine());
		if (bank.searchAccountNumber(accountNumber)) {
			System.out.println("Ingrese su número de identificación personal");
			int nip = Integer.parseInt(scanner.nextLine()); 
			if (bank.validateNip(nip)) {
				bank.welcomeCustomer();
				return true;
			}
		}        
		
		return false;
	}
	
	private static void Options(Scanner scanner, Bank bank, CashDispenser cashDispenser, DepositeSlot depositeSlot) {
		System.out.println("Ingrese la operación que desea realizar: \n1-Consulta de saldo \n2-Extracción \n3-Deposito \n4-Salir");
		String option = scanner.nextLine();  
		double amount = 0;

		switch (option) {
			case "1": // Consulta de saldo
				System.out.println(bank.getBalance());
				System.out.println("¿Desea realizar otra operación?: \n1-Si \n2-No");
				if (newOperation(scanner.nextLine())) {
					Options(scanner, bank, cashDispenser, depositeSlot);
				} else {
					System.exit(0);
				}
			case "2": // Extracción de dinero
				System.out.println("Ingrese la cantidad de dinero que va a retirar");
				amount = Double.parseDouble(scanner.nextLine());
				cashDispenser.withdrawCash(bank.getBalance(), amount);
				System.out.println("¿Desea realizar otra operación?: \n1-Si \n2-No");
				if (newOperation(scanner.nextLine())) {
					Options(scanner, bank, cashDispenser, depositeSlot);
				} else {
					System.exit(0);
				}
			case "3": // Deposito
				System.out.println("Ingrese la cantidad de dinero que va a depositar");
				amount = Double.parseDouble(scanner.nextLine());
				depositeSlot.depositCash(bank.getBalance(), amount);
				System.out.println("¿Desea realizar otra operación?: \n1-Si \n2-No");
				if (newOperation(scanner.nextLine())) {
					Options(scanner, bank, cashDispenser, depositeSlot);
				} else {
					System.exit(0);
				}
			case "4": // Salir
				System.exit(0);
			default:
				System.exit(0);
		}
	}

	public static boolean newOperation(String option) {
		switch (option) {
			case "1":
				return true;		
			default:
				return false;
		}
	}

	private static void createCustomers(Bank bank) {
		bank.addCustomer("Juan", "Rodriguez", new Account(1,2900), 1234);
		bank.addCustomer("Ignacio", "Calvo", new Account(2,2500), 6789);
		bank.addCustomer("Manuel", "Iñiguez", new Account(3,1800), 4321);
		bank.addCustomer("Pedro", "Lopez", new Account(4,12400), 9876);
		bank.addCustomer("Alan", "Sanchez", new Account(5,35500), 5217);
	}
}
