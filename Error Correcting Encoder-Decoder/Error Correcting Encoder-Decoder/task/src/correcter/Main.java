package correcter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var input = scan.nextLine();
        System.out.println(simulateErrors(input));
    }

    public static String simulateErrors(String string) {
        var arr = string.toCharArray();
        var random = new Random();
        var blocks = arr.length / 3;
        var left = 0;
        var right = 2;
        for (var i = 0; i < blocks; i++) {
            var rIndex = random.nextInt(right - left + 1) + left;
            var rChar = random.nextInt(122 - 48 + 1) + 48;
            arr[rIndex] = (char) rChar;
            left += 3;
            right += 3;
        }
        var result = new String(arr);
        return result;
    }
}
