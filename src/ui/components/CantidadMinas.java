package ui.components;

import obj.controlers.GameControler;
import obj.controlers.GameViewController;
import obj.ui.components.ComponentDisplay;

public class CantidadMinas extends ComponentDisplay {

    public CantidadMinas(GameViewController gvc) {
        super(GameControler.getMine());
        gvc.addDispleyObserver("CantidadMinas", this);
    }

    @Override
    public void setStyleLabel() {
    }
}