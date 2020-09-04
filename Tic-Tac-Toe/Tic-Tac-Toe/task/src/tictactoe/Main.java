package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var upperBorder = "---------";

        var scan = new Scanner(System.in);
        var input = scan.next();
        var arr = new char[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = input.charAt(i);
        }

        System.out.println(upperBorder);
        System.out.println(getLine(arr[0], arr[1], arr[2]));
        System.out.println(getLine(arr[3], arr[4], arr[5]));
        System.out.println(getLine(arr[6], arr[7], arr[8]));
        System.out.println(upperBorder);
    }

    public static String getLine(char p1, char p2, char p3) {
        return String.format("| %c %c %c |", p1, p2, p3);
    }
}
