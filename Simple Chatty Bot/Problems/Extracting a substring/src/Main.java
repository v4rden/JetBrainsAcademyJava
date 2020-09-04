import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var st = scan.next();
        var f = scan.nextInt();
        var s = scan.nextInt();
        var result = st + f + s;
        System.out.print(result.substring(f, s + 1));
    }
}