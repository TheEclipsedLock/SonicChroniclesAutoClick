import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class AutoClick{

    //The time to wait between button holds and button presses
    private final int milliseconds = 30;

    //The object to simulate button presses
    private Robot robot;

    //Initializes the robot object
    public AutoClick() throws AWTException {
        robot = new Robot();
    }

    //Sets the mouse position towards the top left corner
    //So that when I position the emulator to the corner,
    //the mouse automatically clicks on it so it can then
    //enter button inputs.
    void setMousePosition(){
        robot.mouseMove(500, 700);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    /*
     * In the rest of the presses, it is necessary to introduce a delay inbetween the
     * keyPress and the keyRelease to simulate a press being held down for a small while.
     * Otherwise, it happens too fast for the game to register!
     *
     * It is also important to introduce a delay after the keyRelease in order to
     * avoid the emulator thinking we pressed 1 key when in fact 2 consecutive and
     * same keys were pressed!
     */

    void waiting(){
        robot.delay(1700);
    }

    void a_press(){
        robot.keyPress(KeyEvent.VK_A);
        robot.delay(milliseconds);
        robot.keyRelease(KeyEvent.VK_A);
        robot.delay(milliseconds);
    }

    void b_press(){
        robot.keyPress(KeyEvent.VK_B);
        robot.delay(milliseconds);
        robot.keyRelease(KeyEvent.VK_B);
        robot.delay(milliseconds);
    }

    void x_press(){
        robot.keyPress(KeyEvent.VK_X);
        robot.delay(milliseconds);
        robot.keyRelease(KeyEvent.VK_X);
        robot.delay(milliseconds);
    }

    void y_press(){
        robot.keyPress(KeyEvent.VK_Y);
        robot.delay(milliseconds);
        robot.keyRelease(KeyEvent.VK_Y);
        robot.delay(milliseconds);
    }

    void pooki(){
        b_press();
        a_press();
        b_press();
        y_press();
        b_press();
        a_press();
        b_press();
        y_press();
    }

    void fimbley(){
        a_press();
        a_press();
        x_press();
        b_press();
        y_press();
        b_press();
        a_press();
        x_press();
    }

    void baki(){
        b_press();
        a_press();
        x_press();
        y_press();
        a_press();
        b_press();
        y_press();
        x_press();
    }

    void stugs(){
        x_press();
        x_press();
        y_press();
        b_press();
        b_press();
        a_press();
        y_press();
        x_press();
    }


}