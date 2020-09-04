import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var mDeposit = scan.nextInt();
        var pPercent = scan.nextInt();
        var kTargetSum = scan.nextInt();

        double current = mDeposit;
        var yearsTo = 0;

        while (current < kTargetSum) {
            current = current + (current * pPercent / 100);
            yearsTo++;
        }

        System.out.print(yearsTo);
    }
}
