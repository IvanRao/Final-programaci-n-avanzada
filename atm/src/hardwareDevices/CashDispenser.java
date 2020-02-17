package hardwareDevices;

public class CashDispenser{
	private static final CashDispenser instance = new CashDispenser();
	private final double _totalCash = 10000;
	
	public CashDispenser() {
	}

	public static CashDispenser getInstance() {
		return instance;
	}
	
	public double getTotalCash() {
		return _totalCash;
	}
	
	public boolean withdrawCash(double balance, double ammount) {
		if (ammount <= balance) {
			balance -= ammount;
			return true;
		} else {
			return false;
		}
	}


}
