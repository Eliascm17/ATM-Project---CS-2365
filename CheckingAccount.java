package project;

//checking account class
class CheckingAccount extends Account{
    String type = "checking";
    
    CheckingAccount(int accNumber, int pinEntered, int userSSN, double bal) {
        account_number = accNumber;
        pin = pinEntered;
        ssn = userSSN;
        balance = bal;
        //type = "checking";
    }
