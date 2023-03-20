package assignment_1;

/**
 *
 * @author Anson Ting
 */

/**
 * 
 * Supplement class.
 * 
 * supplement class holds all the available supplements of the magazine,
 * includes Games, Sports, Movies, and Tvs.
 * 
 */
public class supplement {
    private String supplementName;
    private double weeklyCost;
    
    // Default constructor
    public supplement(){
        this.supplementName = null;
        this.weeklyCost = 0;
    }
    
    // constructor with assign parameter values
    public supplement(String name, double cost){
        this.supplementName = name;
        this.weeklyCost = cost;
    }
    
    // Set method
    public void setSupplementName(String name){
        this.supplementName = name;
    }
    
    // Set method
    public void setWeeklyCost(double cost){
        this.weeklyCost = cost;
    }
    
    // Get method
    public String getSupplementName(){
        return this.supplementName;
    }
    
    // Get method
    public double getWeeklyCost(){
        return this.weeklyCost;
    }
    
    // Modified toString method.
    @Override
    public String toString(){
        return  "\nSupplement            : "+this.supplementName
              + "\nWeeky cost            : "+this.weeklyCost+"$\n";
              
    }
    
}
