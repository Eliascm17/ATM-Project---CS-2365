package project;

/* CS 2365
 * Team L:
 * 		Leidy Ward
 * 		Elias Moreno
 * 		Xin Huang
 * 		John Goodrich
 * 
 * Savings Account class with Account class as superclass
 */

public class SavingsAccount extends Account {
    String type = "savings";
    
    //constructor
    SavingsAccount(String accNumber, int pinEntered, int userSSN, double bal) {
        setSavings();
        account_number = accNumber;
        pin = pinEntered;
        ssn = userSSN;
        balance = bal;
    }
}
