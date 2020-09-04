import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var st = scan.next();
        System.out.print(st.replace('a', 'b'));
    }
}