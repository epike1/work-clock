package screenFunctions;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
public class FormatFunctions {

	public static JFrame frame = new JFrame();
	
    public static void titleDelay() {
        Random rand = new Random();

        try {
            TimeUnit.SECONDS.sleep(rand.nextInt(5) + 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void errorMessage(String subject, String explanation) { // if invalid input was entered
        JOptionPane.showMessageDialog(frame, explanation, subject, JOptionPane.ERROR_MESSAGE);
    }


}
