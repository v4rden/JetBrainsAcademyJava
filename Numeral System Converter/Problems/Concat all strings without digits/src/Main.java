import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        var sb = new StringBuilder();
        for (var i : strings) {
            sb.append(i);
        }
        for (var i = 0; i < 10; i++) {
            var s = String.valueOf(i);
            var index = sb.indexOf(s);
            while (index != -1) {
                sb.deleteCharAt(index);
                index = sb.indexOf(s);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}