package labseven;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Scaling {
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        String file = "D:\\Java Programs\\DigitalImageProcessingLab\\src\\labseven\\assets\\KAVIRAJ_SINGH_BHATI-JIETCS19107.jpg";
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
