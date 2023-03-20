package assignment_1;

/**
 *
 * @author Anson Ting
 */

/**
 *
 * PayingCustomer Class.
 *  This class is derived class of customer class, this class includes the 
 *  information about paying customer. 
 * 
 */
import java.util.ArrayList;
import java.util.List;


public class payingCustomer extends customer {
    private List<Double> associateCusPrice = new ArrayList<Double>();
    private List associateCusEmail = new ArrayList();
    private bankAccount bankAccountMethod;
    private creditCard creditCardMethod;
    
    // Default constructor
    public payingCustomer(){
        super();
        this.bankAccountMethod = new bankAccount();
        this.creditCardMethod = new creditCard();
        this.associateCusPrice = new ArrayList();
        this.associateCusEmail = new ArrayList();
    }
    
    //Default constructor with assign parameter values
    public payingCustomer(String name,String email,magazine supplementList,
            String paymentName, String numberOrBankName, String accountNumOrExpDate)throws Exception{
        super(name, email, supplementList);
        if(accountNumOrExpDate.length()>7){
            this.bankAccountMethod = new bankAccount(paymentName, numberOrBankName, accountNumOrExpDate); 
        } else{
            this.creditCardMethod = new creditCard(paymentName, numberOrBankName, accountNumOrExpDate);
        }
        
        this.associateCusPrice = new ArrayList();
        this.associateCusEmail = new ArrayList();
        
    }
    
    // AddAssociateCustomer method is used for adding associate customer into a
    // existing paying customer.
    public void addAssociateCustomer(ArrayList<associateCustomer> ac, String email) throws Exception{
        for(int i=0;i<ac.size();i++){
            if(ac.get(i).getEmail().equalsIgnoreCase(email)){
                this.associateCusPrice.add(ac.get(i).getSupCost());
                this.associateCusEmail.add(ac.get(i).getEmail());
            }
        }
    }
    // RemoveAssociateCustomer method is used for removing associate customer from a
    // existing paying customer.
    public void removeAssociateCustomer(ArrayList<associateCustomer> ac, String email){
        if(this.associateCusEmail.size() == this.associateCusPrice.size()){
            for(int i=0;i<this.associateCusEmail.size();i++){
                if(this.associateCusEmail.get(i).toString().equalsIgnoreCase(email)){
                    this.associateCusEmail.remove(i);
                    this.associateCusPrice.remove(i);
                }
            }
        }
    }
    
    // Get method of all paying amount for paying customer him/herself 
    private double getTotalPC(){
        double magP = getMagCost();
        double supP = getSupCost();
        double othersPrice = 0;
        for(int i=0;i<associateCusPrice.size();i++){
            othersPrice += (this.associateCusPrice.get(i));
            othersPrice += 8;
        }
        return magP + supP + othersPrice ;
    }
    
    // show credit card details or fund transfer detail
    public String showMethod(){
        if(this.bankAccountMethod == null){
            return this.creditCardMethod.toString();
        } else {
            return this.bankAccountMethod.toString();
        }
    }
    
    // Modified toString method.
    @Override
    public String toString(){
        String associateCus = "";
        if(associateCusPrice.size() == associateCusEmail.size()){
            for(int i=0;i<associateCusPrice.size();i++){
                associateCus +="Customer "+(i+1)+"            : "+associateCusEmail.get(i)+"\n"+
                "Total price           : "+(associateCusPrice.get(i)+8)+"$\n\n";
            }
        }       
        
        return "===================== Paying Customer ==========================="+
               "\nCustomer name         : "+getName()+
               "\nCustomer email        : "+getEmail()+"\n"
              + getList() + "\nyou're paying for     :\n\n"+associateCus+
               "\nTotal paid            : "+getTotalPC()+"$\n"+ showMethod()
              +" ===================== End Paying Customer =======================\n\n";
               
    }
    
}
