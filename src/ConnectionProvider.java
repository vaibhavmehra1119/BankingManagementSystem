import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    static Connection con;
    public static Connection createC() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password="9254";
            String url="jdbc:mysql://localhost:3306/banking_system";
            con= DriverManager.getConnection(url,user,password);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
}
