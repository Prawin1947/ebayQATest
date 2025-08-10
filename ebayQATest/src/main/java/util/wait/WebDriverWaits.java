package util.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.config.BasicIbtTest;

import java.time.Duration;

public class WebDriverWaits implements Waits{

public static BasicIbtTest basicIntTest;
    public static Wait<WebDriver> wait;
    public static WebDriver webDriver ;


    static {
        basicIntTest = new BasicIbtTest();
        webDriver = basicIntTest.webDriver;
        wait = new WebDriverWait(webDriver,Duration.ofSeconds(3));
    }


    public void waitForElementToBeLoaded(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeLoaded(By by){
        WebElement element = webDriver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAllElementToBeLoaded(WebElement elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void defaultWaitForElement(WebElement element){
        wait = new WebDriverWait(webDriver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
 }
