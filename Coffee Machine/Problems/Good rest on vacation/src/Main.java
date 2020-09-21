import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var days = scanner.nextInt();
        var foodPerDay = scanner.nextInt();
        var oneWayFlight = scanner.nextInt();
        var hotelPerDay = scanner.nextInt();

        var sum = foodPerDay * days;
        sum = sum + hotelPerDay * (days - 1);
        sum = sum + 2 * oneWayFlight;
        System.out.println(sum);
    }
}