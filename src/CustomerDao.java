import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDao {
    public static boolean insertData(Customer c,Transaction transaction){
        boolean flag =false;
        try{
            Connection con = ConnectionProvider.createC();
            String q= "insert into customer (user_id,name,dob,address,password) values (?,?,?,?,?)";
            String t="insert into transaction (user_id,Transaction_type,Amount,Date,Balance) values(?,?,?,?,?)";

            PreparedStatement preparedStatement= con.prepareStatement(q);
            preparedStatement.setInt(1,c.getUser_id());
            preparedStatement.setString(2,c.getName());
            preparedStatement.setString(3,c.getDob());
            preparedStatement.setString(4,c.getAddress());
            preparedStatement.setString(5,c.getPassword());
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1=con.prepareStatement(t);
            preparedStatement1.setInt(1,transaction.getUser_id());
            preparedStatement1.setString(2,transaction.getTransaction_type());
            preparedStatement1.setInt(3,transaction.getAmount());
            preparedStatement1.setDate(4,transaction.getDate());
            preparedStatement1.setInt(5,transaction.getBalance());
            preparedStatement1.executeUpdate();
            flag=true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return flag;
    }
    public static boolean deleteData(int userid){
        boolean flag=false;
        try{
            Connection con=ConnectionProvider.createC();
            String q="delete from transaction where user_id="+userid;
            PreparedStatement preparedStatement= con.prepareStatement(q);
            preparedStatement.executeUpdate();
            q="delete from customer where user_id="+userid;
            preparedStatement=con.prepareStatement(q);
            preparedStatement.executeUpdate();
            flag=true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return flag;
    }
    public static boolean modifyData(int user){
        boolean flag=false;
        try{
            Connection con=ConnectionProvider.createC();
            String q="update customer where id="+user;
            PreparedStatement preparedStatement= con.prepareStatement(q);
            preparedStatement.executeUpdate();
            flag=true;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return flag;
    }
    public static void displayData(int user){
        try{
            Connection con=ConnectionProvider.createC();
            String q = "select name,dob,address from customer where user_id="+user;
            PreparedStatement preparedStatement= con.prepareStatement(q);
            ResultSet resultSet=preparedStatement.executeQuery(q);
            while (resultSet.next()){
                System.out.println("ID: "+user);
                System.out.println("Name: "+resultSet.getString("name"));
                System.out.println("Dob: "+resultSet.getString("dob"));
                System.out.println("Address: "+resultSet.getString("address"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
