package assignment_1;

/**
 *
 * @author Anson Ting
 */

/**
 *
 * AssociateCustomer Class.
 *  This class is derived class of customer class, this class includes the 
 *  information about associate customer. 
 * 
 */
public class associateCustomer extends customer{
    private double total;
    private String paidBy;
    
    
    // Default constructor
    public associateCustomer(){
        super();
        this.paidBy = "";   // this variable contains the email of paying customer.
    }
    
    // Constructor with assign parameter values
    public associateCustomer(String name, String email,magazine supplementList,
             String peoplePaid)throws Exception {
        super(name, email, supplementList);
        this.paidBy = peoplePaid;
    }
    
    // Set method
    public void setPaidBy(String peoplePaid){
        this.paidBy = peoplePaid;
    }
    
    // this method is included when removing a related paying customer from the system.
    public void removePaidBy(){
        this.paidBy = "Removed, please add a new payment method.";
    }
    
    // Get method
    public String getPaidBy(){
        return this.paidBy;
    }
    
    // Get method of all paying amount for associate customer him/herself
    public double getTotalAC(){
        double magP = getMagCost();
        double supP = getSupCost();
        return supP + magP ;
    }
    
    // Modified toString method.
    @Override
    public String toString(){
        return "====================== Associate Customer =========================="+
               "\nCustomer name         : "+getName()+
               "\nCustomer email        : "+getEmail()+"\n"
                +getList()+
               "\nSubscription paid by  : "+this.paidBy+"\n"+
               "Total paid            : "+getTotalAC()+"$\n"+
               " ====================== End Associate Customer ======================\n\n";
    }
    
}
