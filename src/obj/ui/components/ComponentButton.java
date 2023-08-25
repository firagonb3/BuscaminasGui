package obj.ui.components;

import javax.swing.JButton;

public abstract class ComponentButton extends JButton {
    {
        setStyleDefaul();
        setStyleButton();
    }

    public abstract void setStyleButton();

    public void setStyleDefaul() {

    }
}
