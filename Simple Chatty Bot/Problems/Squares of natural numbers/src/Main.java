import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var n = scan.nextInt();
        var i = 1;
        var square = 1;

        while (n >= square) {
            System.out.println(square);
            i++;
            square = i * i;
        }
    }
}