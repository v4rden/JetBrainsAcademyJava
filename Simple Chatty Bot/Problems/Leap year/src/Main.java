import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);

        var year = scan.nextInt();

        var first = (year % 4) == 0 && (year % 100) != 0;
        var second = (year % 400) == 0;

        if(first || second) {
            System.out.print("Leap");
        } else {
            System.out.print("Regular");
        }
    }
}