package com.login;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Login {
	WebDriver driver;

    By loginbtn = By.xpath("//li[@data-cy='account']"); 
    By Googleicon=By.xpath("//div[@id='container-div']");
    By emailField = By.id("identifierId");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void loginButton(String mail) throws InterruptedException {
        Thread.sleep(3000);
        WebElement loginElement = driver.findElement(loginbtn);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginElement);
        Reporter.log("Login button clicked",true);

        Thread.sleep(5000); 

        driver.switchTo().frame(0);
        Reporter.log("switched to iframe",true);
        Thread.sleep(2000);

        WebElement googleButton = driver.findElement(Googleicon);
        js.executeScript("arguments[0].click();", googleButton);
        Reporter.log("Google Sign-in clicked",true);
        Thread.sleep(3000);

        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String win : allWindows) {
            if (!win.equals(parentWindow)) {
                driver.switchTo().window(win);
                break;
            }
        }
        
        Reporter.log("Switched to child window",true);
        Thread.sleep(5000);
        
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.sendKeys(mail);
        Reporter.log("Email entered: " + mail , true);
        Thread.sleep(3000);

        driver.close();
        Reporter.log("Child window closed",true);
        Thread.sleep(2000);
        
       
        driver.switchTo().window(parentWindow);
        Reporter.log("Switched back to main window",true);
        Thread.sleep(2000);
    }
}
