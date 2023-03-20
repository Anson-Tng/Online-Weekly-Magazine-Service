package assignment_1;

/**
 *
 * @author Anson Ting
 */

/**
 * 
 * BankAccount class.
 * 
 * This class is made to holds the information of paying customer paying with
 * fund transfer.
 */

public class bankAccount{
    private String name;
    private String bankName;
    private String accountNumber;
    
    // Default constructor
    public bankAccount(){
        this.name = "";
        this.bankName = "";
        this.accountNumber = "";
    }
    
    // Constructor with assign parameter values
    public bankAccount(String nam, String bankN, String accountN)throws Exception{
        this.name = nam;
        this.bankName = bankN;
        this.accountNumber = accountN;
    }
    
    // Set method
    public void setName(String nam){
        this.name = nam;
    }
    
    // Set method
    public void setBankName(String bankNam){
        this.bankName = bankNam;
    }
    
    // Set method
    public void setAccountNumber(String accountNum){
        this.accountNumber = accountNum;
    }
    
    // Get method
    public String getName(){
        return this.name;
    }
    
    // Get method
    public String getBankName(){
        return this.bankName;
    }
    
    // Get method
    public String getAccountNumber(){
        return this.accountNumber;
    }
    
    // Modified toString method.
    @Override
    public String toString(){
        return "\n==========   Fund Transfer   =========="+
               "\nName: "+this.name+
               "\nBank: "+this.bankName+
               "\nAccount number: "+this.accountNumber+
               "\n========== End Fund Transfer ==========\n\n";
    }
    
    
}
