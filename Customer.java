package project;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends SystemInterface {
	
	ArrayList<Account> account_list;
	Account customer_account;
	double last_deposit = 0;
	
	Customer() {
		
		System.out.println("Welcome to customer banking portal");
		
	}
	
	Customer(Account customer_account) {
		
		setCustomerAccount(customer_account);
		System.out.println("Welcome to customer banking portal");
		customerMenu();
		
	}
	
	// CREATES CUSTOMER MENU
	public void customerMenu() {
		
		boolean flag = true; // determines whether program keeps running
		
		// SWITCH MENU
		while(flag == true) {
			
			System.out.printf("MAIN MENU\n\nEnter 0 for deposit\n1 for withdraw\n2 for current balance\n3 transfer\n4 for last deposit\n5 for cancel");
			
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			
			switch(choice) {
				
				// DEPOSIT
				
				case 0:
					
					last_deposit = 0;
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
					
					System.out.println("Thank you for banking with us!");
					flag = false; // Potential error
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
	
/*	public void deposit() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter deposit amount : ");
		double deposit_amount = input.nextDouble();
		
		double new_balance = (customer_account.getBalance() + deposit_amount);
		
		customer_account.setBalance(new_balance);
		last_deposit = deposit_amount;
		
		viewBalance();
		
	}
	
	public void withdraw() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter withdraw amount : ");
		double withdrawal_amount = input.nextDouble();
		
		double new_balance = (customer_account.getBalance() - withdrawal_amount);

		customer_account.setBalance(new_balance);
		
		viewBalance();
		
	}
	
	public void transfer() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter destination account");
		int dest= input.nextInt();
		
		Account destination_account = searchAccount(dest);
		
		System.out.println("Enter transfer amount : ");
		double transfer= input.nextDouble();
		
		double origin_balance = customer_account.getBalance();
		double destination_balance = destination_account.getBalance();
		double new_origin_balance = (origin_balance - transfer);
		double new_destination_balance = (destination_balance + transfer);
		
		customer_account.setBalance(new_origin_balance);
		destination_account.setBalance(new_destination_balance);
		
		viewBalance();
		System.out.println("Destination account balance : " + destination_account.getBalance());
		
	}
	
	public void viewBalance() {
		
		System.out.println("Your balance : " + customer_account.getBalance());
		
	}
	
	public void viewLastDeposit() {
		
		System.out.println("Last deposit amount : " + last_deposit);
		
	}*/
	
	public void setCustomerAccount(Account customer_account) {
		
		this.customer_account = customer_account;
		
	}
	
	public Account getCustomerAccount() {
		
		return customer_account;
		
	}
}

