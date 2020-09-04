import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var a = scan.nextInt();
        var b = scan.nextInt();
        var c = scan.nextInt();

        var ok = a > 0 && b > 0 && c > 0;

        var f = a + b > c;
        var s = a + c > b;
        var t = b + c > a;

        var res = "NO";

        if (ok && (f && s && t)){
            res = "YES";
        }

        System.out.print(res);
        //System.out.print(f + " " + s + " " + t);
    }
}