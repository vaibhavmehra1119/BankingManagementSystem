import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class NewUserRegistration {
    void addNewUser(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of user which you want to register:");
        sc.nextLine();
        String name = sc.nextLine();
        if(name.equals("")){
            System.out.println("Name is invalid, Try Again");
            addNewUser();
        }
        System.out.print("Enter date of birth of the user: ");
        String dob=sc.nextLine();
        System.out.println("Enter address of the user: ");
        String address= sc.nextLine();
        Random random= new Random();
        HashSet<Integer> set= new HashSet<>();
        int user_id= random.nextInt(10000000);

        while(set.contains(user_id)==true){
            user_id=random.nextInt(10000000);
        }
        set.add(user_id);
        System.out.println("Your user id is: "+user_id);
        System.out.print("Set Password: ");
        String password=sc.nextLine();
        Customer c = new Customer(name,dob,user_id,address,password);
        String d = LocalDate.now().toString();
        Date date=Date.valueOf(d);
        Transaction transaction= new Transaction("null",user_id,0,0,date);
        boolean flag= CustomerDao.insertData(c,transaction);
        if(flag){

            System.out.println("Successfully Registered");
        }
        else{
            System.out.println("OOPS! Some Error Occurred while adding, Try Again ");
        }
    }
}
