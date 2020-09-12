import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var l1 = scan.nextLine();
        var l2 = scan.nextLine();
        var l3 = scan.nextLine();

       var size = Integer.parseInt(l1);

        var arr = Arrays.stream(l2.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        var inp = Arrays.stream(l3.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        var areNeighbours = false;

        for (var i : arr) {
            if(i + 1 <size){
                if(
                        (arr[i] ==inp[0] && arr[i+1] == inp[1])
                         ||(arr[i] ==inp[1] && arr[i+1] == inp[0])){
                    areNeighbours = true;
                }
            }
        }

        System.out.println(areNeighbours);
    }
}