import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var x = scanner.nextDouble();
        var result = (x * x * x) + (x * x) + x + 1;
        System.out.println(result);
    }
}