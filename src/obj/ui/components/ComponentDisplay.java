package obj.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
// import javax.swing.Box;
// import javax.swing.BoxLayout;
// import javax.swing.JLabel;
import javax.swing.SwingConstants;

import graphics.Loader;
import obj.ui.interfaces.ComponentStyleDefaul;
import obj.ui.interfaces.InterfaceDisplay;

public abstract class ComponentDisplay extends ComponentLabel implements InterfaceDisplay, ComponentStyleDefaul {

    private Timer timer;

    final private int COUNTER_MAX = 999;

    private int Counter;

    // private JLabel CounterLabel;

    public ComponentDisplay() {
        this(0);
    };

    public ComponentDisplay(int counter) {
        Counter = counter;
        Updatetext();
    }

    @Override
    public void setStyleDefaul() {
        final int Top = 0;
        final int bottom = 0;
        final int Left = 10;
        final int right = 10;

        final float FontSize = 30f;

        //setText("888");

        // Estilo y tamaño del label
        setFont(Loader.loadFont("digital-7 (mono).ttf", FontSize));
        setBorder(BorderFactory.createEmptyBorder(Top, Left, bottom, right));
        //setForeground(new Color(128, 0, 0));
        setForeground(new Color(225, 40, 40));

        // Establece el color de fondo del JLabel
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);

        setPreferredSize(new Dimension(70, 0));
        setHorizontalAlignment(SwingConstants.CENTER);
        //setStyleDefaulSublabel();
    }

    /* 

    public void setStyleDefaulSublabel() {
        CounterLabel = new JLabel();
        CounterLabel.setFont(getFont());
        CounterLabel.setForeground(new Color(225, 40, 40));

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(Box.createHorizontalGlue());
        add(CounterLabel);
        add(Box.createHorizontalGlue());
    }

    public JLabel getlabelCounter(){
        return CounterLabel;
    }

    private void Updatetext() {
        this.CounterLabel.setText(String.format("%03d", Counter));
    }

    */

    private void Updatetext() {
        setText(String.format("%03d", Counter));
    }

    @Override
    public int getCounter() {
        return Counter;
    }

    @Override
    public void setCounter(int Counter) {
        if (Counter > COUNTER_MAX) {
            this.Counter = COUNTER_MAX;
        } else {
            this.Counter = Counter;
        }

        Updatetext();
    }

    @Override
    public void init() {
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Counter++;
                setCounter(Counter);
            }
        }, 0, 1000);
    }

    @Override
    public void stop() {
        this.timer.cancel();
    }
}