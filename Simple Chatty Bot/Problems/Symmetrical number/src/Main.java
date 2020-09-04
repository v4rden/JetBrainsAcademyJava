import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var s = scan.next();
        while (s.length() < 4) {
            s = "0" + s;
        }
        //System.out.print(s);
        var a = s.toCharArray();
        var res = 0;
        //var i1 = a[0] == a[3]
        if (a[0] == a[3] && a[2] == a[1]) {
            res = 1;
        }
        System.out.print(res);
    }
}