package project;

/*
 * Team L:
 * 		Leidy Ward
 * 		Elias Moreno
 * 		Xin Huang
 * 		John Goodrich
 * 
 * System Interface class to perform menu options
 */


import java.util.Scanner;

public class SystemInterface extends AccountFunctions {
    
    Account account;
    double last_deposit = 0;
    Scanner input = new Scanner(System.in);
    
    public void deposit(Account a) {
        
        System.out.println("Enter deposit amount : ");
        double deposit_amount = input.nextDouble();
        if(deposit_amount>0) {
        	
	        double new_balance = (a.getBalance() + deposit_amount);
	        a.setBalance(new_balance);
	        last_deposit = deposit_amount;
	        viewBalance(a);
	        
        }
        else {
        	System.out.println("Please Withdraw Instead");
        }
        
    }
    
    public void withdraw() {
    	
    	Scanner input = new Scanner(System.in);
        
        System.out.println("Enter withdraw amount : ");
        double withdrawal_amount = input.nextDouble();
        if(account.getBalance()>withdrawal_amount) {
        	
	        double new_balance = (account.getBalance() - withdrawal_amount);
	        account.setBalance(new_balance);
	        viewBalance(account);
        }
        else{
        	System.out.println("Insufficient Funds");
        }
        
    }
    
    // TRANSFER FUNDS
    // Still needs to check if funds are available, etc.
    public void transfer() {
    	
    	Scanner input = new Scanner(System.in);
        
        System.out.println("Enter destination account");
        String dest= input.nextLine();
        
        Account destination_account = searchAccount(dest);
        
        while(destination_account==null){
        	
        	System.out.println("Enter destination account");
            dest= input.nextLine();
            destination_account = searchAccount(dest);
            
        }
        
        System.out.println("\nEnter transfer amount : ");
        double transfer= input.nextDouble();
        
        double origin_balance = account.getBalance();
        double destination_balance = destination_account.getBalance();
        
        if(origin_balance>=transfer && transfer>0){
        
	        double new_origin_balance = (origin_balance - transfer);
	        double new_destination_balance = (destination_balance + transfer);
	        
	        account.setBalance(new_origin_balance);
	        destination_account.setBalance(new_destination_balance);
	        
	        viewBalance(account);
	        System.out.println("Destination account balance : " + destination_account.getBalance());
        }
        else {
        	System.out.println("Insufficient Funds or invalid input");
        }
	      
    }
    
    public void viewBalance(Account a) {
    	
    	String numberAsString = String.format ("%,.2f", a.getBalance());
        System.out.println("\nYour balance : " + numberAsString);
        
    }
    
    public void viewLastDeposit() {
        
    	String numberAsString = String.format ("%,.2f", last_deposit);
        System.out.println("Last deposit amount : " + numberAsString);
        
    }
    
    public void setSystemAccount(Customer customer) {
        
        this.account = customer.getCustomerAccount();
        
    }
    
    public void setSystemAccount(Account account) {
        
        this.account = account;
        
    }
    
    public Account getSystemAccount() {
        
        return account;
        
    }
}
