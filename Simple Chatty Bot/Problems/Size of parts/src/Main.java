import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var range = scan.nextInt();

        var larger = 0;
        var good = 0;
        var smaller = 0;

        for (var i = 0; i < range; i++) {
            var d = scan.nextInt();

            if(d == 1) {
                larger++;
            }
            if(d == -1) {
                smaller++;
            }
            if(d==0) {
                good++;
            }
        }

        System.out.print(good + " " + larger + " " + smaller);
    }
}