package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    String browser;
    WebDriver wd;
    HelperUser helperUser;
    HelperContact helperContact;
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if(browser.equals(Browser.CHROME.browserName())) {
            wd = new ChromeDriver();
            logger.info("All tests run in ChromeBroweser");
        } else if (browser.equals(Browser.FIREFOX.browserName())) {

            wd = new FirefoxDriver();
            logger.info("All tests run inFirefoxBroweser");
        } else if (browser.equals(Browser.EDGE.browserName())) {
            wd = new EdgeDriver();
            logger.info("All tests run in EdgeBroweser");

        }
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        WebDriverListener webDriverListener = new WDListener();
        wd = new EventFiringDecorator(webDriverListener).decorate(wd);


        //wd.manage().window().maximize();

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://telranedu.web.app/home");
        logger.info("The link--->"+wd.getCurrentUrl());
        helperUser = new HelperUser(wd);
        helperContact=new HelperContact(wd);


    }

    public HelperUser getHelperUser() {

        return helperUser;
    }

    public void stop() {
        wd.quit();

    }

    public HelperContact getHelperContact() {
        return helperContact;
    }
}


