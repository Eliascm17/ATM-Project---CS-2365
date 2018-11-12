package project;

import java.util.Random;
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
            int choice = input.nextInt();
            
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
            String response = input.nextLine();
            response.toUpperCase();
            
            //insert CATCH FOR ANYTHING OTHER THAN Y OR N
            if(response.equals("Y")) {
                bankStaffMenu();
            }
            if(response.equals("N") ) {
                System.out.println("\nSystem shutting down");
                System.exit(0);
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
                
                CheckingAccount checking_account = new CheckingAccount(account_number,pin,ssn,0.0);
                addAccount(checking_account);
                break;
                
                // CREATE SAVINGS ACCOUNT
            case 1:
                
                SavingsAccount savings_account = new SavingsAccount(account_number,pin,ssn,0.0);
                addAccount(savings_account);
                break;
                
        }
        input.close();
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
        System.out.println("Enter account number to close: ");
        
        Scanner input = new Scanner(System.in);
        int account_number = input.nextInt();
        
        deleteAccount(account_number);
        
        input.close();
    }
}
