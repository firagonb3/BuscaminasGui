package ui.window.layouts;

import obj.controlers.GameViewController;
import obj.ui.components.ComponentPanel;
import ui.components.CantidadMinas;
import ui.components.Contador;
import ui.components.Reset;
import ui.components.Tablero;

import java.awt.BorderLayout;
import java.awt.Color;

public class MainLayout extends ComponentPanel {

    GameViewController gvc = new GameViewController();

    public MainLayout() {
        setLayout(new BorderLayout());
        add(new HeaderLayout(
                new CantidadMinas(gvc),
                new Reset(gvc),
                new Contador(gvc)), BorderLayout.NORTH);
        add(new Tablero(gvc), BorderLayout.CENTER);
    }

    

    @Override
    public void setStylePanel() {
        setBackground(Color.black);
    }
}
