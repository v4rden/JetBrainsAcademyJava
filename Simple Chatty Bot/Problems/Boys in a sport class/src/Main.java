import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // put your code here
        var f = sc.nextInt();
        var s = sc.nextInt();
        var t = sc.nextInt();

        System.out.println((f <= s && s <= t) || (f >= s && s >= t));
    }
}