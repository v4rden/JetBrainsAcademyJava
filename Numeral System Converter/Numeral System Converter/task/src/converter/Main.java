package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            var scan = new Scanner(System.in);
            var sourceRadix = scan.nextInt();
            var number = scan.next();
            var radix = scan.nextInt();
            String result;

            checkRadix(sourceRadix);
            checkRadix(radix);

            if (number.contains(".")) {
                var arr = number.split("\\.");
                int decimal = convertToDecimal(arr[0], sourceRadix);

                result = convertToTarget(decimal, radix);
                var decimalFrac = convertFractionToDecimal(arr[1], sourceRadix);
                var frac = convertFractionToTarget(decimalFrac, radix);
                result += ".";
                result += frac;
            } else {
                int decimal = convertToDecimal(number, sourceRadix);
                result = convertToTarget(decimal, radix);
            }


            System.out.println(result);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static String convertFractionToTarget(String fraction, int radix) {
        Double d = Double.parseDouble(fraction);
        if (!fraction.contains(".")) {
            d = Double.parseDouble("0." + fraction);
        }
        var sb = new StringBuilder();
        double remainder;
        for (var i = 0; i < 5; i++) {
            var product = d * radix;
            var wholePart = (int) product;
            d = product - wholePart;
            sb.append(convertSimple(wholePart, radix));
        }
        return sb.toString();
    }

    public static String convertFractionToDecimal(String fraction, int radix) {
        if (radix == 10) {
            return fraction;
        }

        var arr = fraction.toCharArray();
        double result = 0;
        for (var i = 0; i < arr.length && i < 5; i++) {
            double numba = Character.getNumericValue(arr[i]);
            var div = (Math.pow(radix, i + 1));
            var division = numba / div;
            result += division;
        }
        return String.valueOf(result);
    }

    public static int convertToDecimal(String number, int sourceRadix) {
        int decimal;

        if (sourceRadix == 10) {
            return Integer.parseInt(number);
        }

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
        System.out.println("dec:" + decimal);
        return decimal;
    }

    public static String convertToTarget(int decimal, int targetRadix) {
        String result;
        if (decimal == 0) {
            return "0";
        }
        if (targetRadix == 1) {
            var sb = new StringBuilder();
            sb.append("1".repeat(Math.max(0, decimal)));
            result = sb.toString();
        } else {
            result = convertToRadix(decimal, targetRadix);
        }
        return result;
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

    public static int convertFromSimple(char c) {
        if (Character.getNumericValue(c) < 10) {
            return Character.getNumericValue(c);
        }
        return c - 87;
    }

    public static void checkRadix(int i) throws Exception {
        if (i < 1 || i > 36) {
            throw new Exception("this must be a joke");
        }
    }
}
