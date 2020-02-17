package hardwareDevices;

public class DepositeSlot{
	private static final DepositeSlot instance = new DepositeSlot();
	
	public DepositeSlot() {
	}

	public static DepositeSlot getInstance() {
		return instance;
	}
	
	public void depositCash(double balance, double amount) {
        balance += amount;
    }


}
