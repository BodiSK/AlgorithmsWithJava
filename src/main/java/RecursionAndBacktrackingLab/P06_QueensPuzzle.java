package RecursionAndBacktrackingLab;

public class P06_QueensPuzzle {

    private static char[][] board = new char[8][8];

    public static void main(String[] args) {
        fillBoard();
        findQueensPositions(0);
    }


    private static void findQueensPositions(int row) {
        if (row == 8) {
            printSolution();
        } else {
            for (int col = 0; col < 8; col++) {
                if (canPlaceQueen(row, col)) {
                    putQueenOnPosition(row, col);
                    findQueensPositions(row + 1);
                    removeQueen(row, col);
                }
            }
        }
    }

    private static void removeQueen(int row, int col) {
        board[row][col] = '-';
    }


    private static void putQueenOnPosition(int row, int col) {
        board[row][col] = '*';
    }

    private static boolean canPlaceQueen(int row, int col) {
        for (int r = 0; r < 8; r++) {
            if (board[r][col] == '*') {
                return false;
            }
        }

        int r = row - 1;
        int c = col - 1;

        while (r >= 0 && c >= 0) {
            if (board[r--][c--] == '*') {
                return false;
            }
        }

        r = row + 1;
        c = col + 1;

        while (r < 8 && c < 8) {
            if (board[r++][c++] == '*') {
                return false;
            }
        }

        r = row - 1;
        c = col + 1;

        while (r >= 0 && c < 8) {
            if (board[r--][c++] == '*') {
                return false;
            }
        }

        r = row + 1;
        c = col - 1;

        while (r < 8 && c >= 0) {
            if(board[r++][c--] == '*') {
                return false;
            }
        }
        return true;
    }

    private static void fillBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = '-';
            }
        }
    }

    private static void printSolution() {
        for (char[] chars : board) {
            for (char element : chars) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
