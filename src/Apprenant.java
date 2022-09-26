import java.sql.*;

public class Apprenant extends ConnectionDatabase {

    private String fullName;
    private String username;
    private String password;

    public Apprenant()
    {
        try{
            PreparedStatement stmt = conn.prepareStatement("select * from formateur");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                System.out.println(rs.getString("fullName"));
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

}