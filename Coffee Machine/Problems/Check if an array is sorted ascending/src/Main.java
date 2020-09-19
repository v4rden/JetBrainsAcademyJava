import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var isAsc = true;
        var size = scan.nextInt();
        var current = scan.nextInt();
        for (var i = 0; i < size - 1; i++) {
            var next = scan.nextInt();
            if (current > next) {
                isAsc = false;
            }
            current = next;
        }
        System.out.print(isAsc);
    }
}