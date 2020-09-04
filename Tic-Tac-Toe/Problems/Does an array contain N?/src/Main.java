import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var size = scan.nextInt();
        var arr = new int[size];

        for (var i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        var n = scan.nextInt();

        var occurrence = 0;

        for (var i : arr) {
            if (i == n) {
                occurrence++;
            }
        }
        System.out.println(occurrence > 0);
    }
}