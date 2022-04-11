package Pages;


import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class BasePage {
    public static WebDriver driver;
    public static Properties prop;
    public static Logger log = Logger.getLogger(String.valueOf(BasePage.class));

    public BasePage() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            prop.load(fis);
            log.info("properties loaded");
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
