// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var res = "NO";
        var scan = new Scanner(System.in);
        var n = scan.nextInt();
        var m = scan.nextInt();
        var k = scan.nextInt();

        var isEnough = (n * m) >= k;

        var c1 = k % n == 0;
        var c2 = k % m == 0;

        if (isEnough && (c1 || c2)) {
            res = "YES";
        }

        System.out.print(res);
    }
}