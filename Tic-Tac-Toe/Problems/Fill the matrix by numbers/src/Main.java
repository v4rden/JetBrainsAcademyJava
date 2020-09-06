import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var side = scan.nextInt();

        var arr = new int[side][side];

        for (int i = 0; i < side; i++) {
            var toRight = 0;
            var toLeft = 0;

            for (int j = i; j < side; j++) {
                arr[i][j] = toRight;
                toRight++;
            }

            for (int j = i; j > -1; j--) {
                arr[i][j] = toLeft;
                toLeft++;
            }
        }

        printArray(arr, side, side);
    }

    public static void printArray(int[][] arr, int rows, int columns) {
        for (var i = 0; i < rows; i++) {
            StringBuilder sb = new StringBuilder();
            for (var j = 0; j < columns; j++) {
                sb.append(arr[i][j]);
                if (j != columns - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}