package labeight;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.RotatedRect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class WriteOnImage {
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    public static void main(String[] args) {
        Imgcodecs im = new Imgcodecs();
        String file = "D:\\Java Programs\\DigitalImageProcessingLab\\src\\labeight\\assets\\ghar.jpg";
        Mat src = im.imread(file);
        System.out.println("Image loaded");

        Scalar color = new Scalar(250, 255, 0);
        Scalar color1 = new Scalar(10, 205, 1);
        Scalar color2 = new Scalar(205, 192, 203);

        // drawing a circle

        Imgproc.circle(src, new Point(2304, 864), 100, color1, 10);

        // drawing a line

        Imgproc.line(src, new Point(2304, 960), new Point(576, 1728), color1, 10);

        Imgproc.line(src, new Point(2304, 960), new Point(4032, 1728), color1, 10);

        Imgproc.line(src, new Point(576, 1728), new Point(4032, 1728), color1, 10);

        // drawing text

        Imgproc.putText(src, "Dept.", new Point(2140, 1200), Core.FONT_HERSHEY_COMPLEX, 4, new Scalar(0, 0, 0), 10);

        Imgproc.putText(src, "of", new Point(2240, 1350), Core.FONT_HERSHEY_COMPLEX, 4, new Scalar(0, 0, 0), 10);

        Imgproc.putText(src, "Computer Science", new Point(1750, 1500), Core.FONT_HERSHEY_COMPLEX, 4, new Scalar(0, 0, 0), 10);

        // rectangle

        Imgproc.line(src, new Point(576, 1728), new Point(576, 3000), color1, 10);

        Imgproc.line(src, new Point(4032, 1728), new Point(4032, 3000), color1, 10);

        Imgproc.line(src, new Point(576, 3000), new Point(4032, 3000), color1, 10);

        // drawing ellipse

        Imgproc.ellipse(src, new RotatedRect(new Point(1800, 2361), new Size(600, 1300), 90), color1, 10);

        // text

        Imgproc.putText(src, "Name :- Kaviraj", new Point(1350, 2300), Core.FONT_HERSHEY_COMPLEX, 2, color, 7);

        Imgproc.putText(src, "Roll No :- 078", new Point(1350, 2490), Core.FONT_HERSHEY_COMPLEX, 2, color, 7);

        String file2 = "D:\\Java Programs\\DigitalImageProcessingLab\\src\\labeight\\assets\\ghar-alpha.jpg";
        im.imwrite(file2, src);
    }
}
