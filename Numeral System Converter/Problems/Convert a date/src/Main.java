import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var input = scan.nextLine();
        var arr = input.split("-");
        var result = String.format(
                "%s/%s/%s", arr[1], arr[2], arr[0]);
        System.out.println(result);
    }
}