package gui.components;

import javax.swing.ImageIcon;

import java.awt.event.MouseEvent;

import obj.gui.components.ComponentCell;
import resources.graphics.LoaderImage;

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
