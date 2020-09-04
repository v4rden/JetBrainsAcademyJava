import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var a = scan.nextInt();
        var b = scan.nextInt();
        var res = 0;

        for (; a <= b; a++) {
            res += a;
        }

        System.out.print(res);
    }
}