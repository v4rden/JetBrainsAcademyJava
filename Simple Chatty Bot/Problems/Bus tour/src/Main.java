import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var s = new Scanner(System.in);

        var height = s.nextInt();
        var number = s.nextInt();

        var crashNumber = 0;

        for (int i = 1; i <= number; i++) {
            var h = s.nextInt();
            if (height >= h) {
                crashNumber = i;
                break;
            }
        }
        String messsage =
                (crashNumber == 0)
                        ? "Will not crash"
                        : String.format("Will crash on bridge %s", crashNumber);

        System.out.print(messsage);
    }
}