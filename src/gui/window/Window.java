package gui.window;

import javax.swing.JFrame;

import gui.window.Layouts.MainLayout;

public class Window extends JFrame {
    public Window() {
        setTitle("Buscaminas"); // Titulo de la vent
        setSize(400, 350); // Tamaño de la vent
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cerrar al cerrarse el frame
        setLocationRelativeTo(null); // Centrar en pantalla
        setResizable(false); // Bloquea la ventana para que no sea redimensionable

        add(new MainLayout());
        pack();
    }
}
