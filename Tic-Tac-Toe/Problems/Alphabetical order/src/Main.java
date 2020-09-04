import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var arr = new String[2];
        arr[0] = scan.next();
        var result = true;

        while (scan.hasNext()) {
            arr[1] = scan.next();
            if(!areOrdered(arr[0], arr[1])){
                result =false;
                break;
            }
            arr[0] = arr[1];
        }

        System.out.println(result);
    }

    public static boolean areOrdered(String left, String right) {
        if(right.length() < left.length()){
            return false;
        }

        return left.compareTo(right) <= 0;
    }
}