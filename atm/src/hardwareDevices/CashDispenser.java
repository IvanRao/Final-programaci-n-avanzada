package hardwareDevices;


public class CashDispenser{
	private double totalCash = 10000;

	public CashDispenser() {
	};

	public boolean withdrawCash(double balance, double ammount) {
		if (ammount <= balance && ammount <= totalCash) {
			totalCash -= ammount;
			return true;
		} else {
			return false;
		}
	}
}
