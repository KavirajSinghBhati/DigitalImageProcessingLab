package labsix;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class InverseAndColor {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labsix\\assets\\ghar.jpg");
        BufferedImage img = ImageIO.read(f1); //red
        BufferedImage img2 = ImageIO.read(f1);  //blue
        int width = img.getWidth();
        int height = img.getHeight();
        for (int i = 0; i < height; i++) {
            for (int j = width - 1, k = 0; j >= 0; j--, k++) {
                int pixel = img.getRGB(j, i);
                img.setRGB(k, i, pixel);
            }
        }
        for (int i = height - 1, k = 0; i >= height / 2; i--, k++) {
            for (int j = 0; j < width; j++) {
                int p = img2.getRGB(j, i);
                img2.setRGB(j, k, p);
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = width / 2; j < width; j++) {
                int pixel = img.getRGB(j, i);
                int alpha = (pixel >> 24) & 0xff, red = (pixel >> 16) & 0xff, green = (pixel >> 8) & 0xff, blue = (pixel) & 0xff;
                red = 255 - red;
                pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                img.setRGB(j, i, pixel);
            }
        }

        for (int i = 0; i < height / 2; i++) {
            for (int j = 0; j < width; j++) {
                int pixel = img2.getRGB(j, i);
                int alpha = (pixel >> 24) & 0xff, red = (pixel >> 16) & 0xff, green = (pixel >> 8) & 0xff, blue = (pixel) & 0xff;
                blue = 255 - blue;
                pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                img2.setRGB(j, i, pixel);
            }
        }
        File f2 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labsix\\assets\\ghar-trans.jpg");
        ImageIO.write(img, "jpg", f2);

        File f3 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labsix\\assets\\ghar-trans-2.jpg");
        ImageIO.write(img2, "jpg", f3);
    }
}
