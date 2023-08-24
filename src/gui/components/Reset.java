package gui.components;

import java.awt.Color;

import obj.controlers.GameControler;
import obj.controlers.GameViewController;

// import javax.swing.Box;
// import javax.swing.BoxLayout;

import obj.gui.components.ComponentPanel;

public class Reset extends ComponentPanel {

    public Reset(GameViewController gvc) {
        CasillaReset reset = new CasillaReset();

        reset.addActionListener(e -> {
            System.out.println("Reset");
            GameControler.ResetBoard();
            gvc.fnRestCell("Tablero");
            gvc.ResetMineCounter("CantidadMinas");
            try {
                gvc.StopTimer("Timer");
                gvc.fnSetCounter("Timer", 0);
            } catch (Exception exception) {
                System.out.println(exception);
            }
            
        });

        //add(Box.createHorizontalGlue());
        add(reset);
        //add(Box.createHorizontalGlue());
    }

    @Override
    public void setStylePanel() {
        setBackground(Color.gray);
        //setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }
}