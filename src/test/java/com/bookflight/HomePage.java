package com.bookflight;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.bookflight.testcase.TestCase;
import com.screenshot.Screenshot;

public class HomePage extends TestCase{
	 WebDriver driver;
	    WebDriverWait wait;
	    JavascriptExecutor js;
	    Actions actions;

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        js = (JavascriptExecutor) driver;
	        actions = new Actions(driver);
	    }

	    By closeLoginPopup = By.xpath("//span[@data-cy='closeModal']");
	    By closeChatPopup  = By.xpath("//img[@alt='minimize']");

	    public void loginPopups() {

	        try {
	            WebElement loginPopup = wait.until(
	                ExpectedConditions.elementToBeClickable(closeLoginPopup)
	            );
	            loginPopup.click();
	            Reporter.log("Login popup closed", true);
	        } catch (Exception e) {
	            Screenshot.captureOnFailure(driver);
	            Reporter.log("Login popup not displayed" + e.getMessage(), true);
	            throw e;
	        }
	    }
	    
	    public void chatPopups() {

	        try {
	            WebElement chatPopup = wait.until(
	                ExpectedConditions.elementToBeClickable(closeChatPopup)
	            );
	            chatPopup.click();
	            Reporter.log("Chat popup closed", true);
	        } catch (Exception e) {
	            Screenshot.captureOnFailure(driver);
	            Reporter.log("Chat popup not displayed" + e.getMessage(), true);
	            throw e;
	        }
	    }

	    public void enterSourceCity(String city) throws InterruptedException {

	    	Thread.sleep(2000);
	        WebElement fromCity = wait.until(
	            ExpectedConditions.elementToBeClickable(By.id("fromCity"))
	        );

	        js.executeScript("arguments[0].click();", fromCity);
	        fromCity.sendKeys(Keys.CONTROL + "a");
	        fromCity.sendKeys(city);

	        WebElement suggestion = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.xpath("//p[contains(text(),'" + city + "')]")
	            )
	        );

	        js.executeScript("arguments[0].click();", suggestion);
	        Reporter.log("Source city selected: " + city, true);
	    }

	    public void enterDestinationCity(String city) throws InterruptedException {
	    	Thread.sleep(2000);

	        WebElement toCity = wait.until(
	            ExpectedConditions.elementToBeClickable(By.id("toCity"))
	        );
	       

	        js.executeScript("arguments[0].click();", toCity);
	        toCity.sendKeys(Keys.CONTROL + "a");
	        toCity.sendKeys(city);
	        
	    	Thread.sleep(1000);
	        WebElement suggestion = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.xpath("//p[contains(text(),'" + city + "')]")
	            )
	        );

	        js.executeScript("arguments[0].click();", suggestion);
	        Reporter.log("Destination city selected: " + city, true);
	    }

	    public void selectDepartureDate(String date) throws InterruptedException {
	    	Thread.sleep(2000);
	        WebElement departureDate = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.xpath("//div[@aria-label='" + date + "']")
	            )
	        );

	        js.executeScript("arguments[0].click();", departureDate);
	        Reporter.log("Departure date selected: " + date, true);
	    }

	    public void selectReturnDate(String date) throws InterruptedException {
	    	Thread.sleep(2000);
	    	 WebElement returnArea = wait.until(
	    		        ExpectedConditions.elementToBeClickable(
	    		            By.xpath("//div[@data-cy='returnArea']")
	    		        )
	    		    );

	    		    js.executeScript("arguments[0].click();", returnArea);
	    		    Reporter.log("Return date field activated", true);
	    		    
	    	    	Thread.sleep(2000); 
	    	  WebElement returnDate = wait.until(
	  	            ExpectedConditions.presenceOfElementLocated(
	  	                By.xpath("//div[@aria-label='" + date + "']")
	  	            )
	  	        );
	        js.executeScript("arguments[0].scrollIntoView(true);", returnDate);
	        js.executeScript("arguments[0].click();", returnDate);

	        Reporter.log("Return date selected: " + date, true);
	    }
	    
	    
	    public void openTravellerWidget() throws InterruptedException {
	        js.executeScript("window.scrollTo(0, 0);");
	        Thread.sleep(2000);

	        WebElement travellerBox = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.xpath("//label[@for='travellers']")
	            )
	        );

	        js.executeScript("arguments[0].click();", travellerBox);
	        Reporter.log("Traveller widget opened", true);
	    }
	    public void selectAdults(int targetAdults) throws InterruptedException {

	    	
	        openTravellerWidget();
	        Thread.sleep(2000); 


	            WebElement no = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//p[text()='ADULTS (12y +)']/following-sibling::ul/li[@data-cy='adults-"+targetAdults+"']")
	                ));

	            no.click();
	        Reporter.log("Adults selected: " + targetAdults, true);
	    }

	    public void clickApplyTraveller() {

	        WebElement applyBtn = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                By.xpath("//button[@data-cy='travellerApplyBtn']")
	            )
	        );

	        js.executeScript("arguments[0].click();", applyBtn);
	        Reporter.log("Traveller selection applied", true);
	    }


}

