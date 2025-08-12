package steps.ui.functional;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.config.BasicIbtTest;
import util.constants.Constants;
import util.constants.Elements;
import util.element.Element;

import java.util.List;
import java.util.stream.Collectors;

public class BasicSteps{

    public static BasicIbtTest basicIntTest = new BasicIbtTest();
    public static WebDriver webDriver = basicIntTest.webDriver;
    public static Element element = basicIntTest.element;


    @Given("the user search the {string} item")
    public void searchItem(String itemName) throws Exception {
        basicIntTest.element.click(Elements.SEARCH_SPACE);
        basicIntTest.element.sendKey(itemName, Elements.SEARCH_SPACE);
        basicIntTest.element.click(Elements.SEARCH_BUTTON);
    }

    @And("the user select the first item")
    public void selectTheItemBasedOnIndex() throws Exception {
        basicIntTest.element.selectItemByIndex(Elements.ITEMS, 0);
    }

    @And("the user switch to the new window")
    public void switchToNewWindow() throws Exception {
        String windowId = basicIntTest.webDriver.getWindowHandle();
        String url = basicIntTest.webDriver.getCurrentUrl();
//        LOGGER.info("The Current window id is... " + windowId);
//        LOGGER.info("The Current URL is... " + url);
        List<String> windows = basicIntTest.webDriver.getWindowHandles().stream().collect(Collectors.toList());
        basicIntTest.webDriver = basicIntTest.webDriver.switchTo().window(windows.get(1));
        windowId = basicIntTest.webDriver.getWindowHandle();
        url = basicIntTest.webDriver.getCurrentUrl();
//        LOGGER.info("The Current window id is... " + windowId);
//        LOGGER.info("The Current URL is... " + url);
    }


    @And("the verify the {string} items are added to the cart")
    public void verifyTheItemsAddedToTheCart(String numberOfItems) throws Exception {
        String value = basicIntTest.element.getAttributeValue(Elements.CART, Constants.CART_LABEL);
        Assert.assertEquals(value.contains(numberOfItems),true);
    }


    @And("the user add the item to the cart")
    public void addToTheCart() throws Exception {
        basicIntTest.element.click(Elements.ADD_TO_CART);
        basicIntTest.element.click(Elements.CLOSE_ADD_TO_CART);
    }

    @Given("the user verifies to the shopping cart")
    public void navigateToSite() throws Exception {

        WebDriverManager webDriverManager = WebDriverManager.chromedriver().browserVersion("beta");
        webDriverManager.setup();
        WebDriver driver = webDriverManager.create();
        Thread.sleep(1000);
        // webDriverManager.setup();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //driver.findElement(By.xpath("//div[@class='global-header-container']//section[@class='gh-header__main']//form//div//following-sibling::div//input")).sendKeys("book’");

        driver.findElement(By.xpath("//div[@class='gh-search-input__wrap']//input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='gh-search-input__wrap']//input")).sendKeys("book");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".gh-search-button__wrap")).click();
        Thread.sleep(10000);
        List<WebElement> bookElems = driver.findElements(By.xpath("//a[@class='su-link']//div"));
        bookElems.get(0).click();
        Thread.sleep(3000);
        String parent_id = driver.getWindowHandle();
        List<String> windows = driver.getWindowHandles().stream().collect(Collectors.toList());
        driver.switchTo().window(windows.get(1));
        String url = driver.getCurrentUrl();
        System.out.println("URL : " + url);
        //  String newUrl =  driver.switchTo().newWindow(WindowType.TAB).getCurrentUrl();
        Thread.sleep(3000);

        //Before clicking Add to cart
        //Your shopping cart contains 0 items
        String cartMessage = driver.findElement(By.xpath("//span[@class='gh-cart__icon']")).getAttribute("aria-label");
        System.out.println("Before Clicking : " + cartMessage);
        //After clicking Add to cart
        //Your shopping cart contains 2 items
        driver.findElement(By.xpath("//a[@id='atcBtn_btn_1']")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//div[@data-testid='x-atc-action']//child::button")).click();
        Thread.sleep(6000);
        String cartMessage1 = driver.findElement(By.xpath("//span[@class='gh-cart__icon']")).getAttribute("aria-label");
        System.out.println("Before Clicking : " + cartMessage1);

    }

}
