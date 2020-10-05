import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var n = scan.nextInt();
        var m = scan.nextInt();
        var arr = new int[n][m];

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        var rotated = new int[m][n];
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                rotated[i][j] = arr[n - j - 1][i];
            }
        }

        for (var i = 0; i < m; i++) {
            var sb = new StringBuilder();
            sb.append(rotated[i][0]);
            for (var j = 1; j < n; j++) {
                sb.append(" ");
                sb.append(rotated[i][j]);
            }
            System.out.println(sb.toString());
        }
    }
}