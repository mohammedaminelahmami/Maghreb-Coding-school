import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("######| Login |######\n");
        System.out.println("1 ) - Admin");
        System.out.println("2 ) - Student");
        System.out.println("3 ) - Former");

        Scanner s1 = new Scanner(System.in);
        System.out.print("|--> ");
        int choix = s1.nextInt();
        Menu menu = new Menu(choix, s1, "Admin");

    }
}