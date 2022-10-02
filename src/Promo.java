import java.sql.ResultSet;
import java.util.ArrayList;

public class Promo extends ConnectionDatabase{

    public String promoName;

    public Promo()
    {
        //
    }

    public ArrayList<String> getPromo(int id)
    {
        ArrayList<String> arr = new ArrayList<String>();
        try{
            this.stmt = this.conn.prepareStatement("select * from promotion where id = ?");
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

    public String getPromoName(int idF)
    {
        try{
            this.stmt = this.conn.prepareStatement("select name from promotion where idF = ?");
            stmt.setInt(1, idF);
            ResultSet rs = stmt.executeQuery();
            // next() - 1 - 2 - 3 - 4 - 5
            while(rs.next())
            {
                this.promoName = rs.getString("name");
            }
            return promoName;
        }catch (Exception e)
        {
            System.out.println("error => " + e);
            return promoName;
        }
    }
    public String getPromoId(String promoName)
    {
        try{
            this.stmt = this.conn.prepareStatement("select id from promotion where name = ?");
            stmt.setString(1, promoName);
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
