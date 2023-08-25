package graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Loader {

    private final static String originPathImage = "res/img/";
    private final static String originPathFont = "res/font/";

    private Loader() {
    }

    public static Font loadFont(String path, float size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(originPathFont + path)).deriveFont(Font.BOLD, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<BufferedImage> ImagesLoader(String... paths) {
        List<BufferedImage> images = new ArrayList<>();
        try {
            for (String path : paths) {
                File file = new File(originPathImage, path);
                BufferedImage loadedImage = ImageIO.read(file);
                images.add(loadedImage);
            }
            return images;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}