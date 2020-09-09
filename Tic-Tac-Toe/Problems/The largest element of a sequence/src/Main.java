import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var n = scan.nextInt();
        var max = 0;
        while (n != 0) {
            max = (max > n) ? max : n;
            n = scan.nextInt();
        }
        System.out.println(max);
    }
}