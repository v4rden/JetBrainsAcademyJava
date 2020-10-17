import java.util.*;

public class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var numberOfCompanies = scan.nextInt();

        int[] income = new int[numberOfCompanies];

        for (var i = 0; i < numberOfCompanies; i++) {
            income[i] = scan.nextInt();
        }

        double maxSum = 0;
        int index = 0;

        for (var i = 0; i < numberOfCompanies; i++) {
            var tax = scan.nextInt();
            if (income[i] == 0 || tax == 0) {
                continue;
            }

            var s = ((double) income[i] / 100) * tax;
            if (s > maxSum) {
                maxSum = s;
                index = i;
            }
        }

        System.out.println(index + 1);
    }
}