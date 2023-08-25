package obj.controlers;

import java.util.HashMap;
import java.util.Map;

import obj.ui.interfaces.GameViewObservable;
import obj.ui.interfaces.InterfaceBoardCell;
import obj.ui.interfaces.InterfaceDisplay;

public class GameViewController implements GameViewObservable {

    private Map<String, InterfaceDisplay> display = new HashMap<>();
    private Map<String, InterfaceBoardCell> boarCells = new HashMap<>();

    private void setCounterDyspley(String name, int iContador) {
        InterfaceDisplay dp = display.get(name);
        if (dp != null) {
            dp.setCounter(dp.getCounter() + iContador);
        } else {
            throw new RuntimeException("Componente no existente: " + name);
        }
    }

    public void InitTimer(String name) {
        InterfaceDisplay dp = display.get(name);
        if (dp != null) {
            dp.init();
        } else {
            throw new RuntimeException("Componente no existente: " + name);
        }
    }

    public void StopTimer(String name) {
        InterfaceDisplay dp = display.get(name);
        if (dp != null) {
            dp.stop();
        } else {
            throw new RuntimeException("Componente no existente: " + name);
        }
    }

    public void ResetMineCounter(String name) {
        InterfaceDisplay dp = display.get(name);
        if (dp != null) {
            dp.setCounter(GameControler.getMine());
        } else {
            throw new RuntimeException("Componente no existente: " + name);
        }
    }

    public void fnSetCounter(String name, int x) {
        InterfaceDisplay dp = display.get(name);
        if (dp != null) {
            dp.setCounter(x);
        } else {
            throw new RuntimeException("Componente no existente: " + name);
        }
    }

    public void fnRestCell(String name) {
        InterfaceBoardCell bc = boarCells.get(name);
        if (bc != null) {
            bc.resetCell();
        } else {
            throw new RuntimeException("Componente no existente: " + name);
        }
    }

    public void incrementarContador(String name) {
        setCounterDyspley(name, 1);
    }

    public void decrementarContador(String name) {
        setCounterDyspley(name, -1);
    }

    @Override
    public void addDispleyObserver(String name, InterfaceDisplay dipley) {
        display.put(name, dipley);
    }

    @Override
    public void removeDispleyObserver(String name) {
        display.remove(name);
    }

    @Override
    public void notifyDispleyObserver(String name) {
    }

    @Override
    public void addBoarCellObserver(String name, InterfaceBoardCell boar) {
        boarCells.put(name, boar);
    }

    @Override
    public void removeBoarCellObserver(String name) {
        boarCells.remove(name);
    }

    @Override
    public void notifyBoarCellObserver(String name) {
    }

}