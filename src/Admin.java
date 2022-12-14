import java.sql.*;
import java.util.ArrayList;

public class Admin extends ConnectionDatabase{
    private String username;
    private String password;
    private String email;
    protected ArrayList<String> arr = new ArrayList<String>();
    protected String arrayVide[][] = new String[0][0];

    public Admin()
    {
        //
    }

    public boolean createAccount(String table, String fullName, String username, String password, String email)
    {
        try{
            this.stmt = this.conn.prepareStatement("insert into "+table+" (fullName, username, password, status, email) values (?, ?, ?, ?, ?)");
            stmt.setString(1, fullName);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setInt(4, 0);
            stmt.setString(5, email);
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

            int a = getNumberRows(table);
            int b = getNumberColumn(table);

            String[][] arr2 = new String[a][b];

            int i = 0;
            while(rs.next())
            {
                for(int j = 0; j < b; j++)
                {
                    arr2[i][j] = rs.getString(j+1);
                }
                i++;
            }
            rs.close();
            return arr2;
        }catch (Exception e)
        {
            System.out.println("error => " + e);
            return arrayVide;
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
    public boolean createPromo(String name)
    {
        try{
            this.stmt = this.conn.prepareStatement("insert into promotion (name, status) values (?, ?)");
            stmt.setString(1, name);
            stmt.setInt(2, 0);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println("error => " + e);
            return false;
        }
    }

    public boolean asignFormerToPromo(int idF, int idP)
    {
        try{
            this.stmt = this.conn.prepareStatement("update promotion set idF = ?, status = 1 where id = ?");
            stmt.setInt(1, idF);
            stmt.setInt(2, idP);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println("error => " + e);
            return false;
        }
    }
    public boolean updateStatusFormer(int idF)
    {
        try{
            this.stmt = this.conn.prepareStatement("update formateur set status = 1 where id = ?");
            stmt.setInt(1, idF);
            int rs = stmt.executeUpdate();
            return rs == 1;
        }catch(Exception e)
        {
            System.out.println("error => " + e);
            return false;
        }
    }
    public String countPromosNot()
    {
        try{
            this.stmt = this.conn.prepareStatement("select count(*) from promotion where status = 0");
            ResultSet rs = stmt.executeQuery();
            String count = "0";
            while(rs.next())
            {
                count = rs.getString(1);
            }
            return count;
        }catch(Exception e)
        {
            System.out.println("error => " + e);
            return "false";
        }
    }

    public String[][] selectAllPromos()
    {
        try{
            this.stmt = this.conn.prepareStatement("select * from promotion");
            ResultSet rs = stmt.executeQuery();
            int i = 0;

            int a = getNumberRows("promotion");
            int b = getNumberColumn("promotion");

            String[][] arr2 = new String[a][b];

            while(rs.next())
            {
                for(int j = 0; j < b; j++)
                {
                    arr2[i][j] = rs.getString(j+1);
                }
                i++;
            }
            rs.close();
            return arr2;
        }catch (Exception e)
        {
            System.out.println("error => " + e);
            return arrayVide;
        }
    }

    public int getNumberRows(String table){
        try{
            stmt = conn.prepareStatement("select * from " + table,ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            if(rs.last()){
                return rs.getRow();
            } else {
                return 0;
            }
        } catch (Exception e){
            System.out.println(e);

        }
        return 0;
    }
    public int getNumberColumn(String table) {
        try {
            this.stmt = this.conn.prepareStatement("select * from " + table, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData count = rs.getMetaData();
            int numOfCols = count.getColumnCount();
            return numOfCols;

        } catch (Exception e) {
            System.out.println(e);
            return 0;

        }
    }

}