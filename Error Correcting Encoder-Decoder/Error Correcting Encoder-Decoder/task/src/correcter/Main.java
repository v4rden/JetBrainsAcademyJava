package correcter;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);

        var input = scan.nextLine();
        System.out.println(input);

        var encoded = encodeTriple(input);
        System.out.println(encoded);

        var errors = simulateErrors(encoded);
        System.out.println(errors);

        var decoded = decode(errors);
        System.out.println(decoded);
    }

    public static String encodeTriple(String msg) {
        var arr = msg.toCharArray();
        var sb = new StringBuilder();

        for (char c : arr) {
            sb.append(c);
            sb.append(c);
            sb.append(c);
        }

        return sb.toString();
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
        return new String(arr);
    }

    public static String decode(String msg) {
        var arr = msg.toCharArray();
        var sb = new StringBuilder();

        var blocks = arr.length / 3;
        var index = 0;
        for (var i = 0; i < blocks; i++) {
            if (arr[index] == arr[index + 1] ||
                    arr[index] == arr[index + 2]
            ) {
                sb.append(arr[index]);
            } else {
                sb.append(arr[index + 1]);
            }
            index += 3;
        }

        for (var i = blocks * 3; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
