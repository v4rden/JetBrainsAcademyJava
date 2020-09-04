import java.util.Scanner;

public class Main {

    public static int getNumberOfMaxParam(int a, int b, int c) {
        var max = getNumberOfMaxParam(a,b);
        max = getNumberOfMaxParam(max, c);
        if (max == a){
            return 1;
        }
        if(max == b){
            return 2;
        }
        return 3;
    }
    public static int getNumberOfMaxParam(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();

        System.out.println(getNumberOfMaxParam(a, b, c));
    }
}