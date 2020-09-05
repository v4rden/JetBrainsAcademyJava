import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var iInput = scan.nextInt();
        var jInput = scan.nextInt();
        var arr = new int[iInput][jInput];

        for (var i = 0; i < iInput; i++) {
            for (var j = 0; j < jInput; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        var iSwap = scan.nextInt();
        var jSwap = scan.nextInt();

        for (var a = 0; a < iInput; a++) {
            var buff = arr[a][iSwap];
            arr[a][iSwap] = arr[a][jSwap];
            arr[a][jSwap] = buff;
        }

        for (var i = 0; i < iInput; i++) {
            StringBuilder sb = new StringBuilder();
            for (var j = 0; j < jInput; j++) {
                sb.append(arr[i][j]);
                if (j != jInput - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}