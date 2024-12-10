package base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.ExtentManager;
import utils.UtilLibrary;

import java.lang.reflect.Method;

public class TestBase {

    public static Logger log = LogManager.getLogger(TestBase.class);
    private static final String configFilePath = "\\src\\test\\resources\\config.properties";
    WebDriver driver;
    public ObjectBase app;

    @BeforeTest
    public void initialSetup() {
        ExtentManager.setupExtent();
        UtilLibrary.readConfigDataFile(configFilePath);
    }

    @BeforeMethod
    public void setUp(Method method) {
        app = new ObjectBase();
        String testcase = method.getName();
        UtilLibrary.readExcelData(testcase, System.getProperty("user.dir") + UtilLibrary.configProperties.getProperty("TestDataSheet"),UtilLibrary.configProperties.getProperty("DataSheet"));
    }

    @AfterMethod
    public void tearDown() {
        app.quitDriver();
        log.info("message");
    }

    @AfterTest
    public void dispose() {
        app.quitDriver();
        ExtentManager.consolidateReport();
    }

}
