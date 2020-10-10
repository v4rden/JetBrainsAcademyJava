import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        if (n % 2 == 0) {
            n++;
        }
        n++;
        System.out.println(n);
    }
}