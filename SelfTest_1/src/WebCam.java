import com.github.sarxos.webcam.Webcam;

public class WebCam {

	public static void main(String[] args) {
		System.out.println("Opening webcam");
		
		Webcam wc = Webcam.getDefault();
	}

}
