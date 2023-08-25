import javax.swing.SwingUtilities;

import obj.controlers.GameControler;
import ui.window.Window;

public class App {
    public static void main(String[] args) {
        GameControler.InitializerBoard(20, 20, 99);

        SwingUtilities.invokeLater(() -> {
            Window win = new Window(); // Inicializar la instancia de la vent
            win.setVisible(true); // Hacer visible la ventana
        });
    }
}