import java.io.File;
import java.io.IOException;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;


public class GameOverRecognition {
	public static void main(String[] args) throws IOException, InterruptedException {

		ScreenRegion r = null;
		Target imageTarget = new ImageTarget(new File("game_over.jpg"));
		ScreenRegion s = new DesktopScreenRegion();
		while (r == null) {
			r = s.wait(imageTarget,10000);
		}
		System.exit(0);	
	}

}
