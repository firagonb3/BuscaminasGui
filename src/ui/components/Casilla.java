package ui.components;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import obj.controlers.GameViewController;
import obj.ui.components.ComponentCell;

public class Casilla extends ComponentCell {

    private boolean isAdd = false;
    private GameViewController gvc;


    public Casilla(GameViewController gvc) {
        super();
        this.gvc = gvc;
    }

    @Override
    public void setStyleButton() {

    }

    @Override
    public void fnMouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            if (isAdd) {
                gvc.incrementarContador("CantidadMinas");
            } else {
                gvc.decrementarContador("CantidadMinas");
            }
            isAdd = !isAdd;
        }
    }

    @Override
    public void fnMousePressed(MouseEvent e) {
    }

    @Override
    public void fnMouseReleased(MouseEvent e) {
    }

    @Override
    public void fnMouseEntered(MouseEvent e) {
    }

    @Override
    public void fnMouseExited(MouseEvent e) {
    }
}
