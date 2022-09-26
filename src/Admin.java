import java.sql.ResultSet;

public class Admin extends ConnectionDatabase{
    private String username;
    private String password;
    private String email;

    public Admin()
    {
        //
    }

    public boolean createStudent(String fullName, String username, String password)
    {
        try{
            this.stmt = this.conn.prepareStatement("insert into apprenant (fullName, username, password) values (?, ?, ?)");
            stmt.setString(1, fullName);
            stmt.setString(2, username);
            stmt.setString(3, password);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public void selectAllStudents(String label)
    {
        try{
            this.stmt = this.conn.prepareStatement("select * from apprenant");
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                System.out.println(rs.getString(label));
            }
            rs.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void selectOneStudent(String label, int id)
    {
        try{
            this.stmt = this.conn.prepareStatement("select * from apprenant where idApprenant = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                System.out.println(rs.getString(label));
            }
            rs.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public boolean updateStudent(String fullName, String username, String password)
    {
        try {
            this.stmt = this.conn.prepareStatement("update apprenant set fullName = ?, username = ?, password = ?");
            stmt.setString(1, fullName);
            stmt.setString(2, username);
            stmt.setString(3, password);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteStudent(int id)
    {
        try {
            this.stmt = this.conn.prepareStatement("delete from apprenant where idApprenant = ?");
            stmt.setInt(1, id);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}
