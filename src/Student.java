import java.sql.*;
import java.util.ArrayList;

public class Student extends ConnectionDatabase {

    public String id;
    ArrayList<String> arrVide = new ArrayList<>();

    public Student()
    {
        //
    }
    public ArrayList<String> getStudentNameStatus0()
    {
        try{
            PreparedStatement stmt = conn.prepareStatement("select fullName from apprenant where status = 0");
            ResultSet rs = stmt.executeQuery();

            ArrayList<String> arr = new ArrayList<>();
            while (rs.next())
            {
                for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                {
                    arr.add(rs.getString(i+1));
                }
            }
            return arr;

        }catch (Exception e)
        {
            System.out.println("error => "+e);
            return arrVide;
        }
    }
    public ArrayList<String> getAllStudentsName(int idP)
    {
        try{
            PreparedStatement stmt = conn.prepareStatement("select fullName from apprenant where idP = ? ");
            stmt.setInt(1, idP);
            ResultSet rs = stmt.executeQuery();

            ArrayList<String> arr = new ArrayList<>();
            while (rs.next())
            {
                for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                {
                    arr.add(rs.getString(i+1));
                }
            }
            return arr;

        }catch (Exception e)
        {
            System.out.println("error => "+e);
            return arrVide;
        }
    }

    public String getIdStudent(String fullName)
    {
        try{
            this.stmt = this.conn.prepareStatement("select id from apprenant where fullName = ?");
            stmt.setString(1, fullName);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                this.id = rs.getString("id");
            }
            return id;
        }catch(Exception e)
        {
            System.out.println("error => "+e);
            return "0";
        }
    }

}