
package project;

import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Team L:
 * 		Leidy Ward
 * 		Elias Moreno
 * 		Xin Huang
 * 		John Goodrich
 * 
 * Bank Staff class to access the methods that only a bank staff member
 * can access (open/close account)
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
		            input.nextLine();
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
//		            input.close();
            
		            // PROMPTS USER FOR CONTINUING PROGRAM
		            Scanner cont = new Scanner(System.in);
		            System.out.println("Continue banking? Y/N");
		            
		            String response = cont.nextLine();
		            System.out.println(response);
		            response = response.toUpperCase();	
		            
	                while(!(response.equals("Y")) && !(response.equals("N"))){
	                    System.out.println("\nPlease enter Y or N\n");
	                    response = cont.next();
	                    response = response.toUpperCase();
	                	}
		            if(response.equals("N")) {
		
							System.out.println("Thank you for banking with us!");
							flag = false;
							System.exit(0);
		            }
		            else if(response.equals("Y")) 
                            bankStaffMenu();  
		
		            cont.close();
		        }
		        catch(InputMismatchException n) {
		            System.out.println("\nERROR. Please enter a number 5 - 7");
		
		        }
            

        	}
          
    }
    
 // CREATES NEW ACCOUNT
    public void createAccount() {
    	
    		String account_number;
    		int pin = 0, ssn = 0, choice = 0;
    		
        Scanner input = new Scanner(System.in);
        
        System.out.println("\nOpening new account");
        System.out.println("\nEnter customer PIN"); // New pin
        pin = input.nextInt();
        
        String pinStr = String.valueOf(pin);
        //while the pin entered is an invalid length
  		while(checkInput(pinStr,4) == false) {
  			System.out.println("\nINVALID pin length. Please try again.");
  			pin = input.nextInt();
  			pinStr = String.valueOf(pin);
  		}
        
        System.out.println("\nEnter Social Security #");
        ssn = input.nextInt();
        
        String ssnStr = String.valueOf(ssn);
        //while the ssn entered is an invalid length
        while(checkInput(ssnStr,5) == false) {
  			System.out.println("\nINVALID SSN length. Please try again.");
  			ssn = input.nextInt();
  			ssnStr = String.valueOf(ssn);
  		}
        
        System.out.println("\nChecking or Savings?\\n0 for Checking\\n1 for Savings");
        choice = input.nextInt();
        
        // CHOICE FOR CREATING CHECKING ACCOUNT or SAVINGS ACCOUNT
        switch(choice) {
                
            // CREATE CHECKING ACCOUNT
            case 0:
            	
            	account_number = accountNumberGenerator(0);
            	//String numberAsString1 = String.valueOf(account_number);
            	CheckingAccount checking_account = new CheckingAccount(account_number,pin,ssn,0.0);
            	addAccount(checking_account);
            	break;
            	
                
            // CREATE SAVINGS ACCOUNT
            case 1:
            account_number = accountNumberGenerator(1);
            //String numberAsString2 = String.valueOf(account_number);
            SavingsAccount savings_account = new SavingsAccount(account_number,pin,ssn,0.0);
            addAccount(savings_account);
            break;
                
        }
        
        input.close();
    }
    
    // GENERATES ACCOUNT NUMBER
    public String accountNumberGenerator(int type) {
        
        // CREATE RANDOM NUMBER
        Random random = new Random();
        int[] account_number_arr = new int[5];
        
        //sets choice as 1 or 0 for index 0 so that it is either a savings or checking acct.
        account_number_arr[0] = type;
        
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
        
        //int account_number = Integer.parseInt(str.toString());
        System.out.println("System generated Account Number: " + str);
        
        return str.toString();
        
    }
    
    // CLOSE ACCOUNT
    public void closeAccount() {
        Scanner in = new Scanner(System.in);
        System.out.println("Close Account");
        viewAccountDatabase();
        System.out.println("Enter account number to close: ");
        //This gets rid of the \n blank space to not confuse our scanner
//        in.nextLine();
        String account_number = in.nextLine();
        
        System.out.println("Your account number is "+ account_number);
        deleteAccount(account_number);
    }
    
    public static boolean checkInput(String input, int length) {
        
        if(input.length() == length) {
            //user input checks out
            return true;
        }
        return false;
        
    }
}
