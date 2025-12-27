package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	protected WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void scrollElementAboveFooter(By elementLocator) {

		WebElement element = waitForElement(elementLocator);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Get element Y position
		Number elementY = (Number) js
				.executeScript("return arguments[0].getBoundingClientRect().top + window.pageYOffset;", element);

		// Estimate footer height (safe buffer)
		Long footerHeight = 500L; // adjust if needed

		// Scroll so element is above footer
		Long scrollTo = elementY.longValue() - footerHeight;

		js.executeScript("window.scrollTo(0, arguments[0]);", scrollTo);
	}

	protected WebElement findFreshElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void safeType(By locator, String value) {

		try {
			scrollElementAboveFooter(locator);

			WebElement element = findFreshElement(locator);
			element.click();
			element.clear();
			element.sendKeys(value);

		} catch (org.openqa.selenium.StaleElementReferenceException e) {

			WebElement freshElement = findFreshElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", freshElement, value);
		}
	}

	protected void safeClick(By locator) {

		try {
			scrollElementAboveFooter(locator);

			WebElement element = findFreshElement(locator);

			wait.until(ExpectedConditions.elementToBeClickable(element)).click();

		} catch (org.openqa.selenium.StaleElementReferenceException e) {

			// Retry once with fresh lookup
			WebElement freshElement = findFreshElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", freshElement);
		}
	}

}
