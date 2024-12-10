package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.UtilLibrary;

public class WebDriverBase {
    public WebDriver driver;
    public WebDriver getDriver() {
        if(driver == null)
            createDriver();
        return driver;
    }

    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(UtilLibrary.configProperties.getProperty("AppURL"));
    }

}
