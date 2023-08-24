package obj.gui.Interfaces;

public interface GameViewObservable {

    public void addDispleyObserver(String name, InterfaceDisplay display);

    public void removeDispleyObserver(String name);

    public void notifyDispleyObserver(String name);

    public void addBoarCellObserver(String name, InterfaceBoardCell boar);

    public void removeBoarCellObserver(String name);

    public void notifyBoarCellObserver(String name);

}