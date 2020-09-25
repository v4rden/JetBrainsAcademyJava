import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var length = scanner.nextDouble();
        var time = scanner.nextDouble();
        System.out.println(length / time);
    }
}