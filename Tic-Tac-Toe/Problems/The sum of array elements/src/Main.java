import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var size = scan.nextInt();
        var sum = 0;

        for (var i = 0; i < size; i++) {
            var n = scan.nextInt();
            sum += n;
        }

        System.out.print(sum);
    }
}