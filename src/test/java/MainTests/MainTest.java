package MainTests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage.MainPage;
import pages.MainPage.RegistrationPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public WebDriver webDriver;
    public RegistrationPage registrationPage;
    public MainPage mainPage;
    public Logger logger;

    public MainTest(){}

    @Before
    public void setUp() {
        File chromeFF;
        chromeFF = new File("C:\\chromedriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", ((File) chromeFF).getAbsolutePath());
        webDriver = new ChromeDriver();
        registrationPage = new RegistrationPage(webDriver);
        logger = Logger.getLogger(getClass());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try {
            //MAIN PAGE
            webDriver.get("http://automationpractice.com");
            logger.info("Open link - http://automationpractice.com");
        } catch (Exception e) {
            logger.error("Can`t open browser");
            Assert.fail("Can`t open browser");
        }
    }

   /* @After
        public void tearDown(){
            webDriver.quit();
    }*/


    public void checkAC(String message, boolean actualRes, boolean expectedRes){
        Assert.assertEquals(message, actualRes, expectedRes);
    }
}
