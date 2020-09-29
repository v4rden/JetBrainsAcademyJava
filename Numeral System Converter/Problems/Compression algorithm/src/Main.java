import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var input = scan.next().toCharArray();

        var sb = new StringBuilder();
        char current = input[0];
        int counter = 0;

        for (var c : input) {
            if (c == current) {
                counter++;
            } else {
                sb.append(current);
                sb.append(counter);
                current = c;
                counter = 1;
            }
        }

        sb.append(current);
        sb.append(counter);

        System.out.println(sb.toString());
    }
}