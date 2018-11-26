package project;

//checking account class
class CheckingAccount extends Account{
    String type = "checking";
    
    CheckingAccount(String accNumber, int pinEntered, int userSSN, double bal) {
        account_number = accNumber;
        pin = pinEntered;
        ssn = userSSN;
        balance = bal;
        //type = "checking";
    }
    
}
