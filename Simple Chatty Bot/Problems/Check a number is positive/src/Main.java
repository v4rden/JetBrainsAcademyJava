import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        var scan = new Scanner(System.in);
        var x = scan.nextInt();

        if ( x > 0) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}