import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Menu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    // Validate Login information customer number and pin number 

    public void getLogin() throws IOException{
        int x = 1;

        do{
            try{
                /*
				 * Accounts in HashMap, key = customer number, value = pin number
				 */

                data.put(12345, 9999);
                data.put(1234567, 7777);

                System.out.println("Welcome to the ATM");

                System.out.print("Enter your customer Number : ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your Pin Number : ");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e){
                System.out.println("Invalid Characters. Enter only numbers\n");
                x = 2;
            }
            for(Entry<Integer, Integer> entry : data.entrySet()){
                if(entry.getKey() == getCustomerNumber() && entry.getValue()== getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("Wrong Customer Number or Pin Number\n");
            } while (x==1);
        }

        // Account Menu selection

        int choice;

        public void getAccountType(){
            System.out.println("Select the Account : ");
            System.out.println("Type 1 - Current Account");
            System.out.println("Type 2 - Saving Account");
            System.out.println("Type 3 - Quit");
            System.out.print("Enter your Choice : ");

            choice = menuInput.nextInt();

            // switch case

            switch (choice){
                case 1:{
                    getCurrent();
                    break;
                }
                case 2:{
                    getSaving();
                    break;
                }
                case 3:{
                    System.out.println("Thank you for using ATM");
                    break;
                }
                default:{
                    System.out.println("Invalid Choice");
                    getAccountType();
                }
            }
                
        }

            // Display Current Account Menu

        public void getCurrent(){
            System.out.println("Current Account : ");
            System.out.println("Type 1 - View Balance");
            System.out.println("Type 2 - Withdraw Balance");
            System.out.println("Type 3 - Deposite Balance");
            System.out.println("Type 4 - Quit");
            System.out.print("Enter your Choice : ");

            choice = menuInput.nextInt();

            switch(choice){
                case 1:{
                    System.out.println("Current Account Balance : "+ moneyFormat.format(getCurrentBalance()) + "\n");
                    getAccountType();
                    break;
                }
                case 2:{
                    getCurrentWithdrawInput();
                    getAccountType();
                    break;
                }
                case 3:{
                    getCurrentDepositeInput();
                    getAccountType();
                    break;
                }
                case 4:{
                    System.out.println("Thank you for using this ATM");
                    break;
                }
                default:{
                    System.out.println("Invalid choice\n");
                    getCurrent();
                }
            }
        }
        public void getSaving(){
            System.out.println("Saving Account : ");
            System.out.println("Type 1 - View Balance");
            System.out.println("Type 2 - Withdraw Balance");
            System.out.println("Type 3 - Deposite Balance");
            System.out.println("Type 4 - Transfer Balance");
            System.out.println("Type 5 - Quit");
            System.out.print("Enter your Choice : ");

            choice = menuInput.nextInt();

            switch(choice){
                case 1:{
                    System.out.println("Saving Account Balance : "+ moneyFormat.format(getSavingBalance()) + "\n");
                    getAccountType();
                    break;
                }
                case 2:{
                    getSavingWithdrawInput();
                    getAccountType();
                    break;
                }
                case 3:{
                    getSavingDepositeInput();
                    getAccountType();
                    break;
                }
                case 4:{
                    getSavingTransferInput();
                    getAccountType();
                    break;
                }
                case 5:{
                    System.out.println("Thank you for using this ATM");
                    break;
                }
                default:{
                    System.out.println("Invalid choice\n");
                    getSaving();
                }
            }
    }
}
