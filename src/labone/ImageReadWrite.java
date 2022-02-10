package labone;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageReadWrite {
    public static void main(String[] args) throws IOException {
        File f1 = new File("F:\\KAVIRAJ_SINGH_BHATI-JIETCS19107.jpg");
        BufferedImage img = ImageIO.read(f1);
        File f2 = new File("E:\\newly-saved.jpg");
        ImageIO.write(img, "jpg", f2);
        int width = img.getWidth();
        int height = img.getHeight();
        System.out.println("Resolution: " + width + " * " + height);
    }
}
