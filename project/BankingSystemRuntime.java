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



/**
 * @author John Goodrich
 *
 * R # 11605245
 *
 *    deposit
 *    withdraw
 *    check balance
 *    transfer
 *
 *    enter account number (3 attempts)
 *    verify pin (3 attempts)
 *
 *    if succesfful,
 *
 *    prompt for action (wd, cb, etc.)
 *    for withdraw, check balance for sufficient funds
 *    for transfer, check source and destination accounts
 *    bank staff can open or close account with PIN, SSN, and zero balance (system creates account number)
 *
 */

public class BankingSystemRuntime {
    
    static AccountDatabase database = new AccountDatabase();
    
    public static void main(String[] args) {
        
        /*Timer timer = new Timer();*/
        // timer.schedult(task);
        //AccountDatabase database = new AccountDatabase();
        boolean flag = true;
        int account_number = 0;
        int enter_count = 3, pin_count = 3;        //counter for attempts
        
        while(flag == true) {
            
            Scanner input = new Scanner(System.in);
            
            System.out.println("Enter account number : ");
            try {
                account_number = input.nextInt();
                
                //while the account number entered is invalid
                while((checkInput(account_number,5) == false) || checkAn(account_number) == false) {
                    
                    System.out.println("\nINVALID Account number. Please try again.");
                    enter_count = attemptsLeft(enter_count);
                    
                    account_number = input.nextInt();
                }
                
                //if bank staff account entered
                if(account_number == 11111) {
                    System.out.println("Bank Staff");
                    
                    BankStaff bs = new BankStaff();
                    //go to bank staff menu
                    bs.bankStaffMenu();
                }
                
                
                // CUSTOMER ENTERS PIN
                // Needs a separate method
                System.out.println("\nEnter Pin: ");
                
                int pin = input.nextInt();
                if(checkInput(pin,4) == true) {
                    
                    //validate the pin entered
                    for(Account a : database) {
                        
                        if(pin == a.getPin() && account_number == a.getAccount_number()) {
                            
                            System.out.println("\nPin validated");
                            Customer customer = new Customer(a);
                            //customer.setSystemAccount(a);
                            //customer.setCustomerAccount(a);
                            
                            //go to customer menu
                            customer.customerMenu();
                        }
                        
                        else    {
                            System.out.println("Invalid pin. Please try again.");
                            pin_count = attemptsLeft(pin_count);
                        }
                        continue;
                        
                    }
                }
                else {
                    System.out.println("Invalid pin. Please try again.");
                    pin_count = attemptsLeft(pin_count);
                }
            }
            catch(InputMismatchException n) {
                System.out.println("\nERROR. Only numbers allowed. Please try again.\n");
                enter_count = attemptsLeft(enter_count);
                
            }
            
            /*System.out.println("Shut down ATM? Y/N");
             String response = input.nextLine();
             response.toUpperCase();
             
             //insert CATCH FOR ANYTHING OTHER THAN Y OR N
             if(response.equals("Y")) {
             System.out.println("System shutting down");
             System.exit(0);
             }
             if(response.equals("N") ) {
             //return to menu
             
             }*/
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
    
    public static boolean checkAn(int aNum) {
        
        //for the accounts in the set
        for(Account a : database) {
            //check if any account number matches the entered account number
            if(a.getAccount_number() == aNum)
                return true;
        }
        
        //if not, return false
        return false;
    }
    
    // CHECK INPUT LENGTHS - checks the required lengths of inputs
    
    public static boolean checkInput(int input, int length) {
        
        if(String.valueOf(input).length() == length) {
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
    static Account returnAccount(int aNum) {
        for(Account a : database) {
            //check if any account number matches the entered account number
            if(a.getAccount_number() == aNum)
                return a;
        }
        Account none = new Account();
        return none;
    }
    
    //what does this do??
    private class Counter extends TimerTask {
        
        Account a;
        
        Counter(Account a) {
            this.a = a;
        }
        
        public void run() {
            double balance = (a.getBalance() + (a.getBalance()));
            a.setBalance(balance);
            
        }
    }
}
