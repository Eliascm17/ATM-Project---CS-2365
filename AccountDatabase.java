package project;

import java.util.ArrayList;

public class AccountDatabase extends ArrayList<Account> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AccountDatabase() {
		
		Account account1 = new Account(66787,9999,30430,800); 
		Account account2 = new Account(66788,6778,30430,1500);
		Account account3 = new Account(66789,4440,30430,700);
		Account account4 = new Account(66790,3443,30430,600);
		
		add(account1);
		add(account2);
		add(account3);
		add(account4);
		
	}
}
