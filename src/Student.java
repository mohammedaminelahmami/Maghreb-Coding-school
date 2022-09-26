import java.sql.*;

public class Student extends ConnectionDatabase {

    private String fullName;
    private String username;
    private String password;

    public Student()
    {
        try{
            PreparedStatement stmt = conn.prepareStatement("select * from formateur");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                System.out.println(rs);
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

}