package project;


public class Account {
    //class attributes
    protected String account_number; // 5 digits, 4 digits, 9 digits;
    protected int pin, ssn;
    protected double balance = 0;
    private boolean savings_account = false;
    
    public Account() {
        
    }
    
    //account constructor
    public Account(String account_number, int PIN, int SSN, double balance) {
        
        //if the inputs are of valid lengths, then set
        if(account_number.length() == 5) {
            
            setAccount_number(account_number);
            
        }
        
        if(String.valueOf(PIN).length() == 4) {
            
            setPin(PIN);
            
        }
        
        if(String.valueOf(SSN).length() == 5) {
            
            setSsn(SSN);
            
        }
        
        if(balance >= 0) {
            
            setBalance(balance);
            
        }
    }
    
    //mutator and accessor methods
    public int getSsn() {
        return ssn;
    }
    
    public void setSsn(int ssn) {
        this.ssn = ssn;
    }
    
    public String getAccount_number() {
        return account_number;
    }
    
    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }
    
    public int getPin() {
 
        return pin;
    }
    
    public void setPin(int pin) {
        this.pin = pin;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void setSavings() {
        
        this.savings_account = true;
        
    }
    
    public boolean isSavings() {
        
        return savings_account;
        
    }
    
}
