package screenFunctions;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
public class FormatFunctions {

    public static void titleDelay() {
        Random rand = new Random();

        try {
            TimeUnit.SECONDS.sleep(rand.nextInt(5) + 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
