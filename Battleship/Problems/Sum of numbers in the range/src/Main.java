import java.util.Scanner;

public class Main {

    public static long sumInRange(int from, int to) {
        long sum = 0;
        for (var i = from; i < to; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int from = scanner.nextInt();
        int to = scanner.nextInt();

        System.out.println(sumInRange(from, to));
    }
}