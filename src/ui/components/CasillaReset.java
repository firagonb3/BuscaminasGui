package ui.components;

import javax.swing.ImageIcon;

import graphics.LoaderImage;
import obj.ui.components.ComponentCell;

import java.awt.event.MouseEvent;

public class CasillaReset extends ComponentCell {

    public CasillaReset() {
        super();
        lockedFnClicks(true);
    }

    @Override
    public void setStyleButton() {
        ImageIcon imageicon = LoaderImage.getImageIcon(LoaderImage.RESET);
        setIcon(imageicon);
        AdaptedImage(imageicon);
    }

    @Override
    public void fnMouseClicked(MouseEvent e) {
    }

    @Override
    public void fnMousePressed(MouseEvent e) {
        setIcon(LoaderImage.getImageIcon(LoaderImage.RESET2));
    }

    @Override
    public void fnMouseReleased(MouseEvent e) {
        setIcon(LoaderImage.getImageIcon(LoaderImage.RESET));
    }

    @Override
    public void fnMouseEntered(MouseEvent e) {
    }

    @Override
    public void fnMouseExited(MouseEvent e) {
    }

}
