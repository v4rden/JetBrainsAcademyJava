import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var range = scan.nextInt();

        var a = 0;
        var b = 0;
        var c = 0;
        var d = 0;

        for (var i = 0; i < range; i++) {
            var dig = scan.nextInt();
            if (dig == 5) {
                a++;
            }
            if (dig == 4) {
                b++;
            }
            if (dig == 3) {
                c++;
            }
            if (dig == 2) {
                d++;
            }
        }

        System.out.print(d + " " + c + " " + b + " " + a);
    }
}