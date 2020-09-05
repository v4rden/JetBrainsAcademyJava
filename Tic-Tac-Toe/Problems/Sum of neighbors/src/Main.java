import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        Queue<String> q = new LinkedList<>();

        while (scan.hasNextLine()
        ) {
            var read = scan.nextLine();
            if (read.indexOf("end") == -1) {
                q.add(read);
            }
        }

        var rows = q.size();
        var columns =
                q.peek().length()
                        - q.peek().replace(" ", "").length()
                        + 1;

        var inputArr = new int[rows][columns];

        for (var i = 0; i < rows; i++) {
            var line = q.remove();
            var a = line.split(" ");
            for (var j = 0; j < columns; j++) {
                inputArr[i][j] = Integer.parseInt(a[j]);
            }
        }

        var resultArr = new int[rows][columns];
        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < columns; j++) {
                var left = inputArr[i][getLeft(j, columns)];
                var right = inputArr[i][getRight(j, columns)];
                var up = inputArr[getLeft(i, rows)][j];
                var down = inputArr[getRight(i, rows)][j];

                resultArr[i][j] = left + right + up + down;
            }
        }

        printArray(resultArr, rows, columns);
    }

    public static int getLeft(int n, int side) {
        return (n - 1 + side) % side;
    }

    public static int getRight(int n, int side) {
        return (n + 1 + side) % side;
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