package labtwo;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RGBValueOfImage {
    public static void main(String[] args) throws IOException {
        File f1 = new File("F:\\KAVIRAJ_SINGH_BHATI-JIETCS19107.jpg");
        BufferedImage img = ImageIO.read(f1);
        int count = 0;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Color c = new Color(img.getRGB(j, i));  // getRGB(j, i); j => left to right   |   i => top to bottom
                count++;
                System.out.println("S.No. " + count + " Red: " + c.getRed() + " Green: " + c.getGreen() + " Blue: " + c.getBlue());
            }
        }
    }
}
