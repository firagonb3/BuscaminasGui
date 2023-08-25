package ui.components;

import obj.controlers.GameViewController;
import obj.gui.components.ComponentDisplay;

public class Contador extends ComponentDisplay {

    public Contador(GameViewController gvc) {
        super();
        gvc.addDispleyObserver("Timer", this);
    }

    @Override
    public void setStyleLabel() {
    }
}
