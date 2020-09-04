import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var x = scanner.nextInt();
        var x2 = scanner.nextInt();
        var x3 = scanner.nextInt();

        var res = (x <= x3) && (x >= x2);
        var res2 = (x >= x3) && (x <= x2);

        System.out.print(res || res2);
    }
}