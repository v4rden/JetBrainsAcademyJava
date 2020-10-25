import java.util.Scanner;

public class Main {

    public static long power(int n, int m) {
        long result = 1;
        for (var i = m; i > 0; i--) {
            result *= n;
        }
        return result;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        System.out.println(power(n, m));
    }
}