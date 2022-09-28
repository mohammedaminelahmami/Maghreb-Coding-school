import java.util.Scanner;

public class Menu {
    public Menu(int choix, Scanner s1, String type)
    {
        switch (choix)
        {
            case 1:
            {
                System.out.println("########| Login "+type+" |########");
                System.out.print("Enter username : |--> ");
                String username = s1.next();
                System.out.print("Enter password : |--> ");
                String password = s1.next();
                System.out.println("########| Welcome " + username + " |########");
                Connect connect = new Connect();

                if(connect.login(username, password, "admin"))
                {
                    System.out.println("marhba bik a moul chi");
                }else{
                    System.out.println("sir fhalek");
                }

                break;
            }
            case 2:
            {
                System.out.println("Student");
                break;
            }
            case 3:
            {
                System.out.println("Former");
                break;
            }
            default:
            {
                System.out.println("Noooo");
                break;
            }
        }
    }
}
