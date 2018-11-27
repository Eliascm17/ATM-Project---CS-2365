package project;

/*
 * Team L:
 * 		Leidy Ward
 * 		Elias Moreno
 * 		Xin Huang
 * 		John Goodrich
 * 
 * Checking Account class with Account class as superclass
 */

class CheckingAccount extends Account{
    String type = "checking";
    
    //constructor
    CheckingAccount(String accNumber, int pinEntered, int userSSN, double bal) {
        account_number = accNumber;
        pin = pinEntered;
        ssn = userSSN;
        balance = bal;
    }
    
}
