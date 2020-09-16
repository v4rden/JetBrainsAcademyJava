import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var n = scan.nextInt();
        var isWithinInterval =
                (-15 < n && n <= 12) ||
                        (14 < n && n < 17) ||
                        (19 <= n);
        var result = isWithinInterval ? "True" : "False";
        System.out.print(result);
    }
}