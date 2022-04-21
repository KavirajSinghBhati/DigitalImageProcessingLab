package labseven;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Translation {
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
    public static void main(String[] args) {
        String file = "D:\\Java Programs\\DigitalImageProcessingLab\\src\\labseven\\assets\\KAVIRAJ_SINGH_BHATI-JIETCS19107.jpg";
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
}
