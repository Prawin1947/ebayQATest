package util.driver;

import org.openqa.selenium.WebDriver;

public interface DriverManager {

    public WebDriver getDriver(String browser);

}
