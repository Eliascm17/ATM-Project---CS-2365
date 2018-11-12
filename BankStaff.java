package project;

import java.util.Random;
import java.util.Scanner;

/**
 *	BANK STAFF CLASS
 * 	
 * 	Extends systeminterface because it uses the same methods as the Customer class.
 * 	introduces new functions to the System interface class.
 * 
 */

public class BankStaff extends SystemInterface {
	
	BankStaff() {
		
		System.out.println("Welcome to bank staff portal");
	
	}
	
	// BANK STAFF MENU
	public void bankStaffMenu() {
		
		boolean flag = true; // determines whether program keeps running
		
		// SWITCH MENU
		while(flag == true) {
			
			System.out.println("MAIN MENU\n\nEnter :\n5 for creating account\n6 for closing account");
			
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			
			switch(choice) {
				
				// DEPOSIT
				
				case 0:
					
					deposit();
					break;
					
				// WITHDRAW
				
				case 1:
				
					withdraw();
					break;
				
				// VIEW BALANCE	
					
				case 2:
				
					viewBalance();
					break;
				
				// TRANSFER FUNDS	
					
				case 3:
				
					transfer();
					break;
				
				// VIEW LAST DEPOSIT 
					
				case 4:
					
					viewLastDeposit();
					break;
				
				// CANCEL	
					
				case 5:
					
					createAccount();
					break;
					
				case 6:
					
					closeAccount();
					break;
					
				case 8:
					System.out.println("Thank you for banking with us!");
					flag = false; // potential error
					break;
			
			}
			
			// PROMPTS USER FOR CONTINUING PROGRAM
			
			System.out.println("Continue banking? Y/N");
			Scanner continu = new Scanner(System.in);
			String response = continu.nextLine();
			
			if(response.equals("N")) {
				
				System.out.println("Thank you for banking with us!");
				flag = false;
				
			}
		}
	}
	
	// CREATES NEW ACCOUNT
	public void createAccount() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Opening new account");
		System.out.println("Enter customer PIN"); // New pin
		int pin = input.nextInt();
		
		System.out.println("Enter Social Security #");
		int ssn = input.nextInt();
		
		int account_number = accountNumberGenerator();
		System.out.println("System generated account # : " + account_number);
		
		
		System.out.println("Checking or savings?\n0 for checking\n1 for savings");
		int choice = input.nextInt();
		
		// CHOICE FOR CREATING CHECKING ACCOUNT or SAVINGS ACCOUNT
		switch(choice) {
		
		// CREATE CHECKING ACCOUNT
		case 0:
			
			Account account = new Account(account_number,pin,ssn,0);
			addAccount(account);
			break;
		
		// CREATE SAVINGS ACCOUNT
		case 1:
			
			SavingsAccount savings_account = new SavingsAccount();
			addAccount(savings_account);
			break;
		
		}		
	}
	
	// GENERATES ACCOUNT NUMBER
	public int accountNumberGenerator() {
		
		// CREATE RANDOM NUMBER
		Random random = new Random();
		int[] account_number_arr = new int[5];

		int i = 0;
		
		while(i < 5) {
			
			int digit = Math.abs(random.nextInt(10));
			account_number_arr[i] += digit; // INDEX OUT OF BOUNDS
			i++;
		
		}
		
		// ADDS ACCOUNT NUMBER TO STRINGBUILDER OBJECT
		StringBuilder str = new StringBuilder();
		
		for (int num : account_number_arr) 
		{
		     str.append(num);
		}
		
		int account_number = Integer.parseInt(str.toString());
		System.out.println(account_number);
		
		return account_number;
		
	}
	
	// CLOSE ACCOUNT
	public void closeAccount() {
		
		System.out.println("Close Account");
		viewAccountDatabase();
		System.out.println("Enter account number to close");
		
		Scanner input = new Scanner(System.in);
		int account_number = input.nextInt();
		
		deleteAccount(account_number);
	
	}
}
