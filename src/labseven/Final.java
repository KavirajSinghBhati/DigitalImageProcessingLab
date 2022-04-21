package labseven;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Final {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        String file = "D:\\Java Programs\\DigitalImageProcessingLab\\src\\labseven\\assets\\KAVIRAJ_SINGH_BHATI-JIETCS19107.jpg";
        translation(file);
        rotation(file);
        scaling(file);
    }

    static void translation(String file) {
        Mat src = Imgcodecs.imread(file);
        Mat dst = new Mat();
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point( src.cols() - 1, 0 );
        Point p3 = new Point( 0, src.rows() - 1 );
        Point p4 = new Point( src.cols()*0.0, src.rows()*1.33 );
        Point p5 = new Point( src.cols()*1.85, src.rows()*0.25 );
        Point p6 = new Point( src.cols()*0.15, src.rows()*0.7 );
        MatOfPoint2f ma1 = new MatOfPoint2f(p1,p2,p3);
        MatOfPoint2f ma2 = new MatOfPoint2f(p4,p5,p6);

        // Creating the transformation matrix

        Mat transformMatrix = Imgproc.getAffineTransform(ma1,ma2);

        Size size = new Size(src.cols(), src.cols());

        // Applying Wrap Affine
        Imgproc.warpAffine(src, dst, transformMatrix, size);
        Imgcodecs.imwrite("D:\\Java Programs\\DigitalImageProcessingLab\\src\\labseven\\assets\\translation.jpg", dst);
        System.out.println("Image Processed");
    }

    static void rotation(String file) {
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

    static void scaling(String file) {
        Mat src = Imgcodecs.imread(file);

        // Creating an empty matrix to store the result
        Mat dst = new Mat();

        // Creating the Size object
        Size size = new Size(src.rows()*0.5, src.rows()*0.5);

        // Scaling the Image
        Imgproc.resize(src, dst, size, 0, 0, Imgproc.INTER_AREA);

        String file2= "D:\\Java Programs\\DigitalImageProcessingLab\\src\\labseven\\assets\\scaling.jpg";

        // Writing the image
        Imgcodecs.imwrite(file2, dst);
        System.out.println("Image Processed");
    }
}
