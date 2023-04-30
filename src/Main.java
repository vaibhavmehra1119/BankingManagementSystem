import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while(true) {
            System.out.println("Welcome to Banking Management System");
            System.out.println("");
            System.out.println("Press 1 to Register a new user");
            System.out.println("Press 2 to delete a user");
            System.out.println("Press 3 to edit a user details");
            System.out.println("Press 4 to check your balance");
            System.out.println("Press 5 to deposit money");
            System.out.println("Press 6 to withdraw money");
            System.out.println("Press 7 to exit");

            Scanner sc = new Scanner(System.in);
            int input=sc.nextInt();
            ManageAccounts manageAccounts= new ManageAccounts();
            switch (input) {
                case 1:
                    manageAccounts.addNewUser();
                    break;
                case 2:
                    manageAccounts.deleteUser();
                    break;
                case 3:
                    manageAccounts.modifyUser();
                    break;
                case 4:
                    AmountTransaction.checkBalance();
                    break;
                case 5:
                    AmountTransaction.depositAmount();
                    break;
                case 6:
                    AmountTransaction.withdrawAmount();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid Input, Please Try Again");
                    break;
            }
            if(input==7){
                break;
            }
        }
    }
}