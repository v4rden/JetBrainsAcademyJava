import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var size = scan.nextInt();
        var arr = new int[size];
        var sum = 0;

        for (var i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        var n = scan.nextInt();

        for (var i : arr) {
            if (i > n) {
                sum += i;
            }
        }

        System.out.print(sum);
    }
}