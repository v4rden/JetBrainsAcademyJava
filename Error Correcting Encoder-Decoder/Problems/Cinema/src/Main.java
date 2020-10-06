import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var row = scan.nextInt();
        var column = scan.nextInt();
        var arr = new int[row][column];
        var canBuy = 0;

        for (var i = 0; i < row; i++) {
            for (var j = 0; j < column; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        var k = scan.nextInt();

        for (var i = 0; i < row; i++) {
            var count = 0;
            for (var j = 0; j < column; j++) {
                if (arr[i][j] == 0) {
                    count++;
                } else {
                    count = 0;
                }

                if (count >= k && canBuy == 0) {
                    canBuy = i + 1;
                }
            }
        }

        System.out.println(canBuy);
    }
}