import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var res = "Normal";
        var scan = new Scanner(System.in);
        var a = scan.nextInt();
        var b = scan.nextInt();
        var sleep = scan.nextInt();

        var less = sleep < a;
        var more = sleep > b;

        if (less) {
            res = "Deficiency";
        }

        if (more) {
            res = "Excess";
        }

        System.out.print(res);
    }
}