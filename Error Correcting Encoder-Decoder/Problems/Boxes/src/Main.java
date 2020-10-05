import java.util.*;

public class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var arr = new int[6];
        for (var i = 0; i < 6; i++) {
            arr[i] = scan.nextInt();
        }

        if (
                (arr[0] < arr[3] && arr[1] < arr[4] && arr[2] < arr[5]) ||
                        (arr[0] < arr[5] && arr[1] < arr[4] && arr[2] < arr[3])
        ) {
            System.out.println("Box 1 < Box 2");
            return;
        }

        if (
                (arr[0] > arr[3] && arr[1] > arr[4] && arr[2] > arr[5]) ||
                        (arr[0] > arr[5] && arr[1] > arr[4] && arr[2] > arr[3])
        ) {
            System.out.println("Box 1 > Box 2");
            return;
        }

        System.out.println("Incompatible");
    }
}