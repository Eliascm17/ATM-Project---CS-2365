package project;

public class Account {
	//class attributes
	private int account_number, pin, ssn; // 5 digits, 4 digits, 9 digits;
	private double balance;
	
	Account(int accNumber, int pinEntered) {
		account_number = accNumber;
		pin = pinEntered;
	}
	
	//account constructor
	Account(int accNumber, int pinEntered, int userSSN, double bal) {
		account_number = accNumber;
		pin = pinEntered;
		ssn = userSSN;
		balance = bal;
	}

	//mutator and accessor methods
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

//deposit funds to account
public deposit(int num){
	this.balance += num;
}

//withdraw funds from account
public withdraw(){
	if(this.type.equals("savings")) {
		System.out.println("Cannot withdraw from a Savings Account. \nSelect another option\n");
		secondMenuOption();
	}
	else {
		System.out.println("Enter amount to withdraw: \n");
		amount = input.nextInt();
		
		if(this.balance > amount)
			this.balance -= amaount;
		else {
			System.out.println("** Insufficient funds ** \nSelect another option\n");
			secondMenuOption();
		}
	}
}

//query account
public viewBalance(){
	
}

//transfer funds to another account
public deposit(int num){
	
}

//view last deposit amount
public deposit(int num){
	
}

//savings account class
public class savingsAccount extends Account{
	String type = "savings";
	
	savingsAccount(int accNumber, int pinEntered, int userSSN, double bal) {
		account_number = accNumber;
		pin = pinEntered;
		ssn = userSSN;
		balance = bal;
		type = "savings";
	}
}

//checking account class
public class checkingAccount extends Account{
	String type = "checking";
	
	checkingAccount(int accNumber, int pinEntered, int userSSN, double bal) {
		account_number = accNumber;
		pin = pinEntered;
		ssn = userSSN;
		balance = bal;
		type = "checking";
	}
}