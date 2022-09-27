import java.sql.ResultSet;
import java.util.ArrayList;

public class Admin extends ConnectionDatabase{
    private String username;
    private String password;
    private String email;
    protected ArrayList<String> arr = new ArrayList<String>();
    protected String[][] arr2;
    public Admin()
    {
        //
    }

    public boolean createAccount(String table, String fullName, String username, String password)
    {
        try{
            this.stmt = this.conn.prepareStatement("insert into "+table+" (fullName, username, password) values (?, ?, ?)");
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

    public String[][] selectAllAccounts(String table)
    {
        try{
            this.stmt = this.conn.prepareStatement("select * from " + table);
            ResultSet rs = stmt.executeQuery();
            int i = 0;
            while(rs.next())
            {
                for(int j = 1; j < rs.getMetaData().getColumnCount(); j++)
                {
                    arr2[j][i] = new 
                }
                i++;
            }
            rs.close();
            return arr2;
        }catch (Exception e)
        {
            System.out.println("error => " + e);
            return arr2;
        }
    }

    public ArrayList<String> selectOneAccount(String table, int id)
    {
        try{
            this.stmt = this.conn.prepareStatement("select * from " + table + " where id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            // next() - 1 - 2 - 3 - 4 - 5

            while(rs.next())
            {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    arr.add(rs.getString(i));
                }
            }
            return arr;
        }catch (Exception e)
        {
            System.out.println("error => " + e);
            return arr;
        }
    }

    public boolean updateAccount(String table, String fullName, String username, String password)
    {
        try {
            this.stmt = this.conn.prepareStatement("update "+ table +" set fullName = ?, username = ?, password = ?");
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

    public boolean deleteAccount(String table, int id)
    {
        try {
            this.stmt = this.conn.prepareStatement("delete from "+ table +" where id = ?");
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
