import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var n = scan.nextInt();
        var arr = new String[n][n];
        int middle = n / 2 + 1;

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                arr[i][j] = ".";

                if (i == middle - 1) {
                    arr[i][j] = "*";      // - line
                }
            }
            arr[i][i] = "*";              //   \ diagonal
            arr[i][n - 1 - i] = "*";      //   / diagonal
            arr[i][middle - 1] = "*";     //   | line
        }

        for (var i = 0; i < n; i++) {

            System.out.println(String.join(" ", arr[i]));
        }
    }
}