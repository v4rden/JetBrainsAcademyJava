import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);

        var a = scan.nextInt();
        var b = scan.nextInt();
        float sum = 0;
        float q = 0;

        for (; a <= b; a++) {

            if (a % 3 == 0) {
                sum += a;
                q++;
            }
        }


        System.out.print(sum  / q);
        //System.out.print(q);
        //System.out.print(".");
        //System.out.print(sum % q);
    }
}