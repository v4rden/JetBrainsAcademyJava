// Don't delete this import statement

import java.util.Scanner;

class SimpleCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long num1 = scanner.nextLong();
        String operator = scanner.next();
        long num2 = scanner.nextLong();

    }

    public static void subtractTwoNumbers(long a, long b) {
        print(a - b);
    }

    public static void sumTwoNumbers(long a, long b) {
        print(a + b);
    }

    public static void divideTwoNumbers(long a, long b) {
        if (b == 0) {
            System.out.println("Division by 0!");
        } else
            print(a / b);
    }

    public static void multiplyTwoNumbers(long a, long b) {
        print(a * b);
    }

    public static void print(long l) {
        System.out.println(l);
    }
}