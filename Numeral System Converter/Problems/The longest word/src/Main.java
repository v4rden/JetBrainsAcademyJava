import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        scan.useDelimiter(" ");
        String word = "";

        while (scan.hasNext()) {
            var input = scan.next();
            if (word.length() < input.length()) {
                word = input;
            }
        }

        System.out.println(word);
    }
}