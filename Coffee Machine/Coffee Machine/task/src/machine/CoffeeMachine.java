package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        System.out.println(Res.HOW_MANY);
        var cups = scan.nextInt();
        System.out.println(String.format(
                "For %d cups of coffee you will need:", cups));
        System.out.println(String.format(
                "%d ml of water", cups * 200));
        System.out.println(String.format(
                "%d ml of milk", cups * 50));
        System.out.println(String.format(
                "%d g of coffee beans", cups * 15));


//        System.out.println(Res.START);
//        System.out.println(Res.GRINDING);
//        System.out.println(Res.BOILING);
//        System.out.println(Res.MIXING);
//        System.out.println(Res.POURING_COFFEE);
//        System.out.println(Res.POURING_MILK);
//        System.out.println(Res.READY);
    }

    public static class Res {
        public static final String START = "Starting to make a coffee";
        public static final String GRINDING = "Grinding coffee beans";
        public static final String BOILING = "Boiling water";
        public static final String MIXING = "Mixing boiled water with crushed coffee beans";
        public static final String POURING_COFFEE = "Pouring coffee into the cup";
        public static final String POURING_MILK = "Pouring some milk into the cup";
        public static final String READY = "Coffee is ready!";
        public static final String HOW_MANY = "Write how many cups of coffee you will need:";
    }
}
