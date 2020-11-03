import java.util.Scanner;

public class Main {
    private static char[] VOWELS = new char[]{'a', 'e', 'i', 'o', 'u'};

    public static boolean isVowel(char ch) {
        for (var c : VOWELS) {
            if (c == ch) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}