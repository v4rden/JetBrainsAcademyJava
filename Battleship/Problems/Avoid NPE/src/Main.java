import java.util.*;

class FixingNullPointerException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        string = "null".equals(string) ? null : string;
        string = string == null ? "NPE!" : string.toLowerCase();

        System.out.println(string);
    }
}