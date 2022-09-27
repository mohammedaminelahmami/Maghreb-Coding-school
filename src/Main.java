import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        //admin.createAccount("formateur", "Youness Echchadi", "youness", "passYouness");
        ArrayList<String> arr = admin.selectAllAccounts("formateur");
        System.out.println(arr.toString());

        //admin.updateAccount("formateur", "Youness Echchadi", "youness", "passYouness");

    }
}