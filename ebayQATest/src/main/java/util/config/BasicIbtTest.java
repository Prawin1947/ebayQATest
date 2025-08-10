package util.config;

import com.typesafe.config.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.constants.Constants;
import util.constants.Elements;
import util.driver.Driver;
import util.element.Element;
import util.wait.WebDriverWaits;


public class BasicIbtTest {
    public static ConfigManager configManager;
    public static Config uiConFig;
    public static Config apiConFig;
    public static String URL;
    public static WebDriver webDriver;
    public static WebDriverWaits webDriverWaits;

    public static Logger LOGGER = LoggerFactory.getLogger(BasicIbtTest.class);
    public static Element element;

    static {
        loadConfig();
        webDriver = basicUiSetUp();
        navigateToShoppingSite();
    }

    private static void loadConfig() {
        LOGGER.info("Configuration loading...");
        configManager = new ConfigManager();
        uiConFig = configManager.getUiConfig();
        apiConFig = configManager.getApiConfig();
    }

    private static WebDriver basicUiSetUp() {
        LOGGER.info("UI set up is loading...");
        URL = uiConFig.getString(Constants.URL);
        LOGGER.info("URL to be load... " + URL);
        String browser = uiConFig.getString(Constants.BROWSER);
        webDriver = new Driver().getDriver(browser);
        webDriverWaits = new WebDriverWaits();
        element = new Element();
        return webDriver;
    }

    @Before
    public static void navigateToShoppingSite() {
        if (URL.equals(null) && "".equals(URL)) {
            LOGGER.error("The URL cannot be null...", IllegalArgumentException.class);
        } else {
            webDriver.navigate().to(URL);
            WebElement element = webDriver.findElement(Elements.MAIN_PAGE_CONTAINER);
            webDriverWaits.waitForAllElementToBeLoaded(element);
            LOGGER.info("The user lands on... " + URL + " page");
        }
    }

    @After
    public static void closeTheBrowser() {
        LOGGER.info("The user session ends at... " + webDriver.getCurrentUrl());
        webDriver.quit();
    }

}

