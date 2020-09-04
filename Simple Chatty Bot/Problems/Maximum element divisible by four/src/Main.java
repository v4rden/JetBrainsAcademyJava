import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);

        var range = scan.nextInt();
        var max = 0;

        for (var i = 0; i < range; i++) {
            var d = scan.nextInt();
            if(d % 4 == 0) {
                if(d > max) {
                    max = d;
                }
            }
        }

        System.out.print(max);
    }
}