package utils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import static utils.ConfigDataUtility.imagePath;

public class ImageUtils {
    public static void uploadImage() throws AWTException {
        Robot rb = new Robot();

        String path = System.getProperty("user.dir") + imagePath;

        StringSelection str = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        rb.delay(250);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.delay(150);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
}