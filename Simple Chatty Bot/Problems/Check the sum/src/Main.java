import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var x1 = scanner.nextInt();
        var x2 = scanner.nextInt();
        var x3 = scanner.nextInt();

        var r1 = (x1 + x2) == 20;
        var r2 = (x1 + x3) == 20;
        var r3 = (x3 + x2) == 20;

        System.out.print(r1 || r2 || r3);
    }
}