import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var input = scan.nextInt();
        System.out.print(getFigure(input));
    }

    public static String getFigure(int input) {
        var sb = new StringBuilder("You have chosen a ");

        switch (input) {
            case 1:
                return sb.append("square").toString();
            case 2:
                return sb.append("circle").toString();
            case 3:
                return sb.append("triangle").toString();
            case 4:
                return sb.append("rhombus").toString();
            default:
                sb.setLength(0);
                sb.append("There is no such shape!");
                return sb.toString();
        }
    }
}