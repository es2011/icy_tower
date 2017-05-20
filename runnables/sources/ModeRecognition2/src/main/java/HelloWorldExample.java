import java.io.File;
import java.io.IOException;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

public class HelloWorldExample {

     public static void main(String[] args) throws IOException, InterruptedException {

         
           // Create a screen region object that corresponds to the default monitor in full screen 
           ScreenRegion s = new DesktopScreenRegion();

           // Specify an image as the target to find on the screen
           Target imageTarget = new ImageTarget(new File("high_score.jpg"));// (imageURL);

           // Wait for the target to become visible on the screen for at most 5 seconds
           // Once the target is visible, it returns a screen region object corresponding
           // to the region occupied by this target
         
           ScreenRegion r = s.wait(imageTarget,1000000);
           // Display "Hello World" next to the found target for 3 seconds
           Canvas canvas = new DesktopCanvas();
           canvas.addLabel(r, "Hello World").display(3);

           // Click the center of the found target
           Mouse mouse = new DesktopMouse();
           mouse.click(r.getCenter());
     }
}