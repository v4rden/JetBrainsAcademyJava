import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var size = scan.nextInt();
        var arr = new int[size];

        var max = 0;
        var index = 0;

        for (var i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }

        System.out.println(index);
    }
}