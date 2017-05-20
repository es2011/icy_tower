import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class ExtractScore {
	
	private static String score;
	private static String image;

	//args[0]- icy tower stats location
	//args[1]- score.properties location
	//args[2]- number of miliis to sleep before closing image
	//args[3]- photo program
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		// C:\\games\\icytower1.5\\profiles\\icy\\icy_stats.txt
		Stream<String> l=Files.lines(FileSystems.getDefault().getPath(args[0]));
		Pattern pattern = Pattern.compile("Best score ever:\\s+(\\d+)");
		l.map(pattern::matcher)
		.filter(Matcher::find)
		.findFirst()
		.ifPresent(matcher -> score=matcher.group(1));

		l.close();
		
		
		Stream<String> l2 =Files.lines(FileSystems.getDefault().getPath(args[1]));
		l2.filter(n->n.startsWith("INF") || Integer.parseInt(n.split(" ")[0]) > Integer.parseInt(score)).findFirst().ifPresent(n-> image=n.split(" ")[1]);;
		
		l2.close();
		Desktop dt = Desktop.getDesktop();
	    dt.open(new File(image));
	    
	    Thread.sleep(Integer.parseInt(args[2]));
	    //args[3]=WLXPhotoGallery
	    String strCmdLine = String.format("TaskKill /F /IM " + args[3]+"*");
	    Runtime.getRuntime().exec(strCmdLine);
	    
//		byte[] bytes =QRCode.from(score).to(ImageType.JPG).withSize(250, 250).stream().toByteArray();
//		FileOutputStream fileOutputStream = new FileOutputStream(args[1]/*"c:\\efrat\\test.jpg"*/);
//		fileOutputStream.write(bytes);
//		fileOutputStream.close();
		System.exit(0);
	}
}
