package pages.MainPage;


import libs.WebElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;

public class MainPage {
        WebDriver webDriver;
        Logger logger;
        public WebElements webElements;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webElements = new WebElements(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    /**
     * Method
     * @param
     */
    public void openUrl(String url){
        try{
            webDriver.get(url);
            logger.info("Page was opened" + url);
        } catch (Exception e){
            e.printStackTrace();
            logger.info("Page can`t opened" + url);
            Assert.fail("Page can not opened" + url);
        }

    }

    public void checkTitle(String expectedTitle){
        try {
            Assert.assertThat("Title not matched", webDriver.getTitle(), is(expectedTitle));
        } catch (Exception e){
          logger.error("Can`t find title" + expectedTitle);
          Assert.fail("Can`t find title" + expectedTitle);
        }
    }


}


