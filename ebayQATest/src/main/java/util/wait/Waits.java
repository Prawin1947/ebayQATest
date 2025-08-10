package util.wait;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Waits {

    public void waitForElementToBeLoaded(WebElement element);
    public void defaultWaitForElement(WebElement element);
    public void waitForAllElementToBeLoaded(WebElement element);


}
