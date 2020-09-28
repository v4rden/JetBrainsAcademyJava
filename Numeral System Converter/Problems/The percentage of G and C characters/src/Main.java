import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var input = scan.next().toLowerCase().toCharArray();

        var g = 0;
        var c = 0;

        for (var i : input) {
            if (i == 'g') {
                g++;
            }
            if (i == 'c') {
                c++;
            }
        }

        var result = (double) (g + c) / input.length * 100;
        System.out.println(result);
    }
}