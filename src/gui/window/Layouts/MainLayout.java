package gui.window.Layouts;

import gui.components.CantidadMinas;
import gui.components.Contador;
import gui.components.Reset;
import gui.components.Tablero;
import obj.controlers.GameViewController;
import obj.gui.components.ComponentPanel;

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
