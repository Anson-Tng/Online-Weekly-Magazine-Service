package assignment_1;

/**
 *
 * @author Anson Ting
 */

/**
 * 
 * Customer class.
 * 
 * This class includes the general information of the customer should have, and 
 * inherited to associate customer class and paying customer class.
 */
public class customer {
    private String name;
    private String email;
    private magazine mag;
    
    // Default constructor
    public customer(){
        this.name ="";
        this.email="";
        this.mag = null;
    }
    
    // Constructor with assign parameter values
    public customer(String name, String email,magazine supplementList)throws Exception{
        this.name = name;
        this.email = email;
        this.mag = supplementList;
    }
    
    // Set method
    public void setName(String name){
        this.name = name;
    }
    
    // Set method
    public void setEmail(String email){
        this.email = email;
    }
    
    // Get method
    public String getName(){
        return this.name;
    }
    
    // Get method
    public String getEmail(){
        return this.email;
    }
    
    // Get method
    public magazine getList(){
        return this.mag;
    }
    
    // Get the cost of magazine.
    public double getMagCost(){
        return this.mag.getMagCost();
    }
    
    // Get the total cost of supplements in the magazine object.
    public double getSupCost(){
        return this.mag.getSupTotal();
    }
    
    // Modified toString method.
    @Override
    public String toString(){
        return "Customer name     : "+this.name+"\n"+
               "Customer email    : "+this.email+"\n"+
               this.mag;
    }
    
}
