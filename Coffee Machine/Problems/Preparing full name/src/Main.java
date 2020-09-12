import java.util.Scanner;

public class Main {

    public static String prepareFullName(String firstName, String lastName) {
        StringBuilder full = new StringBuilder();
        if(firstName != null){
            full.append(firstName);
        }
        if(firstName != null && lastName != null){
            full.append(" ");
        }
        if(lastName != null){
            full.append(lastName);
        }
        return full.toString();
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        firstName = "null".equals(firstName) ? null : firstName;

        String lastName = scanner.nextLine();
        lastName = "null".equals(lastName) ? null : lastName;

        System.out.println(prepareFullName(firstName, lastName));
    }
}