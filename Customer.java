package project;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends SystemInterface {
    
    ArrayList<Account> account_list;
    public Account customer_account;
    double last_deposit = 0;
    
    /*Customer() {
     
     System.out.println("\nWelcome to customer banking portal");
     customerMenu();
     
     }*/
    
    Customer(Account c_act) {
        
        setCustomerAccount(c_act);
        setSystemAccount(c_act);
        
        System.out.println("\nWelcome to customer banking portal");
        customer_account = getCustomerAccount();
    }
    
    // CREATES CUSTOMER MENU
    public void customerMenu() {
        
        boolean flag = true; // determines whether program keeps running
        
        //account obj to keep track of the current account
        
        
        // SWITCH MENU
        while(flag == true) {
            
            System.out.printf("\nMAIN MENU\n\n0) Deposit \n1) Withdraw \n2) View Current balance (query account)"
                              + "\n3) Transfer Funds \n4) View last deposit \n5) Cancel \n");
            
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            System.out.print("\n");
            
            switch(choice) {
                    
                    // DEPOSIT
                    
                case 0:
                    
                    last_deposit = 0;
                    deposit(customer_account);
                    break;
                    
                    // WITHDRAW
                    
                case 1:
                    
                    withdraw();
                    break;
                    
                    // VIEW BALANCE
                    
                case 2:
                    
                    viewBalance(customer_account);
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
            
            Scanner cont = new Scanner(System.in);
            System.out.println("\nContinue banking? Y/N");
            String response = cont.nextLine();
            response = response.toUpperCase();
            
            //insert CATCH FOR ANYTHING OTHER THAN Y OR N
            if(response.equals("N") ) {
                System.out.println("\nThank you for banking with us!");
                //flag = false;
                System.exit(0);
            }
            if(response.equals("Y")) {
                customerMenu();
            }
        }
        
        
    }
    
    /*    public void deposit() {
     
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
    
    public void setCustomerAccount(Account c_act) {
        
        customer_account = c_act;
        
    }
    
    public Account getCustomerAccount() {
        
        return customer_account;
        
    }
}

