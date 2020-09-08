package tictactoe;

import java.util.Scanner;

public class Main {
    private static final String upperBorder = "---------";
    private static final String impossibleMsg = "Impossible";
    private static final String xWinsMsg = "X wins";
    private static final String oWinsMsg = "O wins";
    private static final String notFinishedMsg = "Game not finished";
    private static final String drawMsg = "Draw";
    private static final String stringEmpty = "";
    private static final String rowFormat = "| %c %c %c |";

    public static void main(String[] args) {
        var side = 3;
        var scan = new Scanner(System.in);
        scan.useDelimiter(stringEmpty);
        var arr = new char[3][3];

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                arr[i][j] = scan.next().charAt(0);
            }
        }

        printOut(arr);

        System.out.println(getWin(arr, side));
    }

    public static String getLine(char p1, char p2, char p3) {
        return String.format(rowFormat, p1, p2, p3);
    }

    public static String getWin(char[][] arr, int side) {
        var xWin = false;
        var oWin = false;

        var xCount = getCount(arr, side, 'X');
        var oCount = getCount(arr, side, 'O');
        var diff = xCount - oCount;

        if (diff < -1 || diff > 1) {
            return impossibleMsg;
        }

        for (var i = 0; i < side; i++) {
            var result = getRowState(i, arr, side);
            if (result == State.XWIN) {
                xWin = true;
            }
            if (result == State.OWIN) {
                oWin = true;
            }
        }

        for (var i = 0; i < side; i++) {
            var result = getColumnSate(i, arr, side);
            if (result == State.XWIN) {
                xWin = true;
            }
            if (result == State.OWIN) {
                oWin = true;
            }
        }

        var leftAxisState = getLeftAxisState(arr, side);
        var rightAxisState = getRightAxisState(arr, side);

        if (leftAxisState == State.XWIN) {
            xWin = true;
        }
        if (leftAxisState == State.OWIN) {
            oWin = true;
        }
        if (rightAxisState == State.XWIN) {
            xWin = true;
        }
        if (rightAxisState == State.OWIN) {
            oWin = true;
        }

        if (xWin && oWin) {
            return impossibleMsg;
        }
        if (xWin) {
            return xWinsMsg;
        }
        if (oWin) {
            return oWinsMsg;
        }
        var hasEmpty = hasEmpty(arr, side);
        if (hasEmpty) {
            return notFinishedMsg;
        }

        return drawMsg;
    }

    enum State {
        XWIN,
        OWIN,
        INCOMPLETE
    }

    public static State getRowState(int row, char[][] arr, int side) {
        char c = arr[row][0];
        for (var i = 1; i < side; i++) {
            if (c != arr[row][i]) {
                return State.INCOMPLETE;
            }
        }
        return toSate(c);
    }

    public static State getColumnSate(int column, char[][] arr, int side) {
        char c = arr[0][column];
        for (var i = 1; i < side; i++) {
            if (c != arr[i][column]) {
                return State.INCOMPLETE;
            }
        }
        return toSate(c);
    }

    public static State getLeftAxisState(char[][] arr, int side) {
        char c = arr[0][0];
        for (var i = 1; i < side; i++) {
            if (c != arr[i][i]) {
                return State.INCOMPLETE;
            }
        }
        return toSate(c);
    }

    public static State getRightAxisState(char[][] arr, int side) {
        char c = arr[0][side - 1];
        for (
                int i = 1, j = side - 2;
                i < side && j >= 0;
                i++, j--
        ) {
            if (c != arr[i][j]) {
                return State.INCOMPLETE;
            }
        }
        return toSate(c);
    }

    public static boolean hasEmpty(char[][] arr, int side) {
        var result = false;
        for (var i = 0; i < side; i++) {
            for (var j = 0; j < side; j++) {
                if (arr[i][j] == '_') {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static int getCount(char[][] arr, int side, char element) {
        var counter = 0;
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                if (arr[i][j] == element) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static State toSate(char c) {
        if (c == 'X') {
            return State.XWIN;
        }
        if (c == 'O') {
            return State.OWIN;
        }
        return State.INCOMPLETE;
    }

    public static void printOut(char[][] arr) {
        System.out.println(upperBorder);
        System.out.println(getLine(arr[0][0], arr[0][1], arr[0][2]));
        System.out.println(getLine(arr[1][0], arr[1][1], arr[1][2]));
        System.out.println(getLine(arr[2][0], arr[2][1], arr[2][2]));
        System.out.println(upperBorder);
    }
}
