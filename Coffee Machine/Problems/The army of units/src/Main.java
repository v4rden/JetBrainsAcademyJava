import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var input = scan.nextInt();
        String result;
        if (input < 1) {
            result = "no army";
        } else if (input < 20) {
            result = "pack";
        } else if (input < 250) {
            result = "throng";
        } else if (input < 1000) {
            result = "zounds";
        } else {
            result = "legion";
        }
        System.out.println(result);
    }
}