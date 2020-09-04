import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var d = scanner.nextInt();
        System.out.print(d < 10 && d > 0);
    }
}