import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        var c = Character.toLowerCase(ch);
        var vowel = "aeiou";
        return vowel.indexOf(c) != -1;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}