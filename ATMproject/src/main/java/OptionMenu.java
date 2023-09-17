
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###, ##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x=1;
        do {
            try {
                data.put(952141, 191904);
                data.put(989947, 71976);

                System.out.println("Welcome to the ATM!");
                System.out.println("Enter your customer number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Emter your PIN number : ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid characters. Only numbers." +"\n");
                x=2;
            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if( data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            }
            else {
                System.out.println("\n" + "Wrong customer number or PIN number " +"\n");
            }
        }while(x == 1);
    }

    public void getAccountType(){
        System.out.println("Select the account you want to access :");
        System.out.println("type 1 - checking account");
        System.out.println("type 2 - saving account ");
        System.out.println("type 3 - exit");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("thank you for using this ATM. " + "\n");
                break;

            default :
                System.out.println("\n"+ "Invalid choice" + "\n");
                getAccountType();

             }
        }

      public double getChecking(){
          System.out.println("Checking Account");
          System.out.println("type 1 - View Balance");
          System.out.println("type 2 - withdraw funds");
          System.out.println("type 3 - deposit funds");
          System.out.println("type 4 - exit");
          System.out.println("Choice : ");

          int selection = menuInput.nextInt();

          switch (selection){
              case 1:
                 System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                 getAccountType();
                 break;

              case 2:
                  getCheckingWithdrawInput();
                  getAccountType();
                  break;

              case 3:
                  getCheckingDepositInput();
                  getAccountType();
                  break;

              case 4:
                  System.out.println("Thank you for using this ATM");
                  break;

              default:
                  System.out.println("\n" + "Invalid choice" +"\n");
                  getChecking();

          }
          return 0;
      }

      public void getSaving(){
          System.out.println("Saving Account : ");
          System.out.println("type 1- view balance");
          System.out.println("type 2 - withdraw funds");
          System.out.println("type 3 - deposit funds");
          System.out.println("type 4 - exit");
          System.out.println("Choice : ");

          int selection = menuInput.nextInt();

          switch (selection){
              case 1:
                  System.out.println("Saving account balance: " + moneyFormat.format(getSavingBalance()9));
                  getAccountType();
                  break;
              case 2:
                  getSavingWithdrawInput();
                  getAccountType();
                  break;

              case 3:
                  getSavingDepositInput();
                  getAccountType();
                  break;

              case 4:
                  System.out.println("thank you for using this ATM");
                  break;

              default:
                  System.out.println("\n" + "invalid choice" + "\n");
                  getChecking();
          }
      }

    }


