package assignment_1;

/**
 *
 * @author Anson Ting
 */

/**
 * 
 * Magazine class.
 * 
 * The name of magazine is set default and its only name as WeeklyFun magazine
 * and this class include the list of supplement, so customer can subscribe to 
 * multiple supplements for a magazine.
 */
import java.util.ArrayList;
import java.util.List;

public class magazine {
    private String magName = "WeeklyFun";
    private double magCost = 8;
    private List<supplement> supplementList = new ArrayList<supplement>();
    private supplement newSup = new supplement();

    // Default constructor
    public magazine(){
        this.magName = "WeeklyFun";
        this.magCost = 8;
        this.supplementList.add(new supplement("None",0));
    }
    
    // constructor with assign parameter values for one supplement
    public magazine(String supName, double supCost)throws Exception{
        newSup = new supplement(supName,supCost);
        this.supplementList.add(newSup);
    }
    
    // constructor with assign parameter values for two supplements
    public magazine(String supName, double supCost, 
            String supName2, double supCost2)throws Exception{
        newSup = new supplement(supName,supCost);
        this.supplementList.add(newSup);
        newSup = new supplement(supName2,supCost2);
        this.supplementList.add(newSup);
    }
    
    // constructor with assign parameter values, if only three supplement
    public magazine(String supName, double supCost, 
            String supName2, double supCost2, String supName3, double supCost3)throws Exception{
        newSup = new supplement(supName,supCost);
        this.supplementList.add(newSup);
        newSup = new supplement(supName2,supCost2);
        this.supplementList.add(newSup);
        newSup = new supplement(supName3,supCost3);
        this.supplementList.add(newSup);
    }

    // constructor with assign parameter values, if only four supplement
    public magazine(String supName, double supCost, 
            String supName2, double supCost2, String supName3,
            double supCost3, String supName4, double supCost4)throws Exception{
        newSup = new supplement(supName,supCost);
        this.supplementList.add(newSup);
         newSup = new supplement(supName2,supCost2);
        this.supplementList.add(newSup);
        newSup = new supplement(supName3,supCost3);
        this.supplementList.add(newSup);
         newSup = new supplement(supName4,supCost4);
        this.supplementList.add(newSup);

    }    
    
    // Get method
    public String getMagName(){
        return this.magName;
    }
    
    // Get method
    public double getMagCost(){
        return this.magCost;
    }
    
    // Get list of supplements from supplement class.
    public void getInterests()throws Exception{
        System.out.println("List of interests:");
        for(int i=0;i<this.supplementList.size();i++){
            System.out.println(supplementList.get(i)+"\n");            
        }
    }

    // Get total cost of subscribed supplements
    public double getSupTotal(){
        double total = 0;
        for(int i=0;i<this.supplementList.size();i++){          
            total +=this.supplementList.get(i).getWeeklyCost();
        }
        return total;
    }

    // Modified toString method.
    @Override
    public String toString(){
        return "\nMagazine name         : "+this.magName+
               "\nMagazine cost         : "+this.magCost+"$\n"+
               this.supplementList.toString().replace("[", "").replace("]", "").replace(",","");
    }
    
    
}
