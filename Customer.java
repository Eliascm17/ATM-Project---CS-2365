package project;

public class Customer {
	
	private String firstname, lastname;
	private int pin_number = 0;
	
	Customer(String first_name, String last_name, int pin) {
		
		this.setFirstname(first_name);
		this.setLastname(last_name);
		this.setPin_number(pin);
		
	}

	public String getFirstname() {
	
		return firstname;
	
	}

	public void setFirstname(String firstname) {
	
		this.firstname = firstname;
	
	}

	public String getLastname() {
	
		return lastname;
	
	}

	public void setLastname(String lastname) {
	
		this.lastname = lastname;
	
	}

	public int getPin_number() {
	
		return pin_number;
	
	}

	public void setPin_number(int pin_number) {
	
		this.pin_number = pin_number;
	
	}
}
