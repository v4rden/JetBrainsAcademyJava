import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var first = scanner.nextDouble();
        var second = scanner.nextDouble();

        var result = second - first;
        System.out.println(result);
    }
}