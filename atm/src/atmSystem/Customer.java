package atmSystem;

public class Customer {
    private String firstName;
    private String lastName;
    protected int nip;
    protected Account account;

    public Customer(String _firstName, String _lastName, Account _account, int _nip) {
    	firstName = _firstName;
    	lastName = _lastName;
    	this.account = _account;
    	nip = _nip;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
	
	public String welcome() {
		return "Welcome " + firstName + lastName;
	}


}
