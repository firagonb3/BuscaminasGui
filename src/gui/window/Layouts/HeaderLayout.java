package gui.window.Layouts;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComponent;

import obj.gui.components.ComponentPanel;

public class HeaderLayout extends ComponentPanel {
    public HeaderLayout(JComponent ...jp ) {
        setLayout(new BorderLayout());
        add(jp[0], BorderLayout.WEST);
        add(jp[1], BorderLayout.CENTER);
        add(jp[2], BorderLayout.EAST);
    }

    @Override
    public void setStylePanel() {
        setBackground(Color.BLACK);
    }
}
