import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var sum = 0;
        var n= scan.nextInt();

        while (n != 0){
            sum ++;
            n = scan.nextInt();
        }

        System.out.println(sum);
    }
}