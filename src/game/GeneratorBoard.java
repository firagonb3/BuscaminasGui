package game;

import java.util.Random;

public class GeneratorBoard {

    private int[][] board;
    private Random random = new Random();
    private final int MINA = variablesGame.MINA;

    public GeneratorBoard(int rows, int columns, int mines, int mineY, int mineX) {
        newBoard(rows, columns, mines, mineX, mineY);
    }

    private void generateMines(int rows, int columns, int minas, int minaY, int minaX) {
        board = new int[rows][columns];
        for (int i = 0; i < minas; ++i) {
            int row = random.nextInt(rows);
            int column = random.nextInt(columns);

            if (minaX == row && minaY == column) {
                board[row][column] = 0;
            } else if (board[row][column] == MINA) {
                i--;
            } else {
                board[row][column] = MINA;
            }
        }
    }

    private void generateNumbers(int columns, int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] != MINA) {
                    int count = 0;

                    // Verificar las 8 casillas adyacentes
                    for (int x = i - 1; x <= i + 1; x++) {
                        for (int y = j - 1; y <= j + 1; y++) {
                            if (x >= 0 && x < rows && y >= 0 && y < columns && board[x][y] == MINA) {
                                count++;
                            }
                        }
                    }

                    board[i][j] = count;
                }
            }
        }
    }

    public int[][] newBoard(int rows, int columns, int mines, int mineY, int mineX) {
        if (mines <= mineY * mineX - 10) {
            generateMines(rows, columns, mines, mineY, mineX);
        } else {
            generateMines(rows, columns, mines-10, mineY, mineX);
        }
        generateNumbers(columns, rows);
        return board;
    }

    public int[][] getBoard() {
        return board;
    }
}