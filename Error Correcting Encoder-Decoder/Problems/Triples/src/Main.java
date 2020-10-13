import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var size = scan.nextInt();
        var tripletsCount = 0;
        var sequentialCount = 0;
        var previous = scan.nextInt();

        for (int i = 0; i < size - 1; i++) {
            var current = scan.nextInt();

            if (current == previous + 1) {
                sequentialCount++;
            } else {
                sequentialCount = 0;
            }
            previous = current;

            if (sequentialCount >= 2) {
                tripletsCount++;
            }
        }
        System.out.println(tripletsCount);
    }
}