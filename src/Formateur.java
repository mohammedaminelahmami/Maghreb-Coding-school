import java.sql.*;
import java.util.ArrayList;

public class Formateur extends ConnectionDatabase {
    private String username;
    private String fullName;
    private String password;

    public Formateur()
    {
        //
    }

    public boolean asignStudentToPromo(int idP, int id)
    {
        try{
            this.stmt = this.conn.prepareStatement("update apprenant set idP = ?, status = 1 where id = ?");
            stmt.setInt(1, idP);
            stmt.setInt(2, id);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println("error => " + e);
            return false;
        }
    }

    public boolean addBrief(String context, int deadline, int idP)
    {
        try{
            this.stmt = this.conn.prepareStatement("insert into brief (context, deadline, idP) values (?, ?, ?)");
            stmt.setString(1, context);
            stmt.setInt(2, deadline);
            stmt.setInt(3, idP);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println("error => " + e);
            return false;
        }
    }

    public String getFormerId(String formerName)
    {
        try{
            this.stmt = this.conn.prepareStatement("select id from formateur where fullName = ?");
            stmt.setString(1, formerName);
            ResultSet rs = stmt.executeQuery();
            String id = "init";
            while(rs.next())
            {
                id = rs.getString(1);
            }
            return id;
        }catch(Exception e)
        {
            System.out.println("error => "+e);
            return "0";
        }
    }
    //moa9at
    public String getFormerIdd(String formerName)
    {
        try{
            this.stmt = this.conn.prepareStatement("select id from formateur where username = ?");
            stmt.setString(1, formerName);
            ResultSet rs = stmt.executeQuery();
            String id = "init";
            while(rs.next())
            {
                id = rs.getString(1);
            }
            return id;
        }catch(Exception e)
        {
            System.out.println("error => "+e);
            return "0";
        }
    }



}