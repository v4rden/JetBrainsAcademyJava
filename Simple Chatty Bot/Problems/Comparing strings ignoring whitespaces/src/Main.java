import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var s1 = scan.nextLine().replace(" ", "");
        var s2 = scan.nextLine().replace(" ", "");

        System.out.print(s1.compareTo(s2) == 0);
    }
}