package project;

/**
 *	Although it isn't in the name, this is a checking account. It does not compilte interest. 
 * 
 * 
 */

public class Account {
	
	private int account_number, pin, ssn; // 5 digits, 4 digits, 9 digits;
	private double balance = 0;
	private boolean savings_account = false;
	
	public Account() {
		
	}
	
	public Account(int account_number, int PIN, int SSN, double balance) {
		
		if(String.valueOf(account_number).length() == 5) {
		
			setAccount_number(account_number);
		
		}
		
		if(String.valueOf(PIN).length() == 4) {
		
			setPin(PIN);
		
		}
		
		if(String.valueOf(SSN).length() == 5) {
		
			setSsn(SSN);
		
		}
		
		if(balance >= 0) {
		
			setBalance(balance);
		
		}
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
	
	public void setSavings() {
		
		this.savings_account = true;
		
	}
	
	public boolean isSavings() {
		
		return savings_account;
		
	}
	
}
