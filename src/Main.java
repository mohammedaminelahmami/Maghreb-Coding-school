import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("######| Login |######\n");
        System.out.println("1 ) - Admin");
        System.out.println("2 ) - Former");
        System.out.println("3 ) - Student");

        Scanner s1 = new Scanner(System.in);
        System.out.print("|--> ");
        int choix = s1.nextInt();
        Menu menu = new Menu(choix, s1);
    }
}