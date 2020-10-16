import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var size = scan.nextInt();
        var arr = new int[size];
        var result = false;
        for (var i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        var a = scan.nextInt();
        var b = scan.nextInt();

        for (var i = 0; i < size; i++) {
            if (arr[i] == a) {
                if (i > 0) {
                    if (arr[i - 1] == b)
                        result = true;
                }
                if (i + 1 < size) {
                    if (arr[i + 1] == b)
                        result = true;
                }
            }
        }
        System.out.println(!result);
    }
}