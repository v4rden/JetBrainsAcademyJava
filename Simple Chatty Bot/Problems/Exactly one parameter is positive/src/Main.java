import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var x1 = scanner.nextInt();
        var x2 = scanner.nextInt();
        var x3 = scanner.nextInt();

        var p1 = x1 > 0;
        var p2 = x2 > 0;
        var p3 = x3 > 0;

        var allTrue = p1 && p2 && p3;
        var allFalse = !p1 && !p2 && !p3;

        var inter = p1 ^ p2 ^ p3;

        System.out.print(!(allTrue || allFalse) && inter);
    }
}