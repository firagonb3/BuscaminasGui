package obj.gui.components;

import javax.swing.JLabel;

public abstract class ComponentLabel extends JLabel {
    {
        setStyleDefaul();
        setStyleLabel();
    }

    public abstract void setStyleLabel();

    public void setStyleDefaul() {

    }
}
