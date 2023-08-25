package obj.ui.components;

import javax.swing.JPanel;

public abstract class ComponentPanel extends JPanel{
    {
        setStyleDefaul();
        setStylePanel();
    }

    public abstract void setStylePanel();
    
    public void setStyleDefaul() {
        
    }
}