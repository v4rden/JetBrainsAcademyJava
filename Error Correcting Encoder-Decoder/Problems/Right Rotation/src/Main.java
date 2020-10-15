import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var input = scan.nextLine();
        var originalArr = input.split(" ");
        var rotationValue = scan.nextInt();

        var resultArr = new String[originalArr.length];

        for (var i = 0; i < resultArr.length; i++) {
            resultArr[getIndex(i, rotationValue, originalArr.length)] = originalArr[i];
        }

        System.out.println(String.join(" ", resultArr));
    }

    public static int getIndex(int input, int step, int limit) {
        int result;

        if (input + step < limit) {
            result = input + step;
        } else {
            var realStep = step - ((step / limit) * limit);
            result = (input + realStep) % limit;
        }
        
        return result;
    }
}