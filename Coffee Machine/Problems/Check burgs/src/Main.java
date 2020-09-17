import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var isBurg = false;
        var scan = new Scanner(System.in);
        var input  = scan.nextLine();

        if(input.length() >= 4){
            var sb = new StringBuilder(input).reverse();
            isBurg = sb.indexOf("grub") == 0;
        }

        System.out.print(isBurg);
    }
}