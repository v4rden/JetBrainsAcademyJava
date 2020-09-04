import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var res = "NO";
        var x1 = scan.nextInt();
        var y1 = scan.nextInt();
        var x2 = scan.nextInt();
        var y2 = scan.nextInt();

        var str81 = (x1 == x2) || (x1 == y2);
        var str82 = (y1 == x2) || (y1 == y2);

        var dia = (x1 - x2) == (y1 - y2);

        if (str81 || str82 || dia) {
            res = "YES";
        }
        System.out.println(res);
    }
}