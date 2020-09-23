import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var skip = scan.nextInt();
        int max = 0;
        while (scan.hasNextInt()) {
            var input = scan.nextInt();
            if (input > max && input % 4 == 0) {
                max = input;
            }
        }
        System.out.println(max);
    }
}