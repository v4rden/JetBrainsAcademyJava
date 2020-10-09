import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var a = scan.nextInt();
        var b = scan.nextInt();
        var n = scan.nextInt();

        var result = b / n - a / n;

        if (a % n == 0) {
            result++;
        }

        System.out.println(result);
    }
}