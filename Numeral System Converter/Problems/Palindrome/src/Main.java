import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var word = scan.next().toLowerCase();
        var result = "yes";
        for (var i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) !=
                    word.charAt(word.length() - 1 - i)) {
                result = "no";
            }
        }
        System.out.println(result);
    }
}