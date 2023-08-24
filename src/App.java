import javax.swing.SwingUtilities;

import gui.window.Window;
import obj.controlers.GameControler;

public class App {
    public static void main(String[] args) {
        GameControler.InitializerBoard(20, 20, 99);

        SwingUtilities.invokeLater(() -> {
            Window win = new Window(); // Inicializar la instancia de la vent
            win.setVisible(true); // Hacer visible la ventana
        });
    }
}