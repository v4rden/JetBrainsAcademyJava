import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var previous = scan.nextInt();
        var next = scan.nextInt();
        var isOrdered = true;
        var isAsc = true;

        while (next != 0) {
            if (previous == next) {
                previous = next;
                next = scan.nextInt();
                continue;
            } else {
                isAsc = previous < next;
                break;
            }
        }

        while (next != 0) {
            if (isAsc) {
                isOrdered = previous <= next;
            } else {
                isOrdered = previous >= next;
            }

            if (!isOrdered) {
                break;
            }

            previous = next;
            next = scan.nextInt();
        }

        System.out.print(isOrdered);
    }

}