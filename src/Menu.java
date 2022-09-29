import java.util.ArrayList;
import java.util.Objects;
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
                    // Declaration
                    Admin admin = new Admin();

                    System.out.println("---------------------| Welcome " + username + " |---------------------");
                    System.out.println("1 ) - Create a Former account");
                    System.out.println("2 ) - Create a Student account");
                    System.out.println("3 ) - Create a Promo");
                    System.out.println("4 ) - Assign former to promo");
                    System.out.println("5 ) - Logout");

                    Scanner scanner = new Scanner(System.in);
                    System.out.print("|--> ");
                    String choixAdmin = scanner.nextLine();

                    if(Integer.parseInt(choixAdmin) == 1 || Integer.parseInt(choixAdmin) == 2)
                    {
                        String type = Integer.parseInt(choixAdmin) == 1 ? "Former" : "Student";
                        String table = type.equals("Former") ? "formateur" : "apprenant";

                        System.out.println("Create a "+ type +" account -------- |");
                        System.out.print("fullName : ");
                        String fullNameInput = scanner.nextLine();
                        System.out.print("username : ");
                        String usernameInput = scanner.nextLine();
                        System.out.print("password : ");
                        String passwordInput = scanner.nextLine();
                        scanner.close();

                        admin.createAccount(table, fullNameInput, usernameInput, passwordInput);
                    }else if (Integer.parseInt(choixAdmin) == 3)
                    {
                        System.out.println("Create a Promo -------- |");
                        System.out.println("Promo Name : ");
                        String promoName = scanner.nextLine();

                        admin.createPromo(promoName);
                    }else if (Integer.parseInt(choixAdmin) == 4)
                    {
                        System.out.println("-----------------------------------------------------------");
                        String count = admin.countPromosNot();

                        // --- declaration ---
                            ArrayList<String> checkCountarr = new ArrayList<String>();
                            ArrayList<String> checkCountarr1 = new ArrayList<String>();
                        // -----

                        if(Integer.parseInt(count) != 0 )
                        {
                            String[][] arr = admin.selectAllPromos();

                            for (int i = 0; i < arr.length; i++) {
                                for (int j = 0; j < 1; j++) {
                                    if (arr[i][2].equals("0")) {
                                        // Show All promo names
                                        System.out.println((i + 1) + " ) - " + arr[i][1]);
                                    }
                                    else{
                                        checkCountarr.add(String.valueOf(i+1));
                                    }
                                }
                            }
                            boolean a = false;
                            System.out.println("choose a promo : ");
                            String choixPromo = scanner.nextLine();

                            for(String check : checkCountarr)
                            {
                                if(Objects.equals(check, choixPromo))
                                {
                                    a = false;
                                    break;
                                }else{
                                    a = true;
                                }
                                // System.out.println(check);
                            }
                            System.out.println(a);
                            if(a) {

                                String promo = arr[Integer.parseInt(choixPromo) - 1][1];
                                String idPromo = admin.getPromoId(promo);

                                String[][] arr1 = admin.selectAllAccounts("formateur");

                                for (int i = 0; i < arr1.length; i++) {
                                    for (int j = 0; j < 1; j++) {
                                        if (arr1[i][4].equals("0")) {
                                            // Show All former names (status = 0)
                                            System.out.println((i + 1) + " ) - " + arr1[i][1]);
                                        }else{
                                            checkCountarr1.add(String.valueOf(i + 1));
                                        }
                                    }
                                }
                                boolean b = false;
                                System.out.println("choose formateur to asign it to promo " + promo);
                                String choixFormer = scanner.nextLine();

                                for(String check1 : checkCountarr1)
                                {
                                    if(Objects.equals(check1, choixFormer))
                                    {
                                        b = false;
                                        break;
                                    }else{
                                        b = true;
                                    }
                                    // System.out.println(check1);
                                }
                                if(b) {

                                    String former = arr1[Integer.parseInt(choixFormer) - 1][1];
                                    String idFormer = admin.getFormerId(former);

                                    // assign former to promotion
                                    admin.asignFormerToPromo(Integer.parseInt(idFormer), Integer.parseInt(idPromo));
                                    admin.updateStatusFormer(Integer.parseInt(idFormer));
                                }else{
                                    System.out.println("Pls choose correct number");
                                }
                            }else{
                                System.out.println("Pls choose correct number");
                            }
                        }else{
                            System.out.println("No Promo ...");
                        }
                        System.out.println("-----------------------------------------------------------");
                    }
                }else{
                    System.out.println("sir fhalek");
                }
                break;
            }
            case 2:
            {
                if(connect.login(username, password, "formateur"))
                {
                    // Declaration
                    Formateur former = new Formateur();

                    System.out.println("-------------| Welcome " + username + " |-------------");
                    System.out.println("1 ) - Add Student to Promo");
                    System.out.println("2 ) - Create a Brief");
                    System.out.println("3 ) - List of students promo");
                    System.out.println("4 ) - Logout");

                    System.out.println();

                }else{
                    System.out.println("sir fhalek");
                }
                break;
            }
            case 3:
            {
                if(connect.login(username, password, "apprenant"))
                {
                    // Declaration
                    Student apprenant = new Student();

                    System.out.println("-------------| Welcome " + username + " |-------------");
                    System.out.println("1 ) - Briefs");
                    System.out.println("2 ) - Logout");



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
