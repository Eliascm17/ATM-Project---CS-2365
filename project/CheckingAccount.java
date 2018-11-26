package project;

//checking account class
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
