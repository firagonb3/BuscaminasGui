package gui.components;

import obj.controlers.GameControler;
import obj.controlers.GameViewController;
import obj.gui.Interfaces.InterfaceBoardCell;
import obj.gui.components.ComponentPanel;
import resources.graphics.LoaderImage;

import java.awt.GridLayout;

import game.variablesGame;

public class Tablero extends ComponentPanel implements InterfaceBoardCell {

    private int rows;
    private int columns;
    private Casilla[][] cells;
    private GameViewController gvc;

    public Tablero(GameViewController gvc) {
        this.gvc = gvc;
        gvc.addBoarCellObserver("Tablero", this);
        this.rows = GameControler.getSizeY();
        this.columns = GameControler.getSizeX();
        this.cells = new Casilla[rows][columns];
        setLayout(new GridLayout(rows, columns));
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                final int filaActual = i;
                final int columnaActual = j;
                this.cells[filaActual][columnaActual] = new Casilla(gvc);
                this.cells[filaActual][columnaActual].addActionListener(e -> {
                    if (GameControler.isNotGenerated() && this.cells[filaActual][columnaActual].IsNotBlocket()) {
                        GameControler.BoardGenerated(filaActual, columnaActual);
                        this.gvc.InitTimer("Timer");
                    }
                    if (this.cells[filaActual][columnaActual].IsNotBlocket() && this.cells[filaActual][columnaActual].loketAll == false) {
                        updateCell(GameControler.fnBoarRevealer(filaActual, columnaActual));
                    }
                });
                add(this.cells[filaActual][columnaActual]);
            }
        }
    }

    private void updateCell(int[][] boardReveler) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                final int filaActual = i;
                final int columnaActual = j;
                if (this.cells[filaActual][columnaActual].IsNotBlocket()) {
                    TipoDecasilla(boardReveler, filaActual, columnaActual);
                    if (boardReveler[filaActual][columnaActual] == variablesGame.MinaTocada) {
                        boarPause(GameControler.FnFinpartida(), boardReveler);
                        return;
                    }
                }
            }
        }
    }

    private void boarPause(int[][] boar, int[][] boardReveler) {
        gvc.StopTimer("Timer");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                final int filaActual = i;
                final int columnaActual = j;
                this.cells[filaActual][columnaActual].loketAll = true;
                if (boar[i][j] == variablesGame.MINA && boardReveler[i][j] != variablesGame.MinaTocada) {
                    this.cells[filaActual][columnaActual].AdaptedImage(LoaderImage.getImageIcon(LoaderImage.MINA2));
                }
            }
        }
    }

    @Override
    public void resetCell() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                final int filaActual = i;
                final int columnaActual = j;

                this.cells[filaActual][columnaActual].loketAll = false;
                this.cells[filaActual][columnaActual].fnUnlock();
                this.cells[filaActual][columnaActual]
                        .AdaptedImage(LoaderImage.getImageIcon(LoaderImage.CASILLA_TAPADA));

            }
        }
    }

    public void TipoDecasilla(int[][] boar, int filaActual, int columnaActual) {
        switch (boar[filaActual][columnaActual]) {
            case variablesGame.casillasReveladas:
                this.cells[filaActual][columnaActual].loketAll = true;
                this.cells[filaActual][columnaActual]
                        .AdaptedImage(LoaderImage.getImageIcon(LoaderImage.CASILLA_DESTAPADA));
                break;
            case variablesGame.MinaTocada:
                this.cells[filaActual][columnaActual].loketAll = true;
                this.cells[filaActual][columnaActual].AdaptedImage(LoaderImage.getImageIcon(LoaderImage.MINA));
                break;
            case 1:
                this.cells[filaActual][columnaActual].loketAll = true;
                this.cells[filaActual][columnaActual].AdaptedImage(LoaderImage.getImageIcon(LoaderImage.UNO));
                break;
            case 2:
                this.cells[filaActual][columnaActual].loketAll = true;
                this.cells[filaActual][columnaActual].AdaptedImage(LoaderImage.getImageIcon(LoaderImage.DOS));
                break;
            case 3:
                this.cells[filaActual][columnaActual].loketAll = true;
                this.cells[filaActual][columnaActual].AdaptedImage(LoaderImage.getImageIcon(LoaderImage.TRES));
                break;
            case 4:
                this.cells[filaActual][columnaActual].loketAll = true;
                this.cells[filaActual][columnaActual].AdaptedImage(LoaderImage.getImageIcon(LoaderImage.CUATRO));
                break;
            case 5:
                this.cells[filaActual][columnaActual].loketAll = true;
                this.cells[filaActual][columnaActual].AdaptedImage(LoaderImage.getImageIcon(LoaderImage.CINCO));
                break;
            case 6:
                this.cells[filaActual][columnaActual].loketAll = true;
                this.cells[filaActual][columnaActual].AdaptedImage(LoaderImage.getImageIcon(LoaderImage.SEIS));
                break;
            case 7:
                this.cells[filaActual][columnaActual].loketAll = true;
                this.cells[filaActual][columnaActual].AdaptedImage(LoaderImage.getImageIcon(LoaderImage.SIETE));
                break;
            case 8:
                this.cells[filaActual][columnaActual].loketAll = true;
                this.cells[filaActual][columnaActual].AdaptedImage(LoaderImage.getImageIcon(LoaderImage.OCHO));
                break;
        }
    }

    @Override
    public void setStylePanel() {

    }
}