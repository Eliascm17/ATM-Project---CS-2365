package project;

import java.util.Scanner;

public class SystemInterface extends AccountFunctions {
    
    Account account;
    double last_deposit = 0;
    Scanner input = new Scanner(System.in);
    
    public void deposit(Account a) {
        
        System.out.println("Enter deposit amount : ");
        double deposit_amount = input.nextDouble();
        
        double new_balance = (a.getBalance() + deposit_amount);
        
        a.setBalance(new_balance);
        last_deposit = deposit_amount;
        
        viewBalance(a);
        
    }
    
    public void withdraw() {
        
        System.out.println("Enter withdraw amount : ");
        double withdrawal_amount = input.nextDouble();
        
        double new_balance = (account.getBalance() - withdrawal_amount);
        
        account.setBalance(new_balance);
        
        viewBalance(account);
        
    }
    
    // TRANSFER FUNDS
    // Still needs to check if funds are available, etc.
    public void transfer() {
        
        System.out.println("Enter destination account");
        int dest= input.nextInt();
        
        Account destination_account = searchAccount(dest);
        
        System.out.println("Enter transfer amount : ");
        double transfer= input.nextDouble();
        
        double origin_balance = account.getBalance();
        double destination_balance = destination_account.getBalance();
        double new_origin_balance = (origin_balance - transfer);
        double new_destination_balance = (destination_balance + transfer);
        
        account.setBalance(new_origin_balance);
        destination_account.setBalance(new_destination_balance);
        
        //viewBalance();
        System.out.println("Destination account balance : " + destination_account.getBalance());
        
    }
    
    public void viewBalance(Account a) {
    	
    	String numberAsString = String.format ("%,.2f", a.getBalance());
        System.out.println("Your balance : " + numberAsString);
        
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
