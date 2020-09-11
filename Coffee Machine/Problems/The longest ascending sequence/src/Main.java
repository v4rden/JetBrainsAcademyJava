import java.util.*;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var size = scan.nextInt();
        var arr = new int[size];

        for (var i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }

        var current = arr[0];
        var counter = 1;
        for (var i : arr) {
            if (i > current) {
                counter++;
                current = i;
            }
        }
        System.out.println(counter);
    }
}