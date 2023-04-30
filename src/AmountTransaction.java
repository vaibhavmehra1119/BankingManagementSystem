import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

public class AmountTransaction {
    static Scanner sc = new Scanner(System.in);
    public static void checkBalance(){
        System.out.print("Enter your user id: ");
        int user_id=sc.nextInt();
        String pass=getPassword(user_id);
        System.out.print("Enter Password: ");
        sc.nextLine();
        String password= sc.nextLine();
        if(password.equals(pass)){
            displayBalance(user_id);
        }
        else{
            System.out.println("Please enter correct password.");
            checkBalance();
        }
    }
    public static void depositAmount(){
        System.out.print("Enter your user id: ");
        int user_id=sc.nextInt();
        String pass=getPassword(user_id);
        System.out.print("Enter Password: ");
        sc.nextLine();
        String password= sc.nextLine();
        if(password.equals(pass)){
            displayBalance(user_id);
        }
        else{
            System.out.println("Please enter correct password.");
            depositAmount();
        }
        int balance=getBalance(user_id);
        System.out.print("Enter the amount to deposit: ");
        int amount= sc.nextInt();
        Connection con= ConnectionProvider.createC();
        int new_balance=amount+balance;
        String d = LocalDate.now().toString();
        Date date=Date.valueOf(d);
        String q ="update transaction set Amount="+amount+",Transaction_type='Deposit',Balance="+new_balance+",Date=? where user_id="+user_id;
        try{
            PreparedStatement pstmt= con.prepareStatement(q);
            pstmt.setDate(1,date);
            pstmt.executeUpdate();

            System.out.println("Successfully deposited in your account.");
            System.out.println("Updated Account Balance is : "+new_balance);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void withdrawAmount(){
        System.out.print("Enter your user id: ");
        int user_id=sc.nextInt();
        String pass=getPassword(user_id);
        System.out.print("Enter Password: ");
        sc.nextLine();
        String password= sc.nextLine();
        if(password.equals(pass)){
            displayBalance(user_id);
        }
        else{
            System.out.println("Please enter correct password.");
            withdrawAmount();
        }
        System.out.print("Enter amount you want to withdraw: ");
        int withdraw= sc.nextInt();
        int balance=getBalance(user_id);
        int new_balance=balance-withdraw;
        if(balance<withdraw){
            System.out.println("Sorry ! The balance is not sufficient to withdraw money");
        }
        else{
            String d = LocalDate.now().toString();
            Date date=Date.valueOf(d);

            String q ="update transaction set Amount="+withdraw+",Transaction_type='Withdraw',Balance="+new_balance+",Date=? where user_id="+user_id;
            try{
                Connection con= ConnectionProvider.createC();
                PreparedStatement pstmt= con.prepareStatement(q);
                pstmt.setDate(1,date);
                pstmt.executeUpdate();

                System.out.println("Successfully Withdrawn from your account.");
                System.out.println("Updated Account Balance is : "+new_balance);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void displayBalance(int user_id){
        int balance=getBalance(user_id);
        System.out.println("Your Balance is : "+balance);
    }
    public static int getBalance(int user_id){
        Connection con=ConnectionProvider.createC();
        String q="select balance from transaction where user_id="+user_id;
        int balance=0;
        try {
            PreparedStatement preparedStatement = con.prepareStatement(q);
            ResultSet resultSet=preparedStatement.executeQuery(q);
            if(resultSet.next())
                balance=resultSet.getInt("Balance");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return balance;
    }
    public static String getPassword(int user_id){
        Connection con=ConnectionProvider.createC();
        String q ="select password from customer where user_id="+user_id;
        String p="";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(q);
            ResultSet resultSet= preparedStatement.executeQuery(q);
            if(resultSet.next()){
                p=resultSet.getString("password");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }
}
