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
        var max = 0;
        var row = 0;
        var column = 0;

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                var input = scan.nextInt();

                if (!init) {
                    init = true;
                    max = input;
                }

                if (max == input) {
                    if (row > i) {
                        setMax(input ,i , j);
                    }
                    if (row == i && column > j) {
                        setMax(input ,i , j);
                    }
                }

                if (max < input) {
                    setMax(input ,i , j);
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
}