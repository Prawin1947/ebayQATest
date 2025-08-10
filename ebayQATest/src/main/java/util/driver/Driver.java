package util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver implements DriverManager {
    public static WebDriverManager webDriverManager;
    public static WebDriver driver;
    public static String browser;

    public Driver(){
    }

    public WebDriver getDriver(String browser) {

        switch(browser){
            case "chrome":
                webDriverManager = WebDriverManager.chromedriver().capabilities(getChromeOptions()).browserVersion("beta");
                webDriverManager.setup();
                driver =  webDriverManager.create();
                break;

            case "firefox":
                break;

            case "edge":
                break;
        }
        return driver;
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments( "--disable-extensions");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-popup-blocking");
        return chromeOptions;
    }

}
