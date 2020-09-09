package tictactoe;

import java.util.Scanner;

public class Main {
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char EMPTY = '_';
    public static final int SIDE = 3;
    public static final int[] funnyCrunch = {2, 1, 0};

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        //scan.useDelimiter(Res.STRING_EMPTY);
        var init = scan.nextLine();
        var arr = new char[SIDE][SIDE];
        var index = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {

                arr[i][j] = init.charAt(index);
                index++;
            }
        }

        printoutArray(arr);

        int jInput = 0;
        int iInput = 0;
        var readingInput = true;

        while (readingInput && scan.hasNext()) {
            var input = scan.nextLine();
            var i = input.charAt(0);
            var j = input.charAt(2);
            printOut("Read" + i + j);
            if (!Character.isDigit(i) ||
                    !Character.isDigit(j)) {
                printOut(Res.NUM_ONLY_MSG);
                continue;
            }
            iInput = Character.getNumericValue(i);
            jInput = Character.getNumericValue(j);

            if (iInput < 1 || jInput < 1 ||
                    iInput > 3 || jInput > 3) {
                printOut(Res.OUT_OF_RANGE);
                continue;
            }
            iInput--;
            jInput--;

            int iTr = funnyCrunch[jInput];
            int jTr = iInput;
            if (!isVacant(iTr, jTr, arr)) {
                printOut(Res.OCCUPIED_MSG);
                continue;
            }
            iInput = iTr;
            jInput = jTr;
            readingInput = false;
        }
        changeWorld(arr, iInput, jInput, X);
        printoutArray(arr);

        //printOut(getWin(arr, SIDE));
    }

    public static boolean isVacant(int i, int j, char[][] arr) {
        printOut("pos " + i + j + "is" + arr[i][j]);
        return arr[i][j] == EMPTY;
    }

    public static String getLine(char p1, char p2, char p3) {
        return String.format(Res.ROW_FORMAT, p1, p2, p3);
    }

    public static void changeWorld(char[][] arr, int i, int j, char input) {
        arr[i][j] = input;
    }

    public static String getWin(char[][] arr, int side) {
        var xWin = false;
        var oWin = false;

        var xCount = getCount(arr, side, X);
        var oCount = getCount(arr, side, O);
        var diff = xCount - oCount;

        if (diff < -1 || diff > 1) {
            return Res.IMPOSSIBLE_MSG;
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
            return Res.IMPOSSIBLE_MSG;
        }
        if (xWin) {
            return Res.X_WINS_MSG;
        }
        if (oWin) {
            return Res.O_WINS_MSG;
        }
        var hasEmpty = hasEmpty(arr, side);
        if (hasEmpty) {
            return Res.NOT_FINISHED;
        }

        return Res.DRAW_MSG;
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
                if (arr[i][j] == EMPTY) {
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
        if (c == X) {
            return State.XWIN;
        }
        if (c == O) {
            return State.OWIN;
        }
        return State.INCOMPLETE;
    }

    public static void printoutArray(char[][] arr) {
        printOut(Res.UPPER_BORDER);
        printOut(getLine(arr[0][0], arr[0][1], arr[0][2]));
        printOut(getLine(arr[1][0], arr[1][1], arr[1][2]));
        printOut(getLine(arr[2][0], arr[2][1], arr[2][2]));
        printOut(Res.UPPER_BORDER);
    }

    public static void printOut(String string) {
        System.out.println(string);
    }

    enum State {
        XWIN,
        OWIN,
        INCOMPLETE
    }

    private static class Res {
        private static final String UPPER_BORDER = "---------";
        private static final String IMPOSSIBLE_MSG = "Impossible";
        private static final String X_WINS_MSG = "X wins";
        private static final String O_WINS_MSG = "O wins";
        private static final String NOT_FINISHED = "Game not finished";
        private static final String DRAW_MSG = "Draw";
        private static final String ROW_FORMAT = "| %c %c %c |";
        private static final String NUM_ONLY_MSG = "You should enter numbers!";
        private static final String OUT_OF_RANGE = "Coordinates should be from 1 to 3!";
        private static final String OCCUPIED_MSG = "This cell is occupied! Choose another one!";
    }
}
