package obj.gui.components;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import graphics.LoaderImage;
import obj.gui.Interfaces.ComponentStyleDefaul;

public abstract class ComponentCell extends ComponentButton implements MouseListener, ComponentStyleDefaul {

    private boolean flag = false;
    private boolean isNotBloked = true;

    public abstract void fnMouseClicked(MouseEvent e);

    public abstract void fnMousePressed(MouseEvent e);

    public abstract void fnMouseReleased(MouseEvent e);

    public abstract void fnMouseEntered(MouseEvent e);

    public abstract void fnMouseExited(MouseEvent e);

    public ComponentCell() {
        addMouseListener(this);
    }

    public void AdaptedImage(ImageIcon icon) {
        int width = icon.getIconWidth();
        int height = icon.getIconHeight();

        setIcon(icon);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
    }

    @Override
    public void setStyleDefaul() {
        ImageIcon imageicon = LoaderImage.getImageIcon(LoaderImage.CASILLA_TAPADA);
        AdaptedImage(imageicon);
        setBorder(null);
    }

    public boolean IsNotBlocket() {
        return flag ? false : true;
    }

    public void fnUnlock() {
        flag = false;
    }

    public void lockedFnClicks(boolean x) {
        this.isNotBloked = x ? false : true;
    }

    public boolean loketAll = false;

    @Override
    public void mouseClicked(MouseEvent e) {
        if (loketAll == false) {
            if (SwingUtilities.isRightMouseButton(e) && isNotBloked) {
                flag = flag ? false : true;
                setIcon(LoaderImage.getImageIcon(flag ? LoaderImage.RED_FLAG : LoaderImage.CASILLA_TAPADA));
            }
            fnMouseClicked(e);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (loketAll == false) {
            if (SwingUtilities.isLeftMouseButton(e) && flag == false && isNotBloked) {
                setIcon(LoaderImage.getImageIcon(LoaderImage.CASILLA_DESTAPADA));
            }
            fnMousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (loketAll == false) {
            if (SwingUtilities.isLeftMouseButton(e) && flag == false && isNotBloked) {
                setIcon(LoaderImage.getImageIcon(LoaderImage.CASILLA_TAPADA));
            }
            fnMouseReleased(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
