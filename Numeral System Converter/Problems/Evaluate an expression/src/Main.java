import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var a = scanner.nextDouble();
        var b = scanner.nextDouble();
        var c = scanner.nextDouble();
        var d = scanner.nextDouble();

        var result = a * 10.5 + b * 4.4 + (c + d) / 2.2;

        System.out.println(result);
    }
}