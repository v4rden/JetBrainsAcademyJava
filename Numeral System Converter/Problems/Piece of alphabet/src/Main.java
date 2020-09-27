import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var arr = scan.next().toCharArray();

        var isOrdered = true;
        var cur = arr[0];

        for(var i: arr){
            if(i != cur){
                isOrdered = false;
                break;
            }
            cur++;
        }

        System.out.println(isOrdered);
    }
}