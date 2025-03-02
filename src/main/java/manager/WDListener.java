package manager;


import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class WDListener implements WebDriverListener {
    Logger logger= LoggerFactory.getLogger(WDListener.class);

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
        logger.info("Before find element");
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
        logger.info("After find element");
    }

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        WebDriverListener.super.beforeTo(navigation, url);
        logger.info("url-->"+url);
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.info("Huston, we have a problem!!!");
        logger.info("!!!!!!!!!!!!");
        logger.info("Object target:" +target.toString());
        logger.info("Method name: "+method.getName());
        logger.info("InvocationTargetException: "+e.getTargetException());

        int i=new Random().nextInt(1000)+1000;
        String link="src/test/screenshots/screen_"+i+".png";
        logger.info("Screen with error is --->"+link);
        WebDriver wd=(WebDriver) target;
        TakesScreenshot takesScreenshot=(TakesScreenshot) wd;
        File tmp = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp,new File(link));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
