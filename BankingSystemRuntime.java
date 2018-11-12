/**
 * This is a program for the COSC 2365 Object Oriented Programming Course
 * Professor Shin
 * Fall 2018
 * 
 * Created by John Goodrich �2018
 */
package project;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;



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
		
		/*Timer timer = new Timer();*/
		// timer.schedult(task);
		AccountDatabase database = new AccountDatabase();
		boolean flag = true;
		
		
		while(flag == true) {
		
			Scanner input = new Scanner(System.in);
			
			System.out.println("Enter account number : ");
			int account_number = input.nextInt();
			
			int enter_count = 3;
			while(checkInput(account_number,5) == false) {
				
				System.out.println("Invalid Account number, please re-enter");
				System.out.println("You have " + enter_count + " tries left");
				account_number = input.nextInt();
				
				enter_count--;
				
				if(enter_count == 0) {
					
					System.out.println("Max number of attempts exceeded, system shutting down for security purposes");
					System.exit(0);
					
				}
			}
			
			if(account_number == 11111) {
				System.out.println("Bank staff");
				
				BankStaff bs = new BankStaff();
				bs.bankStaffMenu();
				
			}			
			
			// OPENS BANKSTAFF MENU
			
			// CUSTOMER ENTERS PIN
			// Needs a separate method
			System.out.println("Enter Pin : ");
			int pin = input.nextInt();
			
			if(checkInput(pin,4) == true) {
				
				for(Account a : database) {
				
					if(account_number == a.getAccount_number()) {
						
						if(pin == a.getPin()) {
							
							System.out.println("Pin validated");
							Customer customer = new Customer();
							customer.setSystemAccount(a);
							customer.setCustomerAccount(a);
							customer.customerMenu();
							
						}
						
						else {
							
							System.out.println("Invalid pin");
							
						}
					}
					
					else {
						
						System.out.println("Account not found");
						
					}
					
					continue;
					
				}
			}
			
			Scanner menu_return = new Scanner(System.in);
			
			System.out.println("Shut down ATM? Y/N");
			String response = menu_return.nextLine();
			
			if(response.equals("Y")) {
				
				System.out.println("System shutting down");
				System.exit(0);
				
			}
		}// while loop
		////////////////////////////////
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
	
	private class Counter extends TimerTask {
		
		Account a;
		
		Counter(Account a) {
			this.a = a;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			double balance = (a.getBalance() + (a.getBalance()));
			a.setBalance(balance);
			
		}
	}
}
