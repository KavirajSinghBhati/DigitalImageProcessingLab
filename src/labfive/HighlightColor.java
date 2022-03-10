package labfive;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.util.Scanner;

public class HighlightColor {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Highlight Color Program");
            System.out.println("1. Highlight Cyan");
            System.out.println("2. Highlight Magenta");
            System.out.println("3. Highlight Yellow");
            System.out.println("4. Exit");
            System.out.println("Pl. enter your choice");
            choice = in.nextInt();

            switch (choice) {
                case 1 -> highlightCyan();
                case 2 -> highlightMagenta();
                case 3 -> highlightYellow();
                case 4 -> System.exit(0);
                default -> System.out.println("Wrong choice!");
            }
        }
    }
    static void highlightCyan() throws IOException {
        File f1 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labfive\\assets\\Ambrai-Restaurant-Udaipur.jpg");
        BufferedImage img = ImageIO.read(f1);
        int width = img.getWidth();
        int height = img.getHeight();
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int pixel = img.getRGB(x,y);
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;

                if ((blue + 100) <= 255) {
                    blue += 100;
                }
                else {
                    int rem = 255 - blue;
                    blue += rem - 10;
                }

                if ((green + 85) <= 255) {
                    blue += 85;
                }
                else {
                    int rem = 255 - green;
                    green += rem - 25;
                }

                pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                img.setRGB(x, y, pixel);

            }
        }
        File f2 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labfive\\assets\\Ambrai-Restaurant-Udaipur-cyan.jpg");
        ImageIO.write(img, "jpg", f2);
    }

    static void highlightMagenta() throws IOException {
        File f1 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labfive\\assets\\Ambrai-Restaurant-Udaipur.jpg");
        BufferedImage img = ImageIO.read(f1);
        int width = img.getWidth(), height = img.getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = img.getRGB(x, y);
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;

                // magenta = red + blue

                if ((red + 100) <= 255) {
                    red += 100;
                }
                else {
                    int rem = 255 - red;
                    red += rem - 30;
                }

                if ((blue + 85) <= 255) {
                    red += 85;
                }
                else {
                    int rem = 255 - blue;
                    blue += rem - 22;
                }

                pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                img.setRGB(x, y, pixel);
            }
        }
        File f2 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labfive\\assets\\Ambrai-Restaurant-Udaipur-magenta.jpg");
        ImageIO.write(img, "jpg", f2);
    }

    static void highlightYellow() throws IOException {
        File f1 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labfive\\assets\\Ambrai-Restaurant-Udaipur.jpg");
        BufferedImage img = ImageIO.read(f1);
        int width = img.getWidth(), height = img.getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = img.getRGB(x, y);
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;

                // yellow = red + green

                if ((red + 100) <= 255) {
                    red += 100;
                }
                else {
                    int rem = 255 - red;
                    red += rem - 30;
                }

                if ((green + 85) <= 255) {
                    green += 85;
                }
                else {
                    int rem = 255 - green;
                    green += rem - 22;
                }

                pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                img.setRGB(x, y, pixel);
            }
        }
        File f2 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labfive\\assets\\Ambrai-Restaurant-Udaipur-yellow.jpg");
        ImageIO.write(img, "jpg", f2);
    }
}
