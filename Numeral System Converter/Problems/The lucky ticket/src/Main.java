import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var input = scan.next().toCharArray();

        var leftSum = 0;
        var rightSum = 0;

        for (var i = 0; i < 3; i++) {
            var left = Character.getNumericValue(input[i]);
            leftSum += left;

            var symmetricalPos = input.length - 1 - i;
            var right = Character.getNumericValue(input[symmetricalPos]);
            rightSum += right;
        }

        String result = (leftSum == rightSum) ? "Lucky" : "Regular";
        System.out.println(result);
    }
}