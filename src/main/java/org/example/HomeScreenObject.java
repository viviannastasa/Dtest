package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import utils.DateUtils;
import utils.XpathUtils;

import static org.example.Driver.*;

public class HomeScreenObject {

    private static final String homeUrl = "https://hotwire.com";
    private static final By bundlesButton = By.xpath("//*[text()=\"Bundles\"]");
    private static final By carCheckmark = By.xpath("//*[@data-bdd=\"farefinder-package-bundleoption-car\"]");
    private static final By carCheckmarkEnabled = By.xpath("//*[(@data-bdd=\"farefinder-package-bundleoption-car\")]//*[(@data-id=\"SVG_HW_FUNCTIONAL_CIRCLE_CHECK_FILLED\")]");
    private static final By flyFrom = By.xpath("//*[@class='col-xs-12 margin-top-6']//*[@placeholder='Enter address, city or airport']");
    private static final By flyTo = By.xpath("//*[@class='col-xs-12 margin-top-4']//*[@placeholder='Enter address, city or airport']");
    private static final By calendarOverlay = By.xpath("//*[@data-bdd=\"farefinder-package-startdate-input\"]");
    private static final By carPickup = By.xpath("//*[@name=\"carPickupTime\"]");
    private static final By carDropoff = By.xpath("//*[@name=\"carDropoffTime\"]");
    private static final By findDealButton = By.xpath("//*[text()='Find a deal']");
    private static final By propertyResults = By.xpath("//*[@data-stid=\"property-listing-results\"]");

    public static void navigateHome() {
        getDriver().get(homeUrl);
    }

    public static void clickBundles() {
        click(bundlesButton);
    }

    public static void clickCarCheckmark() {
        click(carCheckmark);
    }

    public static void validateCarCheckmarkEnabled() {
        assertIsDisplayed(carCheckmarkEnabled, "Car option is not enabled");
    }

    public static void fillFlyFromTo(String from, String to) {
        typeText(flyFrom, from);
        typeText(flyTo, to);
        clickToRightByOffset(flyFrom, 20);
    }

    public static void fillDates(int departingDaysToAdd, int returningDaysToAdd) {
        click(By.xpath(XpathUtils.parameterXpath("@class=\"month multi simple\"][1]//*[text()", DateUtils.getFutureDate(departingDaysToAdd).substring(3, 5))));
        click(By.xpath(XpathUtils.parameterXpath("@class=\"month multi simple\"][2]//*[text()", DateUtils.getFutureDate(returningDaysToAdd).substring(3, 5))));
    }

    public static void clickCalendarOverlay() {
        click(calendarOverlay);
    }

    public static void selectCarTime(String pick, String drop) {
        select(carPickup, pick);
        select(carDropoff, drop);
    }

    public static void clickFindDeal() {
        click(findDealButton);
    }

    public static void validateResultsAreDisplayed(){
        assertIsDisplayed(propertyResults, "No results found");
    }
}
