import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var inputNumber = scan.nextLong();

        var n = 0L;
        var factorial = 1L;

        while (factorial <= inputNumber) {
            n++;
            factorial = calculateFactorial(n);
        }

        System.out.print(n);
    }

    public static long calculateFactorial(long input) {
        long factorial = input;
        long n = input - 1;
        while (n > 0) {
            factorial *= n;
            n -= 1;
        }
        return factorial;
    }
}