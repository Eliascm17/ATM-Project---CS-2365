/**
 * This is a program for the COSC 2365 Object Oriented Programming Course
 * Professor Shin
 * Fall 2018
 * 
 * Created by John Goodrich �2018
 */
package project;

import java.util.Scanner;

/**
 * @author John Goodrich
 * 
 * R # 11605245
 *
 *	deposit
 *	withdraw
 *	check balance
 *	transfer
 *	
 *	enter account number (3 attempts)
 *	verify pin (3 attempts)
 *	
 *	if succesfful, 
 *
 *	prompt for action (wd, cb, etc.)
 *	for withdraw, check balance for sufficient funds
 *	for transfer, check source and destination accounts
 *	bank staff can open or close account with PIN, SSN, and zero balance (system creates account number)
 *
 */

public class BankingSystemRuntime {

	/**
	 * @param args
	 */

	
	public static void main(String[] args) {

		Customer customer1 = new Customer("JOhn","Doe",1234);
		Customer customer2 = new Customer("Jane","Doe",1234);
		Customer customer3 = new Customer("Michael", "Bay", 4321);
		
		//Scanner input = new Scanner(System.in);
		
		menu();
			
	/*	
		int pin = input.nextInt();
		
		if(checkpin(customer1, customer.getpin()) == true) {
		
			menu();
		
		}*/

	}
	
	// SWITCH MENU - for menu options
	
	public void menu() {
		
		Scanner input = new Scanner(System.in);
		
		//prompt user for account number
		System.out.println("Please enter your Account Number: \n");
		int aNum = input.nextInt();
		
		//if user enters invalid account then continue to prompt unitl correct or terminates
		while(!(aNum.exists())) {
			System.out.println("Invalid Account Number \nPlease try again, or type 6 to Cancel \n");
			aNum = input.nextInt();
			if(aNum == 6)
				menu();
		}
		
		//prompt user for pin
		System.out.println("\n Enter your PIN: \n");
		int userPin = input.nextInt();
		
		System.out.println("Please enter your Account Number: \n");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		switch(choice) {
			
			// DEPOSIT
			
			case 1:
			
				System.out.println("Deposit");
				deposit();
				break;
				
			// WITHDRAW
			
			case 2:
			
				System.out.println("Withdraw");
				withdraw();
				break;
			
			// VIEW BALANCE	
				
			case 3:
			
				System.out.println("View Balance");
				viewBalance();
				break;
			
			// TRANSFER FUNDS	
				
			case 4:
			
				System.out.println("Transfer Funds");
				transferFunds();
				break;
			
			// VIEW LAST DEPOSIT 
				
			case 5:
				
				System.out.println("View Last Deposit Amount");
				viewLastDeposit();
				break;
			
			// CANCEL	
				
			case 6:
				
				System.out.println("Cancel");
				System.exit(0);
				break;
		
		}
	}
	
	// CHECK SSN
	
	public boolean checkSsn(Account a) {
		
		if(a.getSsn() == system.getSsn()) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	// CHECK PIN
	
	public boolean checkPin(Account a) {
		
		if(a.getPin() == system.getPin())	
			return true;
		return false;
	}
	
	// CHECK ACCOUNT
	
	public boolean checkAn(Account a) {
		
		if(a.getAccount_number() == system.getAccount_number()) {
			
			return true;
		
		}
		
		return false;
		
	}
	
	// LOAD SYSTEM ACCOUNT
	// ignore this...only for testing
	
	public void loadSystemAccount() {
		
		system = new Account(45578, 3344, 7898067, 6000);
		
	}
	
	// CREATE ACCOUNT
	
	public void createAccount() {
		
		//selected = new Account();
		
	}
	
	// CHECK INPUT LENGTHS
	// checks the required lengths of inputs 
	
	public static boolean checkInput(int input, int length) {
		
		if(String.valueOf(input).length() == length) {
			
			// pin checks out
			return true;
			
		} 
		
		return false;
		
	}
}
