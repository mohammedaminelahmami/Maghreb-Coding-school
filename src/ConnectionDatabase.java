import java.sql.*;

public class ConnectionDatabase {
    final String url = "jdbc:mysql://localhost:3306/magcoding";
    final String username = "root";
    final String password = "";
    protected Connection conn;

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

/*
    1 ) - PreparedStatement stmt = con.prepareStatement();
    2 ) - stmt.executeQuery()
    3 ) - update : (int) | stmt.UpdateQuery() => 0 - 1
    4 ) - setString(---) | setInt(---)
 */