import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var size = scan.nextInt();
        var miser = Integer.MAX_VALUE;

        for (var i = 0; i < size; i++) {
            var n = scan.nextInt();
            if (n < miser) {
                miser = n;
            }
        }
        System.out.print(miser);
    }
}