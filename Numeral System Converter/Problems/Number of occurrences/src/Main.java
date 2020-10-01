import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var str = scan.nextLine();
        var sub = scan.next();

        var arr = str.split(sub, -1);
        System.out.println(arr.length - 1);
    }
}