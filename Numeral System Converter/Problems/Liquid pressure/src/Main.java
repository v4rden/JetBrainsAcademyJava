import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var density = scanner.nextDouble();
        var height = scanner.nextDouble();
        var gravity = 9.8d;
        var liquidPressure = density * height * gravity;
        System.out.println(liquidPressure);
    }
}