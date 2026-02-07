package BookingFlightTickets.BookingFlightTickets;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bookflight.HomePage;
import com.bookflight.testcase.TestCase;
import com.currency.Search_Currency;
import com.login.Login;
import com.screenshot.Screenshot;

public class AppTest extends TestCase {
	@Test
    public void bookRoundTripFlight() throws Exception {

        HomePage home = new HomePage(driver);
        Search_Currency currency = new Search_Currency(driver);
         Login login=new Login(driver);
        try {
        	 Reporter.log("==================================================", true);
             Reporter.log("TEST STARTED : BOOK ROUND TRIP FLIGHT", true);
             Reporter.log("==================================================", true);
             
             Reporter.log("---------- STEP 1 : DATA.PROPERTIES FILE LOADED... ----------", true);
             
             Reporter.log("---------- STEP 2 : OPEN APPLICATION ----------", true);
             Reporter.log("Browser launched successfully", true);
             Reporter.log("Navigated to application URL", true);
             
            Reporter.log("---------- STEP 3 : CLOSE INITIAL POPUPS ----------", true);
            home.loginPopups();
            home.chatPopups();
            Reporter.log("Initial popups closed successfully", true);
            Reporter.log("Popups closed", true);
         
            Reporter.log("---------- STEP 4 : LOGIN / SIGNUP ----------", true);
            Reporter.log("login/Signup", true);
             login.loginButton(prop.getProperty("email"));
             
             home.loginPopups();
             Reporter.log("Popups closed after login/signup", true);
          
             Reporter.log("---------- STEP 5 : CURRENCY SELECTION ----------", true);
             Reporter.log("Selecting currency from auto-suggestion list", true);
            currency.selectCurrency(prop.getProperty("currency"));

            Reporter.log("---------- STEP 6 : FLIGHT BOOKING FLOW ----------", true);
            home.enterSourceCity(prop.getProperty("fromCity"));
            home.enterDestinationCity(prop.getProperty("toCity"));
            Reporter.log("Cities selected", true);

            home.selectDepartureDate(prop.getProperty("departureDate"));
            home.selectReturnDate(prop.getProperty("returnDate"));
            Reporter.log("Dates selected", true);

            Reporter.log("  Starting traveller selection flow  ", true);
            home.openTravellerWidget();
            Reporter.log("Traveller widget opened", true);
            
            
            String adultsValue = prop.getProperty("adults");
            Reporter.log("Adults = " + adultsValue, true);
            int adultCount = Integer.parseInt(adultsValue);
            home.selectAdults(adultCount);
            Reporter.log("Selected " + adultCount + " adults", true);
            
            
            
            home.clickApplyTraveller();
            Reporter.log("Traveller details applied successfully", true);

            Reporter.log("==================================================", true);
            Reporter.log("TEST COMPLETED SUCCESSFULLY", true);
            Reporter.log("==================================================", true);
        } catch (Exception e) {

            Screenshot.captureOnFailure(driver);
            Reporter.log("Test failed due to exception: " + e.getMessage(), true);
            throw e;
        }
    }
}
