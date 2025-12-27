package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	By quickCommandDropdown = By.xpath("//span[normalize-space()='Quality Command']");
	By logEventButton = By.xpath("//span[normalize-space()='Log Event']");
	By deviationButton = By.xpath("//h3[normalize-space()='Deviation']");
	By continueButton = By.xpath("//button[normalize-space()='Continue']");
	public HomePage(WebDriver driver) {
        this.driver = driver;
    }
	
	public void logEventNavigation() {
		driver.findElement(quickCommandDropdown).click();
		driver.findElement(logEventButton).click();
		driver.findElement(deviationButton).click();
		driver.findElement(continueButton).click();
	}

}
