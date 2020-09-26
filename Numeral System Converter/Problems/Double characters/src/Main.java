import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var arr = scan.next().toCharArray();
        String result = "";

        for (var i : arr) {
            result += i;
            result += i;
        }
        System.out.println(result);
    }
}