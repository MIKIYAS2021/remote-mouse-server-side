import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import static java.awt.event.KeyEvent.*;

public class Server {

    private static final int SERVER_PORT = 9000;
    private static String str;
    private static boolean connect = true;

    private static Robot robot;


    public static void main(String[] args) throws AWTException, IOException, NumberFormatException {



        DatagramSocket server1 = new DatagramSocket(SERVER_PORT);
        byte[] by = new byte[1024];
        DatagramPacket recieve = new DatagramPacket(by, by.length);
        new GUIforServer();
        robot = new Robot();


        System.out.println("waiting............");
        while (true) {


            if (connect) {


                server1.receive(recieve);

                str = new String(recieve.getData(), 0, recieve.getLength());

                if(str.contains(",")){
                    float movex=Float.parseFloat(str.split(",")[0]); //extract movement in x direction
                    float movey=Float.parseFloat(str.split(",")[1]); //extract movement in y direction
                    Point point = MouseInfo.getPointerInfo().getLocation(); //Get current mouse position
                    float nowx=point.x;
                    float nowy=point.y;

                    robot.mouseMove((int)(nowx+1.5*movex),(int)(nowy+1.5*movey));//Move mouse pointer to new location
                }

                switch (str) {

                    case "left":
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                        break;
                    case "right":
                        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                        break;
                    case "press":
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        break;
                    case "release":
                        robot.mouseRelease(BUTTON1_DOWN_MASK);
                        break;
                    case "copy":
                        robot.keyPress(VK_CONTROL);
                        robot.keyPress(VK_C);
                        robot.keyRelease(VK_C);
                        robot.keyRelease(VK_CONTROL);
                        break;
                    case "paste":
                        robot.keyPress(VK_CONTROL);
                        robot.keyPress(VK_V);
                        robot.keyRelease(VK_V);
                        robot.keyRelease(VK_CONTROL);
                        break;
                    case "undo":
                        robot.keyPress(VK_CONTROL);
                        robot.keyPress(VK_Z);
                        robot.keyRelease(VK_Z);
                        robot.keyRelease(VK_CONTROL);
                        break;
                    case "redo":
                        robot.keyPress(VK_CONTROL);
                        robot.keyPress(VK_Y);
                        robot.keyRelease(VK_Y);
                        robot.keyRelease(VK_CONTROL);
                        break;
                    case "play":
                        robot.keyPress(VK_SPACE);
                        robot.keyRelease(VK_SPACE);
                        break;
                    case "cut":
                        robot.keyPress(VK_CONTROL);
                        robot.keyPress(VK_X);
                        robot.keyRelease(VK_X);
                        robot.keyRelease(VK_CONTROL);
                        break;
                    case "win":
                        robot.keyPress(VK_WINDOWS);
                        robot.keyRelease(VK_WINDOWS);
                        break;
                    case "pgup":
                        robot.keyPress(VK_PAGE_UP);
                        robot.keyRelease(VK_PAGE_UP);
                        break;
                    case "pgdn":
                        robot.keyPress(VK_PAGE_DOWN);
                        robot.keyRelease(VK_PAGE_DOWN);
                        break;
                    case "home":
                        robot.keyPress(VK_HOME);
                        robot.keyRelease(VK_HOME);
                        break;
                    case "end":
                        robot.keyPress(VK_END);
                        robot.keyRelease(VK_END);
                        break;
                    case "delete":
                        robot.keyPress(VK_DELETE);
                        robot.keyRelease(VK_DELETE);
                        break;
                    case "prtsc":
                        robot.keyPress(VK_PRINTSCREEN);
                        robot.keyRelease(VK_PRINTSCREEN);
                        break;
                    case "esc":
                        robot.keyPress(VK_ESCAPE);
                        robot.keyRelease(VK_ESCAPE);
                        break;
                    case "enter":
                        robot.keyPress(VK_ENTER);
                        robot.keyRelease(VK_ENTER);
                        break;
                    case "space":
                        robot.keyPress(VK_SPACE);
                        robot.keyRelease(VK_SPACE);
                        break;
                    case "uparrow":
                        Runtime r = Runtime.getRuntime();
                        r.exec("cmd");
                        break;
                    case "downarrow":
                        robot.keyPress(VK_DOWN);
                        robot.keyRelease(VK_DOWN);
                        break;
                    case "rightarrow":
                        robot.keyPress(VK_RIGHT);
                        robot.keyRelease(VK_RIGHT);
                        break;
                    case "leftarrow":
                        robot.keyPress(VK_LEFT);
                        robot.keyRelease(VK_LEFT);
                        break;
                    case "shutdown":
                        Runtime ra = Runtime.getRuntime();
                        ra.exec("shutdown -r -t 1");
                        break;
                    case "sleep":
                        robot.keyPress(VK_ALT);
                        robot.keyPress(VK_F4);
                        robot.keyRelease(VK_F4);
                        robot.keyRelease(VK_ALT);
                        robot.keyPress(VK_UP);
                        robot.keyRelease(VK_UP);
                        robot.keyPress(VK_ENTER);
                        robot.keyRelease(VK_ENTER);
                        break;
                    case "restart":
                        robot.keyPress(VK_ALT);
                        robot.keyPress(VK_F4);
                        robot.keyRelease(VK_F4);
                        robot.keyRelease(VK_ALT);
                        robot.keyPress(VK_DOWN);
                        robot.keyRelease(VK_DOWN);
                        robot.keyPress(VK_ENTER);
                        robot.keyRelease(VK_ENTER);
                        break;
                    case "disconnect":
                        connect = false;


                }
            }
            else
            {
                continue;
            }
        }

    }
}