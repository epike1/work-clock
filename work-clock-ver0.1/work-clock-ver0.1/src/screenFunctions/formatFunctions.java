package screenFunctions;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class formatFunctions {

    public static void titleDelay() {
        Random rand = new Random();

        try {
            TimeUnit.SECONDS.sleep(rand.nextInt(15));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
