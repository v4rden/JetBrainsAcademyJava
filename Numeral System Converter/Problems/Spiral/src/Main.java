import java.util.Scanner;

class Main {
    public static int[][] arr;
    public static int seed = 0;
    public static int side = 0;

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        side = scan.nextInt();
        arr = new int[side][side];
        var x = 0;
        var y = 0;
        var tx = side - 1;
        var ty = side - 1;

        while (x <= tx & y <= ty) {
            printLeft(x, y, ty);
            printDown(ty, x + 1, tx);
            printRight(tx, ty - 1, y);
            printUp(y, tx - 1, x + 1);
            x++;
            y++;
            tx--;
            ty--;
        }
        printOutArray();
    }

    public static void printLeft(int row, int from, int to) {
        for (var i = from; i <= to; i++) {
            arr[row][i] = getNext();
        }
    }

    public static void printDown(int column, int from, int to) {
        for (var i = from; i <= to; i++) {
            arr[i][column] = getNext();
        }
    }

    public static void printRight(int row, int from, int to) {
        for (var i = from; i >= to; i--) {
            arr[row][i] = getNext();
        }
    }

    public static void printUp(int column, int from, int to) {
        for (var i = from; i >= to; i--) {
            arr[i][column] = getNext();
        }
    }

    public static int getNext() {
        seed++;
        return seed;
    }

    public static void printOutArray() {
        for (int i = 0; i < side; i++) {
            var sb = new StringBuilder((Integer.toString(arr[i][0])));
            for (int j = 1; j < side; j++) {
                sb.append(" ");
                sb.append(arr[i][j]);
            }
            System.out.println(sb.toString());
        }
    }


}