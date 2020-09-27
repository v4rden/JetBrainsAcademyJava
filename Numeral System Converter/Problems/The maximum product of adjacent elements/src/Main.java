import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var size = scan.nextInt();
        var arr = new int[size];
        var first = scan.nextInt();
        var max = 0;

        for (var i = 0; i < size - 1; i++) {
            var second = scan.nextInt();
            var product = first * second;

            if (product > max) {
                max = product;
            }
            first = second;
        }

        System.out.println(max);
    }
}