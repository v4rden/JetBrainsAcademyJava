package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var sourceRadix = scan.nextInt();
        var number = scan.next();
        var radix = scan.nextInt();
        String result = "---";
        int decimal;

        if (sourceRadix == 1) {
            var i = 0;
            var cur = Integer.parseInt(number);
            while (cur > 0) {
                cur /= 10;
                i++;
            }
            decimal = i;
        } else {
            decimal = Integer.parseInt(number, sourceRadix);
        }

        if (radix == 1) {
            var sb = new StringBuilder();
            for (var i = 0; i < decimal; i++) {
                sb.append(1);
            }
            result = sb.toString();
        } else {
            result = convertToRadix(decimal, radix);
        }
        System.out.println(result);


//        switch (radix) {
//            case 2:
//                result = getBinary(number);
//                break;
//            case 8:
//                result = getOctal(number);
//                break;
//            case 16:
//                result = getHex(number);
//                break;
//        }
        System.out.println(result);
    }

    public static String getBinary(int dec) {
        var cur = dec;
        var sb = new StringBuilder();
        if (cur == 0) {
            sb.append(0);
        }
        while (cur > 0) {
            var r = cur % 2 == 0 ? 0 : 1;
            sb.append(r);
            cur /= 2;
        }
        sb.append("b0");
        sb.reverse();
        return sb.toString();
    }

    public static String getOctal(int dec) {
        var sb = new StringBuilder();

        if (dec < 8) {
            sb.append(dec);
        } else {

            var cur = dec;

            while (cur > 0) {
                var r = cur % 8;
                sb.append(r);
                cur /= 8;
            }
        }
        sb.append("0");
        sb.reverse();
        return sb.toString();
    }

    public static String getHex(int dec) {
        var sb = new StringBuilder();
        if (dec < 16) {
            sb.append(getSimpleHex(dec));
        } else {
            var cur = dec;
            while (cur > 0) {
                var r = cur % 16;
                sb.append(getSimpleHex(r));
                cur /= 16;
            }
        }
        sb.append("x0");
        sb.reverse();
        return sb.toString();
    }

    public static String getSimpleHex(int i) {
        if (i < 10) {
            return Integer.toString(i);
        }
        switch (i) {
            case 10:
                return "a";
            case 11:
                return "b";
            case 12:
                return "c";
            case 13:
                return "d";
            case 14:
                return "e";
            case 15:
                return "f";
        }
        return null;
    }

    public static String convertToRadix(int dec, int radix) {
        var sb = new StringBuilder();
        if (dec < radix) {
            sb.append(convertSimple(dec, radix));
        } else {
            var cur = dec;
            while (cur > 0) {
                var r = cur % radix;
                sb.append(convertSimple(r, radix));
                cur /= radix;
            }
        }

        sb.reverse();
        return sb.toString();
    }

    public static String convertSimple(int i, int radix) {
        if (i < radix & i < 10) {
            return Integer.toString(i);
        }
        return Character.toString((char) (i + 87));
    }
}
