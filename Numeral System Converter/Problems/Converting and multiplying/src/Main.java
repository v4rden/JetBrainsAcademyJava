import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);

        while (scan.hasNext()) {
            var input = scan.next();

            if (input.equals("0")) break;

            System.out.println(mulAndPrint(input));
        }
    }

    public static String mulAndPrint(String str) {
        String result;
        try {
            var i = Integer.parseInt(str);
            i *= 10;
            result = String.valueOf(i);
        } catch (Exception e) {
            result = String.format(
                    "Invalid user input: %s", str);
        }
        return result;
    }
}