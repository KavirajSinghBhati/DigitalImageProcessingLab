package labthree;

import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MirrorImage {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labthree\\image\\image.jpg");
        BufferedImage img = ImageIO.read(f1);
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage mimg = ImageIO.read(f1);
        for (int i = 0; i < height; i++) {
            for (int j = 0, k = width - 1; j < width; j++, k--) {
                int p = img.getRGB(j, i);
                mimg.setRGB(k, i, p);
            }
        }
        File f2 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labthree\\image\\newgen.jpg");
        ImageIO.write(mimg, "jpg", f2);
    }
}
