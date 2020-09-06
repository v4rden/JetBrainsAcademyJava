import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var side = scan.nextInt();
        var arr = new int[side][side];

        for (var i = 0; i < side; i++) {
            for (var j = 0; j < side; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        var isSymmetric = "YES";

        for (var start = 0; start < side; start++) {
            for (var i = start; i < side; i++) {
                if (arr[start][i] != arr[i][start]) {
                    isSymmetric = "NO";
                    break;
                }
            }
        }

        System.out.print(isSymmetric);
    }
}