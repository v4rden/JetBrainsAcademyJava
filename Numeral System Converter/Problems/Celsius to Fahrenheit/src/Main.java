import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var celsius = scanner.nextDouble();
        var fahrenheit = celsius * 1.8 + 32;
        System.out.println(fahrenheit);
    }
}