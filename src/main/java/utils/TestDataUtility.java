package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestDataUtility {
    public static String time;
    public static int numberOfCheckboxes;

    static {
        ISettingsFile environment = new JsonSettingsFile("testData.json");
        time = environment.getValue("/time").toString();
        numberOfCheckboxes = Integer.parseInt(environment.getValue("/numberOfCheckboxes").toString());
    }
}
