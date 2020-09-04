import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var s = new Scanner(System.in);
        var amount = s.nextInt();

        var currentAmount = 0;
        var seed = 1;


        for (; currentAmount < amount; ) {
            for (
                    var it = 1;
                    (currentAmount < amount) && (it <= seed);
                    it++
            ) {
                System.out.print(seed);
                currentAmount++;
                if (currentAmount != amount) {
                    System.out.print(" ");
                }
            }
            seed++;
        }
//Prints correct result but does not pass test
        //My guess time exceeded because while loop takes more time to process
            /*while (currentAmount <= amount) {
                var index = 1;
                while (
                        currentAmount < amount
                                && index <= seed
                ) {
                    System.out.print(seed);

                    index++;
                    currentAmount++;

                    if (currentAmount < amount) {
                        System.out.print(" ");
                    }
                }
                seed++;
            }*/
    }
}