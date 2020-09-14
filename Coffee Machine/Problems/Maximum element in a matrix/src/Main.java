import java.util.Scanner;

class Main {
    static int max = 0;
    static int row = 0;
    static int column = 0;

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var init = false;
        var m = scan.nextInt();
        var n = scan.nextInt();

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                var input = scan.nextInt();

                if (!init) {
                    init = true;
                    max = input;
                }

                if (isNewMax(input) ||
                        hasSmallerRow(input, i) ||
                        hasSmallerColumn(input, i, j)) {
                    setMax(input, i, j);
                }
            }
        }

        System.out.print(row + " " + column);
    }

    public static void setMax(int input, int i, int j) {
        max = input;
        row = i;
        column = j;
    }

    public static boolean isNewMax(int input) {
        return max < input;
    }

    public static boolean hasSmallerRow(int input, int i) {
        return max == input && row > i;
    }

    public static boolean hasSmallerColumn(int input, int i, int j) {
        return max == input && row == i && column > j;
    }
}