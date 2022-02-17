package labtwo;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ConvertColouredToGrayScale {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labtwo\\image\\20201028_085146.jpg");
        BufferedImage img = ImageIO.read(f1);
        int width = img.getWidth();
        int height = img.getHeight();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int pixel = img.getRGB(j, i);
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel & 0xff);

                int avg = (red + green + blue) / 3;
                pixel = (alpha << 24) | (avg << 16) | (avg << 8) | avg;
                img.setRGB(j, i, pixel);
            }
        }
        File f2 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labtwo\\image\\greyishmeatrayta.jpg");
        ImageIO.write(img, "jpg", f2);
    }
}

/*
* take every pixel. find its R G B values and convert them to their individual grey colour
*
* pixel =     -----alpha---- | -----red----- | -----green----- | -----blue-----
*bits = 32    31 - 24         |   23 - 16     |    15 - 8      |    7 - 0          each 8 bits
*  */
