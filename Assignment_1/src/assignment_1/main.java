package assignment_1;

/**
 *
 * @author Anson Ting
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Main class.
 * 
 * Main class is used for run the program, the menu routine is written in this 
 * class.
 */
public class main {
    magazine mag = new magazine();
    ArrayList<payingCustomer> payingCus = new ArrayList<payingCustomer>();
    ArrayList<associateCustomer> associateCus = new ArrayList<associateCustomer>();
    payingCustomer pc = new payingCustomer();
    associateCustomer ac = new associateCustomer();
    magazineService ms = new magazineService();
    
    // print out student info
    public String studentInfo(){
        return 
               "\nICT 373 Assignment 1"+
               "\nName: Anson Ting Lik Yuan"+
               "\nStudent Number: 34212178";             
    }
    
    // print out menu
    public String displayMenu(){
        return 
               "\n===== PROGRAM MENU ====="+
               "\n1. Display associate customers list."+
               "\n2. Display paying customers list."+
               "\n3. Display all email notification for all customers every each week."+
               "\n4. Display monthly bill email for all paying customers."+
               "\n5. Add new customer."+
               "\n6. Remove existing customer."+
               "\n7. Exit the program."+
               "\nPlease enter a number to run the function."+
               "\n:";
               
    }
    
    // loadData method is to load few set of data into the arraylist.
    public void loadData() throws Exception{ 
        mag = new magazine();
        ac = new associateCustomer("Bryan", "bryanhey@gmail.com", mag, "lisalolisa@gmail.com");        
        associateCus.add(ac);
        
        mag = new magazine("Sports",7,"Games",8);
        ac = new associateCustomer("John", "johnie@gmail.com", mag, "sally00@gmail.com");
        associateCus.add(ac);

        mag = new magazine("Games", 8);
        ac = new associateCustomer("Billy", "billyjelly@gmail.com", mag, "sally00@gmail.com");
        associateCus.add(ac);
        
        mag = new magazine("Movies", 8);
        pc = new payingCustomer("Jane", "jane1991@gmail.com", mag, "Jane Legend", "5432-4321-5434-5454", "06/2025");
        payingCus.add(pc);

        mag = new magazine("Movies", 8, "Tvs", 6);
        pc = new payingCustomer("Sally", "sally00@gmail.com", mag, "Sally Tyoop", "CommonWealth Bank", "636-123 423242");
        pc.addAssociateCustomer(associateCus,"johnie@gmail.com");
        pc.addAssociateCustomer(associateCus,"billyjelly@gmail.com");
        payingCus.add(pc);
        
        
        mag = new magazine("Sport", 7, "Movie", 8, "Tvs", 6);
        pc = new payingCustomer("Lisa", "lisalolisa@gmail.com", mag, "Lisa Ay", "5432-4321-1212-4343", "04/2024");
        pc.addAssociateCustomer(associateCus,"bryanhey@gmail.com");
        payingCus.add(pc);

        ms = new magazineService(associateCus,payingCus);
    }
    
    // Built menu routine.
    public void runProgram() throws Exception{
        Scanner kb = new Scanner(System.in);
        loadData();
        System.out.println(studentInfo());
        System.out.println("\n==========Assignment 1==========\n");
        boolean ansCheck = true;

        // while loop + switch case
        while(ansCheck){
            System.out.println(displayMenu());
            String ans = kb.nextLine();
            switch(ans){
                case "1":
                    System.out.println(associateCus.toString().replace("[", "").replace("]", "").replace(",",""));
                    //ansCheck = false;
                    break;
                case "2":
                    System.out.println(payingCus.toString().replace("[", "").replace("]", "").replace(",",""));
                    break;
                case "3":
                    ms.weeklyEmail();
                    break;
                case "4":
                    ms.monthlyBill();
                    break;
                case "5":
                    ms.addCustomer();
                    break;
                case "6":
                    ms.deleteCustomer();
                    break;
                case "7":
                    System.out.println("Thanks for using the program.");
                    System.out.println("Exiting ...");
                    System.exit(0);
                default:
                    System.out.println("\nPlease only enter number 1 - 7\n");
                   
            }
        }   
        kb.close();
    } 
    
    public static void main(String[] args) throws Exception{
        main m = new main();       
        m.runProgram();     
    }
}
