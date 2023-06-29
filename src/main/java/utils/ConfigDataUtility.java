package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class ConfigDataUtility {
    public static String imagePath;
    public static String url;

    static {
        ISettingsFile environment = new JsonSettingsFile("configData.json");
        imagePath = environment.getValue("/relativePathImg").toString();
        url = environment.getValue("/url").toString();
    }
}