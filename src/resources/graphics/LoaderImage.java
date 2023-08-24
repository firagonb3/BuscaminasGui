package resources.graphics;

import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.ImageIcon;

import obj.controlers.Loader;

public class LoaderImage {

    public static final int MINA = 0;
    public static final int MINA2 = 9;
    public static final int RED_FLAG = 11;
    public static final int CASILLA_TAPADA = 10;
    public static final int CASILLA_DESTAPADA = 12;
    public static final int RESET = 13;
    public static final int RESET2 = 14;

    public static final int UNO = 1;
    public static final int DOS = 2;
    public static final int TRES = 3;
    public static final int CUATRO = 4;
    public static final int CINCO = 5;
    public static final int SEIS = 6;
    public static final int SIETE = 7;
    public static final int OCHO = 8;

    static {
        loaderImage();
    }

    private static List<BufferedImage> images;

    private static void loaderImage() {
        images = Loader.ImagesLoader("Mina.png",
                "1.png",
                "2.png",
                "3.png",
                "4.png",
                "5.png",
                "6.png",
                "7.png",
                "8.png",
                "Mina2.png",
                "CasillaTapada.png",
                "CastillaBandera.png",
                "CsillaDestapada.png",
                "Reset.png",
                "Reset2.png");
    }

    public static ImageIcon getImageIcon(int index) {
        if (index >= 0 && index < images.size()) {
            return new ImageIcon(images.get(index));
        } else {
            return null;
        }
    }
}
