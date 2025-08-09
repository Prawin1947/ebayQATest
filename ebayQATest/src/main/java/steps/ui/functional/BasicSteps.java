package steps.ui.functional;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BasicSteps {

    @Given("the user navigates to the shopping site")
    public void navigateToSite() throws Exception{

      WebDriverManager  webDriverManager = WebDriverManager.chromedriver().browserVersion("beta");
        webDriverManager.setup();
        WebDriver driver =  webDriverManager.create();
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
        System.out.println("URL : "+url);
    //  String newUrl =  driver.switchTo().newWindow(WindowType.TAB).getCurrentUrl();
        Thread.sleep(3000);

        //Before clicking Add to cart
       //Your shopping cart contains 0 items
       String cartMessage =  driver.findElement(By.xpath("//span[@class='gh-cart__icon']")).getAttribute("aria-label");
        System.out.println("Before Clicking : "+cartMessage);
        //After clicking Add to cart
        //Your shopping cart contains 2 items
        driver.findElement(By.xpath("//a[@id='atcBtn_btn_1']")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//div[@data-testid='x-atc-action']//child::button")).click();
        Thread.sleep(6000);
        String cartMessage1 =  driver.findElement(By.xpath("//span[@class='gh-cart__icon']")).getAttribute("aria-label");
        System.out.println("Before Clicking : "+cartMessage1);



    }
}
