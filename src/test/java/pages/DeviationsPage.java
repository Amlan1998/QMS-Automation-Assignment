package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeviationsPage {

    WebDriver driver;

    By searchBox = By.xpath("//input[@placeholder='Search by ID or Title...']");

    public DeviationsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEventPresent(String text) {
        driver.findElement(searchBox).sendKeys(text);
        return driver.getPageSource().contains(text);
    }
}
