import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        long res = 1;
        var a = scan.nextInt();
        var b = scan.nextInt();

        for (; a < b; a++) {
            res *= a;
        }

        System.out.print(res);
    }
}