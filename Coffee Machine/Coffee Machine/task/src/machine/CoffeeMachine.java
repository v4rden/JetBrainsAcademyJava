package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        MachineState.print();
        printOut("Write action (buy, fill, take):");
        var input = scan.next();
        if (input.equals("buy")) {
            buy(scan);
        }
        if (input.equals("fill")) {
            fill(scan);
        }
        if (input.equals("take")) {
            take(scan);
        }
        MachineState.print();

        //System.out.println(Res.HOW_MANY);
        //var cups = scan.nextInt();


//        print("Write how many ml of water the coffee machine has:");
//        var water = scan.nextInt();
//        print("Write how many ml of milk the coffee machine has:");
//        var milk = scan.nextInt();
//        print("Write how many grams of coffee beans the coffee machine has:");
//        var beans = scan.nextInt();
//        print("Write how many cups of coffee you will need:");
//        var targetCups = scan.nextInt();
//
//        var possibleForWater = water / 200;
//        var possibleForMilk = milk / 50;
//        var possibleForBeans = beans / 15;
//
//        var max = possibleForWater > possibleForMilk ? possibleForMilk : possibleForWater;
//        max = max > possibleForBeans ? possibleForBeans : max;
//
//        if (max == targetCups) {
//            print("Yes, I can make that amount of coffee");
//        }
//        if (max < targetCups) {
//            print(String.format("No, I can make only %d cup(s) of coffee", max));
//        }
//        if (max > targetCups) {
//            print(String.format("Yes, I can make that amount of coffee (and even %d more than that)", max - targetCups));
//        }

//        System.out.println(String.format(
//                "For %d cups of coffee you will need:", cups));
//        System.out.println(String.format(
//                "%d ml of water", cups * 200));
//        System.out.println(String.format(
//                "%d ml of milk", cups * 50));
//        System.out.println(String.format(
//                "%d g of coffee beans", cups * 15));


//        System.out.println(Res.START);
//        System.out.println(Res.GRINDING);
//        System.out.println(Res.BOILING);
//        System.out.println(Res.MIXING);
//        System.out.println(Res.POURING_COFFEE);
//        System.out.println(Res.POURING_MILK);
//        System.out.println(Res.READY);
    }

    private static void buy(Scanner scan) {
        printOut("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        var choice = scan.nextInt();
        if (choice == 1) {
            MachineState.water -= 250;
            MachineState.beans -= 16;
            MachineState.money += 4;
        }
        if (choice == 2) {
            MachineState.water -= 350;
            MachineState.milk -= 75;
            MachineState.beans -= 20;
            MachineState.money += 7;
        }
        if (choice == 3) {
            MachineState.water -= 200;
            MachineState.milk -= 100;
            MachineState.beans -= 12;
            MachineState.money += 6;
        }
        MachineState.dCups--;
    }

    private static void fill(Scanner scan) {
        printOut("Write how many ml of water do you want to add:");
        var amount = scan.nextInt();
        MachineState.water += amount;
        printOut("Write how many ml of milk do you want to add: ");
        amount = scan.nextInt();
        MachineState.milk += amount;
        printOut("Write how many grams of coffee beans do you want to add:");
        amount = scan.nextInt();
        MachineState.beans += amount;
        printOut("Write how many disposable cups of coffee do you want to add:");
        amount = scan.nextInt();
        MachineState.dCups += amount;
    }

    private static void take(Scanner scan) {
        printOut(String.format("I gave you %d", MachineState.money));
        MachineState.money = 0;
    }

    private static class MachineState {
        public static int money = 550;
        public static int water = 400;
        public static int milk = 540;
        public static int beans = 120;
        public static int dCups = 9;

        public static void print() {
            printOut("The coffee machine has:");
            printOut(String.format("%d of water", water));
            printOut(String.format("%d of milk", milk));
            printOut(String.format("%d of coffee beans", beans));
            printOut(String.format("%d of disposable cups", dCups));
            printOut(String.format("%d of money", money));
        }
    }

    public static void printOut(String str) {
        System.out.println(str);
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
