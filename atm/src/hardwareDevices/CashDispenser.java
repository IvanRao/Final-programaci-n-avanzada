package hardwareDevices;


public class CashDispenser{
	private double _totalCash = 10000;

	public CashDispenser() {
	};

	public double getTotalCash() {
		return _totalCash;
	}

	public boolean withdrawCash(double balance, double ammount) {
		if (ammount <= balance && ammount <= _totalCash) {
			_totalCash -= ammount;
			return true;
		} else {
			return false;
		}
	}
}
