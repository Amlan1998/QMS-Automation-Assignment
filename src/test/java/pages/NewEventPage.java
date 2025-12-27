package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class NewEventPage extends BasePage {

    public NewEventPage(WebDriver driver) {
        super(driver);
    }

    By pageHeader =
        By.xpath("//h1[contains(text(),'Event')]");

    By shortDescription =
        By.id("short_description_of_event");

    By preliminaryCriticalityDropdown =
    	    By.xpath("//label[contains(text(),'Preliminary Criticality')]/following::select[1]");

    	By sourceOfEventDropdown =
    	    By.xpath("//label[contains(text(),'Source of Event')]/following::select[1]");

    	By departmentOwnerDropdown =
    	    By.xpath("//label[contains(text(),'Department Owner')]/following::select[1]");
    	
    	By addAffectedItemsButton = By.xpath("//button[normalize-space()='Add Affected Items']");
    	
    	By affectedItemTypeDropdown = By.xpath("//label[contains(text(),'affected')]/following::select[1]");
    	By materialBatch = By.xpath("//select[option[normalize-space()='Material / Batch']]");
    	By equipmentAsset = By.xpath("//select[option[normalize-space()='Equipment / Asset']]");
    	By utilitySystem = By.xpath("//select[option[normalize-space()='Utility / System']]");
    	By documentSop = By.xpath("Document / SOP");
    	
    	By affectedItemDetails = By.xpath("//label[contains(normalize-space(),'Detail')]/following::input[@type='text'][1]");
    	By affectedReferenceNumber = By.xpath("(//label[contains(normalize-space(),'Detail')]/following::input[@type='text'][2]");
    	By affectedItemStatus = By.xpath("//label[contains(normalize-space(),'Detail')]/following::input[@type='text'][3]");
    	By affectedItemsAddEntryButton = By.xpath("//button[normalize-space()='Add Entry']");
    	By affectedItemsCancelButton = By.xpath("//button[normalize-space()='Cancel']");
    	
    	By expandDetailedDescription = By.xpath("(//button[@title='Expand'])[1]");
    	By detailedDescriptionTextArea = By.xpath("(//div[contains(@contenteditable,'true')])[1]");
    	
    	By expandImmediateActions = By.xpath("(//button[@title='Expand'])[2]");
    	By immediateActionsTextArea = By.xpath("(//div[contains(@contenteditable,'true')])[2]");

    By saveDraftBtn =
        By.xpath("//button[normalize-space()='Save Draft']");

    By saveBtn =
        By.xpath("//button[normalize-space()='Save']");

    public boolean isPageLoaded() {
        try {
            return waitForElement(pageHeader).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterShortDescription(String text) {
        waitForElement(shortDescription).sendKeys(text);
    }

    public void selectPreliminaryCriticality(String value) {
        Select criticality = new Select(waitForElement(preliminaryCriticalityDropdown));
        criticality.selectByValue(value);
    }

    public void selectSourceOfEvent(String value) {
        Select source = new Select(waitForElement(sourceOfEventDropdown));
        source.selectByVisibleText(value);
    }

    public void selectDepartmentOwner(String value) {
        Select department = new Select(waitForElement(departmentOwnerDropdown));
        department.selectByVisibleText(value);
    }
    
   public void clickAffectedItems() {
	   WebElement button = waitForElement(addAffectedItemsButton);

	    ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

	    wait.until(ExpectedConditions.elementToBeClickable(button)).click();
   }
   public void selectAffectedItems_Type(String value) {
	   Select department = new Select(waitForElement(affectedItemTypeDropdown));
       department.selectByVisibleText(value);
   }
   public void addAffectedItems_Details(String value) {
	   waitForElement(affectedItemDetails).sendKeys(value);
   }
   public void addAffectedItems_ReferenceNumber(String value) {
	   waitForElement(affectedReferenceNumber).sendKeys(value);
   }
   public void addAffectedItems_Status(String value) {
	   waitForElement(affectedItemStatus).sendKeys(value);
   }
   public void clickAffectedItems_AddEntry() {
	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(affectedItemsAddEntryButton)).click();
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to click Add Entry for Affected Items", e);
	    }
	}
   public void expandDetailedDescription() {
	    safeClick(expandDetailedDescription);
	}
   public void addDescriptionOfEvent(String value) {
	    safeType(detailedDescriptionTextArea, value);
	}
   public void expandImmediateActions() {
	    safeClick(expandImmediateActions);
	}
   public void addImmediateActionsTaken(String value) {
	    safeType(immediateActionsTextArea, value);
	}
    public void clickSaveDraft() {
        waitForElement(saveDraftBtn).click();
    }

    public void clickSave() {
        waitForElement(saveBtn).click();
    }
}
