package tictactoe;

import java.util.Scanner;

public class Main {
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char EMPTY = '_';
    public static final int SIDE = 3;
    public static char[][] WORLD = new char[SIDE][SIDE];
    public static final int[] funnyCrunch = {2, 1, 0};

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        readWorld(scan);

        printoutArray();

        int jInput = 0;
        int iInput = 0;
        var readingInput = true;

        while (readingInput && scan.hasNext()) {
            var input = scan.nextLine();
            var i = input.charAt(0);
            var j = input.charAt(2);
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
            if (!isVacant(iTr, jTr)) {
                printOut(Res.OCCUPIED_MSG);
                continue;
            }
            iInput = iTr;
            jInput = jTr;
            readingInput = false;
        }
        changeWorld(iInput, jInput, X);
        printoutArray();

        //printOut(getWin(arr, SIDE));
    }

    public static boolean isVacant(int i, int j) {
        return WORLD[i][j] == EMPTY;
    }

    public static String getLine(char p1, char p2, char p3) {
        return String.format(Res.ROW_FORMAT, p1, p2, p3);
    }

    public static void changeWorld(int i, int j, char input) {
        WORLD[i][j] = input;
    }

    public static String getWorldState(int side) {
        var xWin = false;
        var oWin = false;

        var xCount = getCount(X);
        var oCount = getCount(O);
        var diff = xCount - oCount;

        if (diff < -1 || diff > 1) {
            return Res.IMPOSSIBLE_MSG;
        }

        for (var i = 0; i < side; i++) {
            var result = getRowState(i);
            if (result == State.XWIN) {
                xWin = true;
            }
            if (result == State.OWIN) {
                oWin = true;
            }
        }

        for (var i = 0; i < side; i++) {
            var result = getColumnSate(i);
            if (result == State.XWIN) {
                xWin = true;
            }
            if (result == State.OWIN) {
                oWin = true;
            }
        }

        var leftAxisState = getLeftAxisState();
        var rightAxisState = getRightAxisState();

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
        if (hasEmpty()) {
            return Res.NOT_FINISHED;
        }

        return Res.DRAW_MSG;
    }

    public static State getRowState(int row) {
        char c = WORLD[row][0];
        for (var i = 1; i < SIDE; i++) {
            if (c != WORLD[row][i]) {
                return State.INCOMPLETE;
            }
        }
        return toSate(c);
    }

    public static State getColumnSate(int column) {
        char c = WORLD[0][column];
        for (var i = 1; i < SIDE; i++) {
            if (c != WORLD[i][column]) {
                return State.INCOMPLETE;
            }
        }
        return toSate(c);
    }

    public static State getLeftAxisState() {
        char c = WORLD[0][0];
        for (var i = 1; i < SIDE; i++) {
            if (c != WORLD[i][i]) {
                return State.INCOMPLETE;
            }
        }
        return toSate(c);
    }

    public static State getRightAxisState() {
        char c = WORLD[0][SIDE - 1];
        for (
                int i = 1, j = SIDE - 2;
                i < SIDE && j >= 0;
                i++, j--
        ) {
            if (c != WORLD[i][j]) {
                return State.INCOMPLETE;
            }
        }
        return toSate(c);
    }

    public static boolean hasEmpty() {
        var result = false;
        for (var i = 0; i < SIDE; i++) {
            for (var j = 0; j < SIDE; j++) {
                if (WORLD[i][j] == EMPTY) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static int getCount(char element) {
        var counter = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (WORLD[i][j] == element) {
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

    public static void printoutArray() {
        printOut(Res.UPPER_BORDER);
        printOut(getLine(WORLD[0][0], WORLD[0][1], WORLD[0][2]));
        printOut(getLine(WORLD[1][0], WORLD[1][1], WORLD[1][2]));
        printOut(getLine(WORLD[2][0], WORLD[2][1], WORLD[2][2]));
        printOut(Res.UPPER_BORDER);
    }

    public static void readWorld(Scanner scan) {
        var init = scan.nextLine();
        var index = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                WORLD[i][j] = init.charAt(index);
                index++;
            }
        }
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
