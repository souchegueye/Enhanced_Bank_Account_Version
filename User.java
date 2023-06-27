package test3;

//User class
class User implements Displayable {
	private String id;
	private String password;
	private String name;
	private String address;
	private double accountBalance;
	private String accountNumber;
	private String email;
	private String phoneNumber;

	public User(String id, String password, String name, String address, double accountBalance, String accountNumber,
			String email, String phoneNumber) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.accountBalance = accountBalance;
		this.accountNumber = accountNumber;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean authenticate(String enteredId, String enteredPassword) {
		return id.equals(enteredId) && password.equals(enteredPassword);
	}

	@Override
	public void displayPersonalInformation() {
		System.out.println("User's Personal Information:");
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Email: " + email);
		System.out.println("Phone Number: " + phoneNumber);
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public String getName() {
		return name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}