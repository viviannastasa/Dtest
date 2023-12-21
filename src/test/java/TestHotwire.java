import org.example.Driver;
import org.example.HomeScreenObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestHotwire {

    @BeforeAll
    public static void before() {
        HomeScreenObject.navigateHome();
    }

    @Test
    public void test1() {
        String from = "San Francisco, CA, United States of America (SFO-San Francisco Intl.)";
        String to = "Los Angeles, CA, United States of America (LAX-Los Angeles Intl.)";
        HomeScreenObject.clickBundles();
        HomeScreenObject.clickCarCheckmark();
        HomeScreenObject.validateCarCheckmarkEnabled();
        HomeScreenObject.fillFlyFromTo(from, to);
        HomeScreenObject.clickCalendarOverlay();
        HomeScreenObject.fillDates(1, 20);
        HomeScreenObject.selectCarTime("Evening", "Morning");
        HomeScreenObject.clickFindDeal();
        HomeScreenObject.validateResultsAreDisplayed();
    }

    @AfterAll
    public static void cleanUp() {
        Driver.quitDriver();
    }
}

