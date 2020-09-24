import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var input = scan.next();
        var result = "";
        switch (input){
            case "gryffindor":
                result = "bravery";
                break;
            case "hufflepuff":
                result = "loyalty";
                break;
            case "slytherin":
                result = "cunning";
                break;
            case "ravenclaw":
                result = "intellect";
                break;
            default:
                result = "not a valid house";
        }
        System.out.println(result);
    }
}