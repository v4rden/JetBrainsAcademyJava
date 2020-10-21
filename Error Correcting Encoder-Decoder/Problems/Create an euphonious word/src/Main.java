import java.util.*;

public class Main {
    private static final char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};
    private static int count = 0;
    private static int streakCount = 0;
    private static boolean wasVowel = true;

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var input = scan.nextLine();
        var arr = input.toCharArray();

        for (var c : arr) {
            var isVowel = isVowel(c);

            if (wasVowel != isVowel) {
                calculateFixingCharAmount();
                streakCount = 1;
                wasVowel = isVowel;
            } else {
                streakCount++;
            }

        }
        calculateFixingCharAmount();

        System.out.println(count);
    }

    public static void calculateFixingCharAmount() {
        if (streakCount > 2) {
            count += getFixCount();
        }
    }

    public static int getFixCount() {
        return (streakCount % 2 == 0)
                ? streakCount / 2 - 1
                : streakCount / 2;
    }

    public static boolean isVowel(char c) {
        for (var v : vowels) {
            if (v == c) return true;
        }
        return false;
    }
}