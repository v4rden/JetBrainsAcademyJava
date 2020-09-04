import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here

        var cups = scanner.nextInt();
        var isEnd = scanner.nextBoolean();

        var suc = !isEnd && (cups >= 10 && cups <= 20);
        var sucEnd = isEnd && (cups >= 15 && cups <= 25);

        System.out.print(suc || sucEnd);
    }
}