package project;

import java.util.ArrayList;

public abstract class AccountFunctions {
    
    AccountDatabase account_list = new AccountDatabase();
    
    public Account searchAccount(int account_number) {
        
        for(Account a : account_list) {
            
            if(account_number == a.getAccount_number()) {
                
                System.out.println("Found destination account");
                return a;
                
            }
        }
        
        System.out.println("Destination account doesn't exist");
        return null;
        
    }
    
    public void addAccount(Account account) {
        
        System.out.println("Adding account : " + account.getAccount_number());
        account_list.add(account);
        
    }
    
    public void deleteAccount(int account_number) {
        
        Account a = searchAccount(account_number);
        System.out.println("Closing " + a.getAccount_number());
        account_list.remove(a);
        
    }
    
    public void viewAccountDatabase() {
        
        for(Account a : account_list) {
            
            System.out.println(a.getAccount_number());
            
        }
    }
    
    public ArrayList<Account> getAccountDatabase() {
        
        return account_list;
        
    }
}
