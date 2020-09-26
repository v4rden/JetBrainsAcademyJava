import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var radius = scanner.nextDouble();
        var area = Math.PI * radius * radius;
        System.out.println(area);
    }
}