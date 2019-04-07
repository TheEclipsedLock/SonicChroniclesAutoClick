import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainProgram {

    public static void main(String[] args) throws AWTException, IOException {

        long start = System.nanoTime();

        AutoClick autoClicker = new AutoClick();

        autoClicker.setMousePosition();

        //Initial testing to unlock the chao
        //autoClicker.baki();
        //autoClicker.fimbley();
        //autoClicker.pooki();
        //autoClicker.stugs();

        FileParser file = new FileParser(autoClicker);
        file.parseInitialFile();
        file.buttonPresses();

        long end = System.nanoTime();
        long elapsedTime = end - start;
        double seconds = (double)elapsedTime / 1_000_000_000.0;
        double minutes = seconds / 60;
        double hours = minutes / 60;
        System.out.println("This program ran for:");
        System.out.println(seconds + " seconds");
        System.out.println("Equivalent to:");
        System.out.println(minutes + " minutes");
        System.out.println("Equivalent to:");
        System.out.println(hours + " hours");

    }
}
