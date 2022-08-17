/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konekcctv;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

/**
 *
 * @author WINDOWS 10
 */
public class Konekcctv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FrameGrabber.Exception {
        OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("http://192.168.0.2:8080/video?dummy=param.mjpg");
        frameGrabber.setFormat("mjpeg");
        frameGrabber.start();
        IplImage iPimg = frameGrabber.grab();
        CanvasFrame canvasFrame = new CanvasFrame("Camera");
        canvasFrame.setCanvasSize(iPimg.width(), iPimg.height());

        while (canvasFrame.isVisible() && (iPimg = frameGrabber.grab()) != null) {
            canvasFrame.showImage(iPimg);
        }
        frameGrabber.stop();
        canvasFrame.dispose();
        System.exit(0);
    }

}
