package com.currency;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Search_Currency {

	
	WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public Search_Currency(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
    }

    By currencyBtn = By.xpath("//ul[contains(@class,'currencySelectorWrapper')]");
 
    By searchBox   = By.xpath("//input[@placeholder='Search Currency']");
    By options     = By.xpath("//div[contains(@class,'ListSection')]//p");

    public void selectCurrency(String currency) throws InterruptedException {
          Thread.sleep(2000);
          Reporter.log("Scrolling to Click on currency dropdown",true);
        js.executeScript("window.scrollBy(0, 350);");
        Thread.sleep(1500);
        Reporter.log("Clicking on currency dropdown",true);
        Thread.sleep(1000);
        driver.findElement(currencyBtn).click();
        Thread.sleep(2000);

        WebElement search = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox)
        );

        Reporter.log("Typing currency in search box: " + currency ,true);
        js.executeScript("arguments[0].focus();", search);
        search.clear();
        search.sendKeys(currency);

        List<WebElement> list = driver.findElements(options);
        Reporter.log("Number of currency suggestions displayed: " + list.size() ,true);

        boolean selected = false;

        for (WebElement e : list) {
        	Reporter.log("Currency suggestion found: " + e.getText(), true);

            if (e.getText().contains(currency)) {
                Thread.sleep(2000);
                e.click();
                Reporter.log("Currency selected successfully: " + currency, true);
                selected = true;
                break;
            }
        }

        if (!selected) {
        	Reporter.log("Currency NOT found in suggestion list: " + currency, true);
        }
    }	
	
}
