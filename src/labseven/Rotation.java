package labseven;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Rotation {
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        String file = "D:\\Java Programs\\DigitalImageProcessingLab\\src\\labseven\\assets\\KAVIRAJ_SINGH_BHATI-JIETCS19107.jpg";
        Mat src = Imgcodecs.imread(file);

        // Creating an empty matrix to store the result
        Mat dst = new Mat();

        // Creating a Point object
        Point point = new Point(100, 120);

        // Creating the transformation matrix M
        Mat rotationMatrix = Imgproc.getRotationMatrix2D(point, 65, 0.5);

        // Creating the object of the class Size
        Size size = new Size(src.cols(), src.cols());

        // Rotating the given image
        Imgproc.warpAffine(src, dst, rotationMatrix, size);

        String file2="D:\\Java Programs\\DigitalImageProcessingLab\\src\\labseven\\assets\\rotation.jpg";

        // Writing the image
        Imgcodecs.imwrite(file2, dst);
        System.out.println("Image Processed");
    }
}
