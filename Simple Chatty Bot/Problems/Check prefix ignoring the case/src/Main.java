// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var s = scan.next();
        var res = s.substring(0, 1);
        System.out.print(res.compareToIgnoreCase("j") == 0);
    }
}