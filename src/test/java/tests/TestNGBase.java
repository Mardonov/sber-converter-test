package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import ru.stqa.selenium.factory.WebDriverFactory;
import utils.AllureScreenshotListener;
import utils.PropertyManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners({AllureScreenshotListener.class})
public abstract class TestNGBase {

    protected WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    public void testInitialize(String browser) throws IOException {
        switch (browser){
            case "chrome": driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());
                break;
            case "firefox": driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
                break;
        }
    }

    public void testFullSize(){
        driver.manage().window().maximize();
    }

    @BeforeSuite
    public void factoryMode() throws Exception{
        //PropertyManager.loadProperties();
    }

    @BeforeClass
    public void setUp() throws Exception {
        //System.setProperty("browserName","firefox");

        System.setProperty("browserName","firefox");
        PropertyManager.loadProperties();
        testInitialize(System.getProperty("browserName"));
        testFullSize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.get(System.getProperty("url"));
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        WebDriverFactory.dismissDriver(driver);
    }

    @AfterSuite
    public void tearDownSuite() throws Exception {
        WebDriverFactory.dismissAll();
    }
}
