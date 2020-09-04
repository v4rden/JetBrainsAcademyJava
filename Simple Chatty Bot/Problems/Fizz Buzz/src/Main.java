import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var fizz = "Fizz";
        var buzz = "Buzz";

        var start = scan.nextInt();
        var end = scan.nextInt();

        for (; start <= end; start++) {
            if (start % 3 == 0) {
                System.out.print(fizz);
            }
            if (start % 5 == 0) {
                System.out.print(buzz);
            }
            if (!(start % 3 == 0) && !(start % 5 == 0)) {
                System.out.print(start);
            }
            System.out.print("\n");
        }
    }
}