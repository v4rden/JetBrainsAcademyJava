import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var s = new Scanner(System.in);
        var n = s.nextInt();


        while (n != 0) {
            var isEven = get(n);
            System.out.println(isEven);
            n = s.nextInt();
        }
    }

    public static String get(int i) {
        return (i % 2 == 0) ? "even" : "odd";
    }
}