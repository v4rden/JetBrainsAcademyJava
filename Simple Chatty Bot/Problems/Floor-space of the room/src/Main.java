import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        String figure = scan.nextLine();
        double floorage = 0;
        double a, b, c;

        switch (figure) {
            case "triangle":
                a = scan.nextDouble();
                b = scan.nextDouble();
                c = scan.nextDouble();
                floorage = getTriangle(a, b, c);
                break;
            case "rectangle":
                a = scan.nextDouble();
                b = scan.nextDouble();
                floorage = getRectangle(a, b);
                break;
            case "circle":
                a = scan.nextDouble();
                floorage = getCircle(a);
                break;
        }

        System.out.print(floorage);
    }

    public static double getTriangle(double a, double b, double c) {
        var p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static double getRectangle(double a, double b) {
        return a * b;
    }

    public static double getCircle(double a) {
        return a * a * 3.14d;
    }
}