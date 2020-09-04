import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (var i = 0; i < 4; i++) {
            var x = scanner.nextInt();
            x--;
            System.out.print(x + " ");
        }
    }
}