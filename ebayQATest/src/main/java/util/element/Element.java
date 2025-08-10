package util.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.config.BasicIbtTest;
import util.wait.WebDriverWaits;

public class Element extends BasicIbtTest {

    public static Logger LOGGER = LoggerFactory.getLogger(Element.class);
    private static WebDriver driver = BasicIbtTest.webDriver;
    private static WebDriverWaits waits = BasicIbtTest.webDriverWaits;

    public static WebDriver click(By by){
        waits.waitForElementToBeLoaded(by);
        driver.findElement(by).click();
        return driver;
    }

    public static WebDriver sendKey(String value,By by){
        waits.waitForElementToBeLoaded(by);
        driver.findElement(by).sendKeys(value);
        return driver;
    }

    public static WebDriver selectItemByIndex(By by,int index){
        waits.waitForElementToBeLoaded(by);
        driver.findElements(by).get(index).click();
        return driver;
    }

    public static String getAttributeValue(By by,String attribute){
        waits.waitForElementToBeLoaded(by);
       return driver.findElement(by).getAttribute(attribute);
    }

}
