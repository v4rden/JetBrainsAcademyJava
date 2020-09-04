import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var i = scan.nextInt();
        String message;

        switch (i) {
            case 0:
                message = "do not move";
                break;
            case 1:
                message = "move up";
                break;
            case 2:
                message = "move down";
                break;
            case 3:
                message = "move left";
                break;
            case 4:
                message = "move right";
                break;
            default:
                message = "error!";
                break;
        }

        System.out.print(message);
    }
}