import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var first = scan.nextLong();
        var operand = scan.next();
        var second = scan.nextLong();

        var result = 0L;
        var dividedByZero = false;
        var unknown = false;

        switch (operand) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if (second == 0) {
                    dividedByZero = true;
                    break;
                }
                result = first / second;
                break;
            default:
                unknown = true;
                break;
        }

        if (dividedByZero) {
            System.out.println("Division by 0!");
        }
        if (unknown) {
            System.out.println("Unknown operator");
        }

        if (!dividedByZero && !unknown) {
            System.out.println(result);
        }
    }
}