import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var first = scan.nextInt() * 3600;
        first += scan.nextInt() * 60;
        first += scan.nextInt();
        
        var second = scan.nextInt() * 3600;
        second += scan.nextInt() * 60;
        second += scan.nextInt();
        
        var dif = second - first;
        System.out.print(dif);
    }
}
