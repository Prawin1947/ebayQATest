package util.constants;

import org.openqa.selenium.By;

public class Elements {

    public static By MAIN_PAGE_CONTAINER = By.cssSelector(".evo-carousels");
    public static By SEARCH_SPACE = By.xpath("//div[@class='gh-search-input__wrap']//input");
    public static By SEARCH_BUTTON = By.cssSelector(".gh-search-button__wrap");
    public static By ITEMS = By.xpath("//a[@class='su-link']//div");
    public static By CART = By.xpath("//span[@class='gh-cart__icon']");
    public static By ADD_TO_CART = By.xpath("//a[@id='atcBtn_btn_1']");
    public static By CLOSE_ADD_TO_CART = By.xpath("//div[@data-testid='x-atc-action']//child::button");
}
