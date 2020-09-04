import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var sum = 0;
        var n = scan.nextInt();

        while (true) {

            if (n == 0) {
                System.out.print(sum);
                break;
            }

            sum += n;

            if (sum >= 1000) {
                sum -= 1000;
                System.out.print(sum);
                break;
            }

            n = scan.nextInt();
        }
    }
}