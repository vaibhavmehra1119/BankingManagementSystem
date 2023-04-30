import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class ManageAccounts extends NewUserRegistration{

    void deleteUser(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the user id which you want to delete: ");
        int user= sc.nextInt();
        boolean flag = CustomerDao.deleteData(user);
        if(flag){
            System.out.println("User Deleted Sucessfully.");
        }
        else
            System.out.println("OOPS! Some Error Occurred while deleting, Try Again ");
    }
    void modifyUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the user id for which you want to edit details: ");
        int user = sc.nextInt();
        System.out.println("Your Current Details are: ");
        CustomerDao.displayData(user);
        System.out.println("Enter what you want to update");
    }
}
