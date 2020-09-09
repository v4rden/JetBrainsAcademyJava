package tictactoe;

import java.util.Scanner;

public class Main {
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char EMPTY = '_';
    public static final int SIDE = 3;
    public static char[][] WORLD = new char[SIDE][SIDE];
    public static final int[] funnyCrunch = {2, 1, 0};
    public static char TURN = X;

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        initWorld();
        printoutArray();

        while (WorldState.INCOMPLETE) {
            readOneMove(scan);
            changeWorld();
            printoutArray();
            updateWorldState();
            passTurn();
        }

        printOut(WorldState.getStateMessage());
    }

    public static void readOneMove(Scanner scan) {
        var readingInput = true;

        while (readingInput && scan.hasNext()) {
            var success = tryReadMove(scan);
            readingInput = !success;
        }
    }

    private static Boolean tryReadMove(Scanner scan) {
        var input = scan.nextLine();

        var iChar = input.charAt(0);
        var jChar = input.charAt(2);

        if (!Character.isDigit(iChar) ||
                !Character.isDigit(jChar)) {
            printOut(Res.NUM_ONLY_MSG);
            return false;
        }
        var iInput = Character.getNumericValue(iChar);
        var jInput = Character.getNumericValue(jChar);

        if (iInput < 1 || jInput < 1 ||
                iInput > 3 || jInput > 3) {
            printOut(Res.OUT_OF_RANGE);
            return false;
        }

        iInput--;
        jInput--;

        int iSwap = funnyCrunch[jInput];
        int jSwap = iInput;

        if (!isVacant(iSwap, jSwap)) {
            printOut(Res.OCCUPIED_MSG);
            return false;
        }
        InputPos.I = iSwap;
        InputPos.J = jSwap;

        return true;
    }

    public static boolean isVacant(int i, int j) {
        return WORLD[i][j] == EMPTY;
    }

    public static String getLine(char p1, char p2, char p3) {
        return String.format(Res.ROW_FORMAT, p1, p2, p3);
    }

    public static void changeWorld() {
        WORLD[InputPos.I][InputPos.J] = TURN;
    }

    public static void updateWorldState() {
        var xCount = getCount(X);
        var oCount = getCount(O);
        var diff = xCount - oCount;

        if (diff < -1 || diff > 1) {
            WorldState.IMPOSSIBLE = true;
            WorldState.INCOMPLETE = false;
            return;
        }

        for (var i = 0; i < SIDE; i++) {
           getRowState(i);
        }

        for (var i = 0; i < SIDE; i++) {
            getColumnSate(i);
        }

        getLeftAxisState();
        getRightAxisState();

        if(!hasEmpty()){
            WorldState.INCOMPLETE = false;
        }
    }

    public static void getRowState(int row) {
        char c = WORLD[row][0];
        for (var i = 1; i < SIDE; i++) {
            if (c != WORLD[row][i]) {
                return;
            }
        }
        toSate(c);
    }

    public static void getColumnSate(int column) {
        char c = WORLD[0][column];
        for (var i = 1; i < SIDE; i++) {
            if (c != WORLD[i][column]) {
                return;
            }
        }
        toSate(c);
    }

    public static void getLeftAxisState() {
        char c = WORLD[0][0];
        for (var i = 1; i < SIDE; i++) {
            if (c != WORLD[i][i]) {
                return;
            }
        }
        toSate(c);
    }

    public static void getRightAxisState() {
        char c = WORLD[0][SIDE - 1];
        for (
                int i = 1, j = SIDE - 2;
                i < SIDE && j >= 0;
                i++, j--
        ) {
            if (c != WORLD[i][j]) {
                return;
            }
        }
        toSate(c);
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

    public static void toSate(char c) {
        if (c == X) {
            WorldState.X_WON = true;
            WorldState.INCOMPLETE = false;
        }
        if (c == O) {
            WorldState.O_WON = true;
            WorldState.INCOMPLETE = false;
        }
    }

    public static void passTurn() {
        TURN = TURN == X ? O : X;
    }

    public static void printoutArray() {
        printOut(Res.UPPER_BORDER);
        printOut(getLine(WORLD[0][0], WORLD[0][1], WORLD[0][2]));
        printOut(getLine(WORLD[1][0], WORLD[1][1], WORLD[1][2]));
        printOut(getLine(WORLD[2][0], WORLD[2][1], WORLD[2][2]));
        printOut(Res.UPPER_BORDER);
    }

    public static void initWorld() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                WORLD[i][j] = EMPTY;
            }
        }
    }

    public static void printOut(String string) {
        System.out.println(string);
    }

    private static class InputPos {
        public static int I;
        public static int J;
    }

    private static class WorldState {
        public static Boolean X_WON = false;
        public static Boolean O_WON = false;
        public static Boolean INCOMPLETE = true;
        public static Boolean IMPOSSIBLE = false;

        public static String getStateMessage(){
            if (X_WON && O_WON) {
                return Res.IMPOSSIBLE_MSG;
            }
            if (X_WON) {
                return Res.X_WINS_MSG;
            }
            if (O_WON) {
                return Res.O_WINS_MSG;
            }
//            if (hasEmpty()) {
//                return Res.NOT_FINISHED;
//            }

            return Res.DRAW_MSG;
        }
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
