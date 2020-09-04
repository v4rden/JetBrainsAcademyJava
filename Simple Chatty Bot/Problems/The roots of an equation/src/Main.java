import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var a = scan.nextInt();
        var b = scan.nextInt();
        var c = scan.nextInt();
        var d = scan.nextInt();

        for (var i = 1; i < 1001; i++) {
            if (getResult(a, b, c, d, i) == 0) {
                System.out.println(i);
            }
        }
    }

    public static int getResult(int a, int b, int c, int d, int x) {
        return a * x * x * x + b * x * x + c * x + d;
    }
}