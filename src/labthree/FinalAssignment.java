package labthree;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.util.Scanner;


public class FinalAssignment {
    public static void main(String[] args) throws IOException {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Image Transformation Program");
        System.out.println("Pl. enter the file path: ");
        String path = sc.nextLine();
        System.out.println("1. Mirror along X-Axis");
        System.out.println("2. Mirror along y-Axis");
        System.out.println("3. Mirror diagonally");
        System.out.println("1. Exit");
        System.out.println("Pl. enter your choice: ");
        choice = sc.nextInt();
        switch (choice) {
            case 1 -> mirrorAlongYAxis(path);
            case 2 -> mirrorAlongXAxis(path);
            case 3 -> mirrorAlongDiagonal(path);
            case 4 -> System.exit(0);
            default -> System.out.println("Wrong choice!");
        }
    }

    static void mirrorAlongYAxis(String path) throws IOException {
        File f1 = new File(path);
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
        File f2 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labthree\\image\\finalassignment.png");
        ImageIO.write(mimg, "png", f2);
        System.out.println("Successfully saved image.");
    }

    static void mirrorAlongXAxis(String path) throws IOException {
        File f1 = new File(path);
        BufferedImage img = ImageIO.read(f1);
        BufferedImage mimg = ImageIO.read(f1);
        int width = img.getWidth();
        int height = img.getHeight();
        for (int i = 0, k = height - 1; i < height; i++, k--) {
            for (int j = 0; j < width; j++) {
                int p = img.getRGB(j, i);
                mimg.setRGB(j, k, p);
            }
        }
        File f2 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labthree\\image\\finalassignment.png");
        ImageIO.write(mimg, "png", f2);
        System.out.println("Successfully saved image.");
    }

    static void mirrorAlongDiagonal(String path) throws IOException {
        File f1 = new File(path);
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
        File f2 = new File("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labthree\\image\\finalassignment.png");
        ImageIO.write(mimg, "png", f2);
        System.out.println("Successfully saved image.");
    }
}
