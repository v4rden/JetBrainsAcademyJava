import java.util.Scanner;

public class Main {

    public static int sign(int number) {
        if (number > 0) {
            return 1;
        }
        if (number < 0) {
            return -1;
        }
        return number;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        System.out.println(sign(n));
    }
}