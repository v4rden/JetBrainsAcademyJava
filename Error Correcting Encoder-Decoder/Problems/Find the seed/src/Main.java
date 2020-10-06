import java.util.*;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var a = scanner.nextInt();
        var b = scanner.nextInt();
        var n = scanner.nextInt();
        var k = scanner.nextInt();

        var arr = new int[b - a + 1];
        for (var i = a; i <= b; i++) {
            var random = new Random(i);
            for (var j = 0; j < n; j++) {
                var r = random.nextInt(k);
                arr[i - a] = Math.max(arr[i - a], r);
            }
        }

        var max = arr[0];
        var seed = 0;
        for (var i = a; i <= b; i++) {
            if (arr[i - a] < max) {
                max = arr[i - a];
                seed = i;
            }
        }

        System.out.println(seed);
        System.out.println(max);
    }
}