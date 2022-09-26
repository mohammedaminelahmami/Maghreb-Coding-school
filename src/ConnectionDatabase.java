import java.sql.*;

public class ConnectionDatabase {
    final String url = "jdbc:mysql://localhost:3306/magcoding";
    final String username = "root";
    final String password = "";
    protected Connection conn;
    protected PreparedStatement stmt;

    public ConnectionDatabase()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, username, password);
            // System.out.println("conn true");
        }catch(Exception e)
        {
            System.out.println("error => " + e);
        }
    }
}