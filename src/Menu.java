import java.util.Scanner;

public class Menu {
    public Menu(int choix, Scanner s1)
    {
        System.out.println("########| Login |########");
        System.out.print("Enter username : |--> ");
        String username = s1.next();
        System.out.print("Enter password : |--> ");
        String password = s1.next();

        Connect connect = new Connect();

        switch (choix)
        {
            case 1:
            {
                if(connect.login(username, password, "admin"))
                {
                    System.out.println("-------------| Welcome " + username + " |-------------");
                    System.out.println("1 ) - Create a Former account");
                    System.out.println("2 ) - Create a Student account");
                    System.out.println("3 ) - Create a Promo"); // if formateur = 0 back;
                    System.out.println("4 ) - All Formers");
                    System.out.println("5 ) - All Students");
                    System.out.println("6 ) - Logout");
                }else{
                    System.out.println("sir fhalek");
                }
                break;
            }
            case 2:
            {
                if(connect.login(username, password, "formateur"))
                {
                    System.out.println("-------------| Welcome " + username + " |-------------");
                    System.out.println("1 ) - Add Student to Promo");
                    System.out.println("2 ) - Create a Brief");
                    System.out.println("3 ) - Create a Promo"); // if formateur = 0 back;
                    System.out.println("4 ) - List of students promo"); // if formateur = 0 back;
                    System.out.println("5 ) - Logout");
                }else{
                    System.out.println("sir fhalek");
                }
                break;
            }
            case 3:
            {
                if(connect.login(username, password, "apprenant"))
                {
                    System.out.println("-------------| Welcome " + username + " |-------------");
                    System.out.println("1 ) - Briefs");
                    System.out.println("5 ) - Logout");
                }else{
                    System.out.println("sir fhalek");
                }
                break;
            }
            default:
            {
                System.out.println("taaa wech nta mrid la ?");
                break;
            }
        }
    }
}
