import java.util.*;

public class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var n = scan.nextInt();
        var side = n * n;
        var arr = new int[side][side];

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        var result = isSolved(arr, side, n);
        var msg = result ? "YES" : "NO";
        System.out.println(msg);
    }

    public static Boolean isSolved(int[][] arr, int side, int n) {
        for (int i = 0; i < side; i++) {
            var setRows = new HashSet();
            var setColumns = new HashSet();
            for (int j = 0; j < side; j++) {
                if (!setRows.add(arr[i][j])
                        || !setColumns.add(arr[j][i])
                        || arr[i][j] > side
                        || arr[i][j] < 1) {
                    return false;
                }
            }
        }

            for (int iStart = 0; iStart < side; iStart += n) {
                for (int jStart = 0; jStart < side; jStart += n) {
                    var set = new HashSet();
                    for (int i = iStart; i < iStart + n; i++) {
                        for (int j = jStart; j < jStart + n; j++) {
                            if (!set.add(arr[i][j])) {
                                return false;
                            }
                        }
                    }
                }
            }

        return true;
    }
}