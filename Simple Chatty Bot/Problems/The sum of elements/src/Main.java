import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var n = scan.nextInt();

        var sum = 0;
        while (n != 0) {
            sum += n;
            n = scan.nextInt();
        }
        System.out.print(sum);
    }
}