import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var s = scan.next();
        var n = scan.nextInt();
        var res = new StringBuilder(s);
        if (res.length() >= n) {
            res.append(res.substring(0, n));
            res.replace(0, n, "");
        }
        System.out.println(res.toString());
    }
}