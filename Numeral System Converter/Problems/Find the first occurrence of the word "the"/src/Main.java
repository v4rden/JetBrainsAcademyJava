import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var input = scan.nextLine().toLowerCase();
        var pos = input.indexOf("the");
        System.out.println(pos);
    }
}