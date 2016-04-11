package main;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.Objdetect;

class LeafDetectDemo {
    public void run() {
        System.out.println("\nRunning DetectLeafDemo");
        CascadeClassifier leafDetector = new CascadeClassifier("src/main/resources/cascade.xml");

         Mat image = Imgcodecs.imread("src/main/resources/maiden1.jpg");

        MatOfRect leafDetections = new MatOfRect();


        leafDetector.detectMultiScale(image, leafDetections, 1.2, 4, Objdetect.CASCADE_FIND_BIGGEST_OBJECT,
                new Size(20.0, 20.0), new Size());

        System.out.println(String.format("Detected %s leafs", leafDetections.toArray().length));

        for (Rect rect : leafDetections.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }
        String filename = "src/main/resources/leafDetectionMaidenHairLeaf_2.jpg";
        System.out.println(String.format("Writing %s", filename));
        Imgcodecs.imwrite(filename, image);
    }
}

