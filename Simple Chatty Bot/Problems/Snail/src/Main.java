import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var height = scanner.nextInt();
        var upLength = scanner.nextInt();
        var downLength = scanner.nextInt();

        var days = 0;
        var pos = 0;

        while (pos < height) {
            days++;
            pos += upLength;
            if (pos >= height) {
                break;
            }

            pos -= downLength;
        }

        System.out.print(days);
    }
}