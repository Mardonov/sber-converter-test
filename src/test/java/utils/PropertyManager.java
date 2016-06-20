package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class PropertyManager {

    public static void loadProperties() throws Exception {
        FileInputStream envFile;
        switch (System.getProperty("browserName")) {
            case "chrome":
                envFile = new FileInputStream("env\\chrome.properties");
                FileUtils.copyFile(new File("env\\chrome.properties"),new File("src\\test\\resources\\environment.properties"));
                break;
            case "firefox":
                envFile = new FileInputStream("env\\firefox.properties");
                FileUtils.copyFile(new File("env\\firefox.properties"),new File("src\\test\\resources\\environment.properties"));
                break;
        }
        envFile = new FileInputStream("src\\test\\resources\\environment.properties");
        Properties p = new Properties(System.getProperties());
        p.load(envFile);
        System.setProperties(p);
    }

}