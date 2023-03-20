# Online-Weekly-Magazine-Service
The Online Weekly Magazine Service program helps manage the magazine subscription over the customers, is in charge of the online magazine delivery and sends notifications to the customers in weeks or months. The program has the function of adding new customers, removing existing customers, and showing all other details required.

# User Guide
•	The ICT373_A1 project folder includes the libraries and the source package with nine java files:
o	associateCustomer.java

o	bankAccount.java

o	creditCard.java

o	customer.java

o	magazine.java

o	magazineService.java

o	main.java

o	payingCustomer.java

o	supplement.java

•	The magazineService.java includes most methods, and the main.java runs the program.

•	All the preloaded data is executed from loadData() in main.java

•	To run the program, please open the main.java and click on the run project button  or press F6 to use the program. 

•	The program will prompt a menu and enter a number to execute the feature.

•	The features cover all the required functions of the assignment.

•	The features shown in the menu are:

o	1. Display associate customers list.

o	2. Display paying customer list.

o	3. Display all email notifications for all customers each week.

o	4. Display monthly bill emails for all paying customers.

o	5. Add new customers.

o	6. Remove existing customers.

o	7. Exit the program.

•	To add a customer, the program will request a name, email, list of interests, and payment method.

o	Sample input: Anson, ansontly00@gmail.com, y, 1, 2, 5, other, lisalolisa@gmail.com
 
•	To remove customers, the program will request the email that wanted to be removed.

o	Sample input: lisalolisa@gmail.com, yes

o	Sample input to test validation: (enter any fault email) 

# Algorithm & UML
The system's design is implemented with object-oriented design, which includes planning a method of interacting with many other objects and solving the software structure. In the case of building an online weekly magazine system and following the required requirements, many classes have been created:

•	Magazine class has included the supplement class object.

•	Customer class has inherited to associate customer class and paying customer class.

•	In associate customer class and paying customer class have included the magazine class object.

•	Bank account class and credit card class is created, and their objects are included in paying customer for holding payment method details.

•	Magazine service class created to include the functions for the interaction between customer class and magazine class.

•	Main class is created to include all objects and magazine service class to run the program.

# Limitations
•	Could’ve better implemented adding paying customers; the payment method should have separated the inputs of fund transfer or credit card instead of using one input type. The example is shown below.
 
•	The email validation can be improved as the current version only check the @ symbol but can be entered any incorrect email address.
 
•	No validation checks on entering a payment method.
