/**
 * This is a program for the CS 2365 Object Oriented Programming Course
 * Professor Shin
 * Fall 2018
 *
 */
package project;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/*
 * Team L:
 * 		Leidy Ward
 * 		Elias Moreno
 * 		Xin Huang
 * 		John Goodrich
 * 
 * Banking System to run the program. Access to the different menu
 * if valid authentication
 */

public class BankingSystemRuntime {
    
    static AccountDatabase database = new AccountDatabase();
    
    public static void main(String[] args) {
        
        //AccountDatabase database = new AccountDatabase();
        //TIMER THAT EXECUTES EVERY 60 SECONDS
    	int AccountNum = 6; //num of accounts
        int Minute = 1; 
		Timer timer = new Timer(); 
		    timer.schedule(new TimerTask() {
		        @Override
		        public void run() { 
		        	for(Account a : database)
		        	{
		        		double balance = (a.getBalance() * 1.05); 
		        		a.setBalance(balance);
		        	}
		        }
		     }, 0, 1000 * 60 * Minute);
		 //
    
    	
        boolean flag = true;
        String account_number;
        int enter_count = 3, pin_count = 3;        //counter for attempts
        
        while(flag == true) {
            
            Scanner input = new Scanner(System.in);
            
            System.out.println("Enter account number : ");
            try {
                account_number = input.nextLine();
                
                //while the account number entered is invalid
         
                while((checkInput(account_number,5) == false) || checkAn(account_number) == false) {
                    
                    System.out.println("\nINVALID Account number. Please try again.");
                    enter_count = attemptsLeft(enter_count);       
              
                    account_number = input.nextLine();
                    
                }
                
                //if bank staff account entered
                if(account_number.equals("11111")) {
                    System.out.println("\nBank Staff");
                    
                    BankStaff bs = new BankStaff();
                    //go to bank staff menu
                    bs.bankStaffMenu();
                }
                
                
                // CUSTOMER ENTERS PIN
                // Needs a separate method
                boolean pinFlag = true;
                while(pinFlag) {
		                System.out.println("\nEnter Pin: "); 
		                int pin = input.nextInt();
		                String AsaString = String.valueOf(pin);
		      
		                inner:
		                if(checkInput(AsaString,4) == true) {
		                        
		                        if(valPin(pin,account_number)) {
		                        	
		                            System.out.println("\nPin validated");
		                            Customer customer = new Customer(returnA(pin,account_number));
		                            //go to customer menu
		                            customer.customerMenu();
		                            
		                        }
		                        
		                        else{
		                            System.out.println("Invalid pin. Please try again.");
		                            pin_count = attemptsLeft(pin_count);
		                            break inner;
		                        }
		                        //continue;
		                        
		                    
		                }
		                else {
		                    System.out.println("Pin not long enough. Please try again.");
		                    pin_count = attemptsLeft(pin_count);
		                }
            	}
            }
            
            catch(InputMismatchException n) {
                System.out.println("\nERROR. Only numbers allowed. Please try again.\n");
                enter_count = attemptsLeft(enter_count);
                
            }
            
        }
 
    }
    
    public static int attemptsLeft(int counter) {
        counter--;        //decrement attempts left
        System.out.println("Attempts remaining: " + counter + "\n");
        
        if(counter == 0) {
            System.out.println("Max number of attempts exceeded, system shutting down for security purposes.");
            System.exit(0);
        }
        return counter;
    }
    
    public static boolean valPin(int pin, String Accountnum) {
    	
    	for(Account a: database) {
    		if(pin == a.getPin() && Accountnum.equals(a.getAccount_number())) {
    			return true;
    		}
    	}
    	return false;
    }
    public static Account returnA(int pin, String Accountnum) {
    	
    	for(Account a: database) {
    		if(pin == a.getPin() && Accountnum.equals(a.getAccount_number())) {
    			return a;
    		}
    	}
    	return null;

    }
    
    public static boolean checkAn(String aNum) {
        
        //for the accounts in the set
        for(Account a : database) {
            //check if any account number matches the entered account number
            if(a.getAccount_number().equals(aNum))
                return true;
        }
        
        //if not, return false
        return false;
    }
    
    // CHECK INPUT LENGTHS - checks the required lengths of inputs
    
    public static boolean checkInput(String input, int length) {
        
        if(input.length() == length) {
            //user input checks out
            return true;
        }
        return false;
        
    }
    
    //checks the pin for the account
    public static boolean checkPin(Account a, int pinEntered) {
        
        if(a.getPin() == pinEntered)
            return true;
        return false;
    }
    
    //returns the account object associated with account number
    static Account returnAccount(String aNum) {
        for(Account a : database) {
            //check if any account number matches the entered account number
            if(a.getAccount_number() == aNum)
                return a;
        }
        Account none = new Account();
        return none;
    }
				
}
