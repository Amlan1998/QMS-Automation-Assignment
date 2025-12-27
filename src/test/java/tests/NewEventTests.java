package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.NewEventPage;
import utils.ConfigReader;
import utils.ExtentTestManager;

public class NewEventTests extends BaseTest {

    @Test
    public void createNewEventHappyPath() {

        try {
            // Login
            LoginPage login = new LoginPage(driver);
            login.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
            );

            // Navigate to New Event
            HomePage eventNavigation = new HomePage(driver);
            eventNavigation.logEventNavigation();

            NewEventPage event = new NewEventPage(driver);

            // Assertion: Page loaded
            Assert.assertTrue(
                event.isPageLoaded(),
                "New Event page did not load successfully"
            );
            
            ExtentTestManager.logInfo(
                    "Known UI Constraint: The Event page contains a fixed bottom action bar " +
                    "that permanently overlaps rich text editors. Native Selenium click and " +
                    "sendKeys interactions are unreliable in this area. " +
                    "To ensure deterministic automation, rich text content is set using " +
                    "JavaScript-based interaction instead of physical clicks."
                );

            // Fill Event Details
            event.enterShortDescription(
                ConfigReader.get("short.description")
            );

            event.selectPreliminaryCriticality(
                ConfigReader.get("preliminary.criticality")
            );

            event.selectSourceOfEvent(
                ConfigReader.get("source.of.event")
            );

            event.selectDepartmentOwner(
                ConfigReader.get("department.owner")
            );

            // Affected Items
            event.clickAffectedItems();

            event.selectAffectedItems_Type(
                ConfigReader.get("affected.item.type")
            );

            event.addAffectedItems_Details(
                ConfigReader.get("affected.item.details")
            );

            event.addAffectedItems_Status(
                ConfigReader.get("affected.item.status")
            );

            event.clickAffectedItems_AddEntry();

            // Descriptions
            event.expandDetailedDescription();
            
            event.addDescriptionOfEvent(
                ConfigReader.get("event.description")
            );
            
            event.expandImmediateActions();
            
            event.addImmediateActionsTaken(
                ConfigReader.get("immediate.actions")
            );

            event.clickSaveDraft();
            event.clickSave();

        } catch (Exception e) {
            Assert.fail("Test failed due to unexpected exception: " + e.getMessage(), e);
        }
    }
}
