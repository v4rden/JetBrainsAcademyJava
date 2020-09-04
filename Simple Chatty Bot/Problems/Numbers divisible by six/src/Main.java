import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var res = 0;
        var lenght = scan.nextInt();

        for (var i = 0; i < lenght; i++) {
            var d = scan.nextInt();
            if (d % 6 == 0) {
                res += d;
            }
        }

        System.out.print(res);
    }
}