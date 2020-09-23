package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        var exit = false;
        var scan = new Scanner(System.in);

        while (!exit) {
            printOut("Write action (buy, fill, take, remaining, exit):");
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
            if (input.equals("remaining")) {
                remaining();
            }
            if (input.equals("exit")) {
                exit = true;
            }
        }
    }




    private static void buy(Scanner scan) {
        printOut("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        var choice = scan.next();
        if (choice.equals("1")) {
            if (!MachineState.canMakeEspresso()) {
                return;
            }
            MachineState.water -= 250;
            MachineState.beans -= 16;
            MachineState.money += 4;
            MachineState.dCups--;
        }
        if (choice.equals("2")) {
            if (!MachineState.canMakeLatte()) {
                return;
            }
            MachineState.water -= 350;
            MachineState.milk -= 75;
            MachineState.beans -= 20;
            MachineState.money += 7;
            MachineState.dCups--;
        }
        if (choice.equals("3")) {
            if (!MachineState.canMakeCappuccino()) {
                return;
            }
            MachineState.water -= 200;
            MachineState.milk -= 100;
            MachineState.beans -= 12;
            MachineState.money += 6;
            MachineState.dCups--;
        }

        if (choice.equals("back")) {
        }
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

    private static void remaining() {
        MachineState.print();
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

        public static boolean canMakeEspresso() {
            if (water < 250) {
                printOut("Sorry, not enough water");
                return false;
            }
            if (beans < 16) {
                printOut("Sorry, not enough coffee beans");
                return false;
            }
            if (dCups == 0) {
                printOut("Sorry, not enough disposable cups");
                return false;
            }
            return true;
        }

        public static boolean canMakeLatte() {
            if (water < 350) {
                printOut("Sorry, not enough water");
                return false;
            }
            if (milk < 75) {
                printOut("Sorry, not enough milk");
                return false;
            }
            if (beans < 20) {
                printOut("Sorry, not enough coffee beans");
                return false;
            }
            if (dCups == 0) {
                printOut("Sorry, not enough disposable cups");
                return false;
            }
            return true;
        }
        public static boolean canMakeCappuccino() {
            if (water < 200) {
                printOut("Sorry, not enough water");
                return false;
            }
            if (milk < 100) {
                printOut("Sorry, not enough milk");
                return false;
            }
            if (beans < 12) {
                printOut("Sorry, not enough coffee beans");
                return false;
            }
            if (dCups == 0) {
                printOut("Sorry, not enough disposable cups");
                return false;
            }
            return true;
        }
    }

    public static void printOut(String str) {
        System.out.println(str);
    }

    public static class Res {
    }
}


