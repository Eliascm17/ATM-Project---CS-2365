package project;

import java.util.ArrayList;

/*
 * Team L:
 * 		Leidy Ward
 * 		Elias Moreno
 * 		Xin Huang
 * 		John Goodrich
 * 
 * Class to hold simple account functions to be performed 
 * (search, delete, and view account)
 */

public abstract class AccountFunctions {
    
    AccountDatabase account_list = new AccountDatabase();
    
    //search for an account
    public Account searchAccount(String account_number) {
        
    		//loop through database
        for(Account a : account_list) {
            
            if(account_number == a.getAccount_number()) {
                //return account if found
                System.out.println("Found destination account");
                return a;
                
            }
        }
        
        System.out.println("Destination account doesn't exist");
        return null;
        
    }
    
    //add an account to the database
    public void addAccount(Account account) {
        
        System.out.println("Adding account : " + account.getAccount_number());
        account_list.add(account);
        
    }
    
    //delete account from database
    public void deleteAccount(String account_number) {
        
        Account a = searchAccount(account_number);
        System.out.println("Closing " + a.getAccount_number());
        account_list.remove(a);
        
    }
    
    //view account database
    public void viewAccountDatabase() {
        
        for(Account a : account_list) {
            
            System.out.println(a.getAccount_number());
            
        }
    }
    
    public ArrayList<Account> getAccountDatabase() {
        
        return account_list;
        
    }
}
