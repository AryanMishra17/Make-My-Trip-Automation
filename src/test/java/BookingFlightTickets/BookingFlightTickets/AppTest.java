package BookingFlightTickets.BookingFlightTickets;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bookflight.HomePage;
import com.bookflight.testcase.TestCase;
import com.currency.Search_Currency;
import com.screenshot.Screenshot;

public class AppTest extends TestCase {
	@Test
    public void bookRoundTripFlight() throws Exception {

        HomePage home = new HomePage(driver);
        Search_Currency currency = new Search_Currency(driver);

        try {
            Reporter.log("Test started: Book Round Trip Flight", true);

            home.closePopups();
            Reporter.log("Popups closed", true);

            currency.selectCurrency(prop.getProperty("currency"));

            home.enterSourceCity(prop.getProperty("fromCity"));
            home.enterDestinationCity(prop.getProperty("toCity"));
            Reporter.log("Cities selected", true);

            home.selectDepartureDate(prop.getProperty("departureDate"));
            home.selectReturnDate(prop.getProperty("returnDate"));
            Reporter.log("Dates selected", true);

            Reporter.log("Starting traveller selection flow", true);

            home.openTravellerWidget();
            Reporter.log("Traveller widget opened", true);
            
            
            String adultsValue = prop.getProperty("adults");
            Reporter.log("Adults = " + adultsValue, true);
            int adultCount = Integer.parseInt(adultsValue);
            home.selectAdults(adultCount);
            Reporter.log("Selected " + adultCount + " adults", true);
            
            
            
            home.clickApplyTraveller();
            
            Reporter.log("Test completed successfully", true);

        } catch (Exception e) {

            Screenshot.captureOnFailure(driver);
            Reporter.log("Test failed due to exception: " + e.getMessage(), true);
            throw e;
        }
    }
}
