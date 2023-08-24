package obj.controlers;

import game.BoarRevealer;
import game.GeneratorBoard;

public class GameControler {

    private static GeneratorBoard board;
    private static boolean notgenedated = true;
    private static BoarRevealer revealer = new BoarRevealer();

    private static int sizeY;
    private static int sizeX;
    private static int mine;

    private GameControler() {

    }

    public static void InitializerBoard(int sizeY, int sizeX, int mine) {
        GameControler.sizeY = sizeY;
        GameControler.sizeX = sizeX;

        if (mine <= 0) { 
           GameControler.mine = 1;
        } else if (mine <= sizeY * sizeX - 10) {
            GameControler.mine = mine;
        } else {
            GameControler.mine = mine - 10;
        }
    }

    public static int[][] FnFinpartida() {
        System.out.println("FIN PARTIDA");
        return board.getBoard();
    }

    public static void ResetBoard() {
        revealer = new BoarRevealer();
        notgenedated = true;
    }

    public static int[][] BoardGenerated(int y, int x) {
        board = new GeneratorBoard(sizeY, sizeX, mine, y, x);
        notgenedated = false;
        return board.getBoard();
    }

    public static int[][] fnBoarRevealer(int y, int x) {
        return revealer.fnReveler(board.getBoard() , y, x);
    }

    public static boolean isNotGenerated() {
        return notgenedated;
    }

    public static int getSizeY() {
        return sizeY;
    }

    public static int getSizeX() {
        return sizeX;
    }

    public static int getMine() {
        return mine;
    }
}
