package project;

public class Account {
	private int account_number, pin, ssn; // 5 digits, 4 digits, 9 digits;
	private double balance;
	
	public Account() {
		
	}
	
	public Account(int account_number, int PIN, int SSN, double balance) {
		
		
		
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
