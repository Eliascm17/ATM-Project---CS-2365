package project;

import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *    BANK STAFF CLASS
 *
 *     Extends systeminterface because it uses the same methods as the Customer class.
 *     introduces new functions to the System interface class.
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
            
            System.out.println("MAIN MENU\n\n5) Open Account\n6) Close Account \n7) Cancel");
            
            Scanner input = new Scanner(System.in);
            try {
		            int choice = input.nextInt();
		            
		            if(choice < 5 || choice > 7)
		            	throw new InputMismatchException();
		            
		            switch(choice) {
		                    
		                    // CANCEL
		                    
		                case 5:
		                    
		                    createAccount();
		                    break;
		                    
		                case 6:
		                    
		                    closeAccount();
		                    break;
		                    
		                case 7:
		                    System.out.println("Thank you.");
		                    flag = false; // potential error
		                    break;
		                    
		            }
		            
            
            
            // PROMPTS USER FOR CONTINUING PROGRAM
            
		            System.out.println("Continue banking? Y/N");
		            
		            Scanner continu = new Scanner(System.in);
		            String response = continu.nextLine();
		            response = response.toUpperCase();		            
	                while(!(response.equals("Y")) && !(response.equals("N"))){
	                    System.out.println("\nPlease enter Y or N\n");
	                    response = continu.next();
	                    response = response.toUpperCase();
	                	}
		            if(response.equals("N")) {
		
							System.out.println("Thank you for banking with us!");
							flag = false;
							System.exit(0);
		            }
		            if(response.equals("Y")) {
		        		bankStaffMenu();
	            }
		
		        }
		        catch(InputMismatchException n) {
		            System.out.println("\nERROR. Please enter a number 0 - 5");
		
		        }
            

        	}
          
    }
    
    // CREATES NEW ACCOUNT
    public void createAccount() {
    	
    	int account_number = 0;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Opening new account");
        System.out.println("Enter customer PIN"); // New pin
        int pin = input.nextInt();
        
        System.out.println("Enter Social Security #");
        int ssn = input.nextInt();
        
        System.out.println("Checking or Savings?\\n0 for Checking\\n1 for Savings");
        int choice = input.nextInt();
        
        // CHOICE FOR CREATING CHECKING ACCOUNT or SAVINGS ACCOUNT
        switch(choice) {
                
                // CREATE CHECKING ACCOUNT
            case 0:
            	
            	account_number = accountNumberGenerator(1);
            	String numberAsString1 = String.valueOf(account_number);
                CheckingAccount checking_account = new CheckingAccount(numberAsString1,pin,ssn,0.0);
                addAccount(checking_account);
                break;
            	
                
                // CREATE SAVINGS ACCOUNT
            case 1:
            	account_number = accountNumberGenerator(0);
            	String numberAsString2 = String.valueOf(account_number);
            	SavingsAccount savings_account = new SavingsAccount(numberAsString2,pin,ssn,0.0);
                addAccount(savings_account);
                break;
                
        }
        
        System.out.println("System generated account # : " + account_number);
        
        input.close();
    }
    
    // GENERATES ACCOUNT NUMBER
    public int accountNumberGenerator(int choice) {
        
        // CREATE RANDOM NUMBER
        Random random = new Random();
        int[] account_number_arr = new int[5];
        
        //sets choice as 1 or 0 for index 0 so that it is either a savings or checking acct.
        account_number_arr[0] = choice;
        
        int i = 1;
        
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
        System.out.println("Enter account number to close: ");
        
        Scanner input = new Scanner(System.in);
        String account_number = input.nextLine();
        
        deleteAccount(account_number);
        
        input.close();
    }
}
