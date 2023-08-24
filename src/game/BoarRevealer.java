package game;

public class BoarRevealer {

    private int[][] RevealedBoar;

    public int[][] fnReveler(int[][] boar, int x, int y) {
        this.RevealedBoar = new int[boar.length][boar[0].length];
        revealRecursive(boar, x, y);
        return RevealedBoar;
    }

    private void revealRecursive(int[][] originalBoard, int x, int y) {
        final int MINE = variablesGame.MINA;
        final int casillasReveladas = variablesGame.casillasReveladas;
        final int MinaTocada = variablesGame.MinaTocada;

        if (x < 0 || x >= originalBoard.length || y < 0 || y >= originalBoard[0].length || RevealedBoar[x][y] != 0) {
            return;
        }

        if (originalBoard[x][y] == 0) {
            this.RevealedBoar[x][y] = casillasReveladas;
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    revealRecursive(originalBoard, i, j);
                }
            }
        } else {
            RevealedBoar[x][y] = originalBoard[x][y] == MINE ? MinaTocada : originalBoard[x][y];
        }
    }
}
