import java.util.*;

public class Main {
    static Random random = new Random();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var upperCaseLetters = scan.nextInt();
        var lowerCaseLetters = scan.nextInt();
        var digits = scan.nextInt();
        var length = scan.nextInt();

        for (var i = 0; i < upperCaseLetters; i++) {
            sb.append(getChar(65, 90));
        }
        for (var i = 0; i < lowerCaseLetters; i++) {
            sb.append(getChar(97, 122));
        }
        for (var i = 0; i < digits; i++) {
            sb.append(getChar(48, 58));
        }
        while (sb.length() < length) {
            sb.append(getChar(65, 90));
        }
//        for (var i = 0; i < upperCaseLetters; i++) {
//            var c = getUpper();
//            while (needRepeat(c)) {
//                c = getUpper();
//            }
//            sb.append(c);
//        }
//        for (var i = 0; i < lowerCaseLetters; i++) {
//            var c = getLower();
//            while (needRepeat(c)) {
//                getLower();
//            }
//            sb.append(c);
//        }
//        for (var i = 0; i < digits; i++) {
//            var c = getDigit();
//            while (needRepeat(c)) {
//                getDigit();
//            }
//            sb.append(c);
//        }
//
//        while (sb.length() < length) {
//            var c = getLower();
//            while (needRepeat(c)) {
//                getLower();
//            }
//            sb.append(c);
//        }
        System.out.println(sb.toString());
    }

    public static char getChar(int low, int up) {
        var c = (char) low;
        while (needRepeat(c)) {
            low++;
            c = (char) low;
        }
        if (c > up) {
            throw
                    new RuntimeException("ops");
        }
        return c;
    }

    public static boolean needRepeat(char c) {
        if (sb.length() == 0) {
            return false;
        }
        return sb.charAt(sb.length() - 1) == c;
    }

    public static char getUpper() {
        //System.out.println("gettingUpper");
        return getRandom(65, 90);
    }

    public static char getLower() {
        return getRandom(97, 122);
    }

    public static char getDigit() {
        return getRandom(48, 57);
    }

    public static char getRandom(int low, int up) {
        var i = random.nextInt(up - low + 1) + low;
        //System.out.println(i);
        return (char) i;
    }
}