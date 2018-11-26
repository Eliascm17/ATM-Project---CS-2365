package project;

import java.util.ArrayList;

public class AccountDatabase extends ArrayList<Account> {
    
    //private static final long serialVersionUID = 1L;
    
    AccountDatabase() {
    	
    	//Bank Staff Account
    	Account bankStaff = new Account("11111", 0000, 00000, 0);
    	
        //Checking Accounts
        Account checking1 = new CheckingAccount("16787",9999,30430,800);
        Account checking2 = new CheckingAccount("16788",6778,30430,1500);
        Account checking3 = new CheckingAccount("16789",4440,30430,700);
        
        
        //Savings Accounts
        Account savings1 = new SavingsAccount("06787",9999,30430,200);
        Account savings2 = new SavingsAccount("06790",3443,30430,150);
        
        add(bankStaff);
        add(checking1);
        add(checking2);
        add(checking3);
        add(savings1);
        add(savings2);
        
        
    }
}
