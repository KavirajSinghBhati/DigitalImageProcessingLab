package labthree;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MirrorImageThree {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labthree\\image\\image.jpg");
        BufferedImage img = ImageIO.read(f1);
        BufferedImage mimg = ImageIO.read(f1);
        int width = img.getWidth();
        int height = img.getHeight();
        for (int i = 0; i < height; i++) {
            for (int j = 0, k = width - 1; j < width; j++, k--) {
                int p = img.getRGB(j, i);
                mimg.setRGB(k, i, p);
            }
        }
        for (int i = 0, k = height - 1; i < height; i++, k--) {
            for (int j = 0; j < width; j++) {
                int p = img.getRGB(j, i);
                mimg.setRGB(j, k, p);
            }
        }
        File f2 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labthree\\image\\newgenthree.jpg");
        ImageIO.write(mimg, "jpg", f2);
    }
}
