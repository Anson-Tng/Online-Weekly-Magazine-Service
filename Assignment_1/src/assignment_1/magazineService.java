package assignment_1;

/**
 *
 * @author Anson Ting
 */

/**
 * 
 * magazineService class
 * 
 * This class includes most of the function for the program running.
 * includes :
 *            - Display associate customer list
 *            - Display paying customer list
 *            - Display all email notification for all customers each week (4 week in total)
 *            - Display monthly bill for all paying customer (email)
 *            - add new customer
 *            - remove existing customer
 *            
 * 
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class magazineService {
    magazine mag = new magazine();
    private ArrayList<associateCustomer> acList; 
    private ArrayList<payingCustomer> pcList;
    Scanner kb = new Scanner(System.in);
    private ArrayList<String> supName = new ArrayList<String>();
    private ArrayList<Double> supCost = new ArrayList<Double>();
    
    // Default Constructor
    public magazineService(){
        this.acList = new ArrayList<associateCustomer>();
        this.pcList = new ArrayList<payingCustomer>();
    }
    
    // Constructor with passing in two array list of data list, associate and paying customers.
    public magazineService(ArrayList<associateCustomer> ac, ArrayList<payingCustomer> pc)throws Exception{
        this.acList = ac;
        this.pcList = pc;
    }
    
    // WeeklyEmail is a method that send an email to tell customer the magazine is ready for every week.
    // The way of implementing it, is using nested loop as enter a for loop up to 4 time(1 month = 4 weeks)
    // and two more for loop for reaching to every associate customers and paying customers, and send the
    // notification email with their email and name on.
    public void weeklyEmail()throws Exception{
        String line ="\n------------------------------------------------------------------------------\n";
        String emailSent = "Email sent to ";
        String readyString = ", Good news! the WeeklyFun magazine is available now,"
                + "\n please kindly check on the website and start browsing!";
        for(int week=1;week<=4;week++){
            System.out.println("===== Week "+week+"=====");
            for(int i=0;i<acList.size();i++){
                System.out.println(line+emailSent+acList.get(i).getEmail()+"\n\nHi "+acList.get(i).getName()+readyString+"\n"+line);
            }
            for(int i=0;i<pcList.size();i++){
                System.out.println(line+emailSent+pcList.get(i).getEmail()+"\n\nHi "+pcList.get(i).getName()+readyString+"\n"+line);
            }
            System.out.println("===========================");
        }
    }
    
    // MonthlyBill method is used for send a monthly bill email to all the paying customer.
    // The way of implementing it is loop throught the paying customer list and send the email to
    // all paying customer with their email, name, and bill on it.
    public void monthlyBill()throws Exception{
        String line ="\n------------------------------------------------------------------------------\n";
        String emailSent = "Email sent to ";
        String ready =", your monthly is ready!\nPlease check the bill below.\n\n";
        for(int i=0;i<pcList.size();i++){
            System.out.println(line+emailSent+pcList.get(i).getEmail()+"\n\nHi "+ready+pcList.get(i).toString()+line);
        }
    }
    
    // AddSup method is a method for collecting the information of what supplement they
    // want subscribe.
    // The way of implementing it, is use a while loop and switch case to ask user
    // select what supplements they want by entering number ( 1 - 5 ), another switch
    // case for create the supplement object with the correct constructor.
    public void addSup()throws Exception{
        int maxSup = 0;
        int supCount = 0;
        String supMenu = "The supplements available for our magazine are :\n"
                + "1. Games   8$\n2. Sports  7$\n3. Movies  8$\n4. Tvs     6$\n5.Exit\n";
        System.out.println(supMenu);
        System.out.println("Please enter a number :");
        String selections = kb.nextLine();
        
        while(maxSup<4){   
            switch(selections){
                case "1":
                    supName.add("Games");
                    supCost.add(8.0);
                    maxSup++;
                    supCount++;
                    System.out.println("Adding completed, you can choose "+(4-maxSup)+" more :");
                    break;
                case "2":
                    supName.add("Sports");
                    supCost.add(7.0);
                    maxSup++;
                    supCount++;
                    System.out.println("Adding completed, you can choose "+(4-maxSup)+" more :");
                    break;
                case "3":
                    supName.add("Movies");
                    supCost.add(8.0);
                    maxSup++;
                    supCount++;
                    System.out.println("Adding completed, you can choose "+(4-maxSup)+" more :");
                    break;
                case "4":
                    supName.add("Tvs");
                    supCost.add(6.0);
                    maxSup++;
                    supCount++;
                    System.out.println("Adding completed, you can choose "+(4-maxSup)+" more :");
                    break;
                case "5":
                    maxSup = 5;
                    break;
                default:
                    System.out.println("Please enter only 1 - 5");
                    
            }
            if(maxSup <4){
                selections = kb.nextLine();
            }
        }

        switch(supCount){
            case 0:
                mag = new magazine();
                break;
            case 1:
                mag = new magazine(supName.get(0),supCost.get(0));
                break;
            case 2:
                mag = new magazine(supName.get(0),supCost.get(0),supName.get(1),supCost.get(1));
                break;
            case 3:
                mag = new magazine(supName.get(0),supCost.get(0),supName.get(1),supCost.get(1),supName.get(2),supCost.get(2));
                break;
            case 4:
                mag = new magazine(supName.get(0),supCost.get(0),supName.get(1),supCost.get(1),supName.get(2),
                    supCost.get(2),supName.get(3),supCost.get(3));
                
        }  
    }
    
    // emailValidation method is to check whether user entered the 
    // correct or incorrect email format by looping throught every
    // character and check is it @ symbol in it.
    // * This validation check can be improve by adding valid check
    // on valid email address (Ex. @gmail.com @yahoo.com @live.com.au)
    public String emailValidation()throws Exception{
        String email ="";
        boolean validCheck = true;
        
        while(validCheck){
            email = kb.nextLine();
            for(int i=0;i<email.length();i++){
                if(email.charAt(i) =='@'){
                    return email;
                }
            }
            System.out.println("Please enter valid email address.");
        }
        return "invalid email entered";
    }
    
    // PaidByValidation method is used for valid check on the prompt of 
    // creating associate customer's paying person, if the email isn't in 
    // the database, will needed user to prompt the paying person's email again.
    public String paidByValidation() throws Exception{
        String paidby;
        boolean validCheck = true;
        
        while(validCheck){
            paidby = kb.nextLine();
            for(int i=0;i<paidby.length();i++){
                if(paidby.charAt(i) =='@'){
                    for(int j=0;j<pcList.size();j++){
                        if(pcList.get(j).getEmail().equalsIgnoreCase(paidby)){
                            return paidby;
                        }
                    }
                } 
            }
            System.out.println("The email entered not exist in the database.");
            System.out.println("Please try again.");
        }
        return " Invalid email entered."; 
    }
    
    // AddAssociateCusToPayingCus method is used during adding a new associate customer,
    // the paying person of new assocaite customer needed to add the new assocaite customer
    // in his/her paying list.
    public void addAssociateCusToPayingCus(String associateEmail, String payingEmail) throws Exception{
        for(int i=0;i<pcList.size();i++){
            if(pcList.get(i).getEmail().equalsIgnoreCase(payingEmail)){
                pcList.get(i).addAssociateCustomer(acList, associateEmail);
            }
        }
    }
    
    // AddCustomer is one of the main function of the program, which add a new 
    // customer to the database. Its method will first ask user to prompt name,
    // email(valid check), add supplements(yes or no), self paying or others paying
    // (paying / other), if paying then enter the payment method.
    public void addCustomer()throws Exception{
        boolean cusAnsCheck = true;
        boolean paymentAnsCheck = true;
        System.out.println("\nDear customer, thanks for subscribing us.\nPlease enter your name:");
        String cNam = kb.nextLine();
        String cusName = cNam.substring(0, 1).toUpperCase()+cNam.substring(1).toLowerCase();
        System.out.println("\nHi "+cusName+", Please enter your email:");
        String cusEmail = emailValidation().toLowerCase();//kb.nextLine();
        System.out.println("\nDo you wish to add-on any supplements for the magazine? (Y/N)");
        String cusAns = kb.nextLine().toLowerCase();  
        
        // while loop + switch case
        while(cusAnsCheck){
            switch(cusAns){
                case "y":
                  addSup();
                  cusAnsCheck = false;
                    break;
                case "n":
                  cusAnsCheck = false;
                    break;
                default:
                    System.out.println("\nPlease enter only Y or N");
                    cusAns = kb.nextLine().toLowerCase();  
            }
        }
        
        System.out.println("\nAre you paying for the subscription or someone else paying?");
        System.out.println("(Paying / other ):");
        String paymentAns = kb.nextLine().toLowerCase();
        
        // while loop + switch case
        while(paymentAnsCheck){
            switch(paymentAns){
                case "paying":
                    System.out.println("\nIf paying by Fund transfer, please enter account name, bank name, and account number orderly,");
                    System.out.println("\nIf paying by Credit Card, please enter cardholder name, card number, and expiry date orderly.\n :");
                    System.out.println("\nAccount name / Cardholder name:");
                    String name = kb.nextLine();
                    System.out.println("\nBank name / card number Ex.(1234-1234-1234-1234):");
                    String bNamOrCNum = kb.nextLine();
                    System.out.println("\nAccount number (BSB-BSB 123456)/ expiry date (MM/YYYY):");
                    String accNumOrExp = kb.nextLine();
                    pcList.add(new payingCustomer(cusName, cusEmail,mag,name,bNamOrCNum,accNumOrExp));
                    System.out.println("\nDone, here's the overview of the account.");
                    System.out.println(pcList.get(pcList.size()-1).toString());
                    paymentAnsCheck = false;
                    break;
                case "other" :
                    System.out.println("\nPlease enter the email of paying customer:");
                    String paidBy = paidByValidation();
                    acList.add(new associateCustomer(cusName,cusEmail,mag,paidBy));
                    addAssociateCusToPayingCus(cusEmail, paidBy);
                    System.out.println("\nDone, here's the overview of the account.");
                    System.out.println(acList.get(acList.size()-1).toString());
                    paymentAnsCheck = false;
                    break;
                
                
                default:
                    System.out.println("\n please enter only paying or other.");
                    paymentAns = kb.nextLine().toLowerCase();
            }
        }
    }
    
    // DeleteCustomer method is used for delete customer from the database,
    // find the match of user prompted email from the Ac and Pc list,
    // once found and show the details of the email entered for double
    // confirming, once confirm will remove the profile.
    public void deleteCustomer()throws Exception{
        boolean isValidEmail = true;
        boolean ansCheck = true;
        boolean isItAc = true;
        int pos = 0;
        System.out.println("\nPlease enter the email you wish to delete:");
        
        String delEmail = kb.nextLine();

        // Validation check
        while (isValidEmail){
            for(int i =0;i<acList.size();i++){
                if(acList.get(i).getEmail().equalsIgnoreCase(delEmail)){
                    pos = i;
                    System.out.println(acList.get(pos));
                    System.out.println("\nIs this the profile you wanted to detele?");
                    isItAc = true;
                    isValidEmail = false;
                }
            }
        
            for(int i=0;i<pcList.size();i++){
                if(pcList.get(i).getEmail().equalsIgnoreCase(delEmail)){
                    pos = i;
                    System.out.println(pcList.get(pos));
                    System.out.println("\nIs this the profile you wanted to detele?");
                    isItAc = false;
                    isValidEmail = false;
                }
            }
            
            if(pos == 0){
                System.out.println("Please enter valid email.");
                delEmail = kb.nextLine();
            }
        }    
            
        
        System.out.println("Please enter Yes / No :");
        String ans = kb.nextLine().toLowerCase();
        
        // Validation check
        while(ansCheck){
            switch(ans){
                case "yes":
                    if(isItAc == true){
                        acList.remove(pos);
                        for(int i=0;i<pcList.size();i++){
                            pcList.get(i).removeAssociateCustomer(acList, delEmail);
                            System.out.println("Successfully removed.");
                        }
                    } else {
                        for(int i=0;i<acList.size();i++){
                            if(acList.get(i).getPaidBy().equalsIgnoreCase(pcList.get(pos).getEmail())){
                                acList.get(i).removePaidBy();
                                System.out.println("Successfully removed.");
                            }
                        }
                        pcList.remove(pos);
                    }
                    ansCheck = false;
                    break;
                case "no":
                    System.out.println("Exiting ...");
                    ansCheck = false;
                    break;
                default:    
                    System.out.println("Please enter only yes or no.");
                    ans = kb.nextLine().toLowerCase();
            }
        }      
    }
}
