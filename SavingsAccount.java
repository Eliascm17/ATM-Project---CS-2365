package project;

public class SavingsAccount extends Account {
    String type = "savings";
    
    SavingsAccount(int accNumber, int pinEntered, int userSSN, double bal) {
        setSavings();
        account_number = accNumber;
        pin = pinEntered;
        ssn = userSSN;
        balance = bal;
        //type = "savings";
    }
}
