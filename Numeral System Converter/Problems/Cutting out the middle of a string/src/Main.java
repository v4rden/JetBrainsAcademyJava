import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var input = scan.next();
        String result;
        var mid = input.length() / 2;
        if (input.length() % 2 != 0) {
            result = input.substring(0, mid);
        } else {
            result = input.substring(0, mid - 1);
        }
        result += input.substring(mid + 1, input.length());
        System.out.println(result);
    }
}