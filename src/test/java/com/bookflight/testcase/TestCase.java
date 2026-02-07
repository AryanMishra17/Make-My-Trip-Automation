package com.bookflight.testcase;



import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestCase {

	protected WebDriver driver;
    protected Properties prop;

    @BeforeTest
    public void setup() throws Exception {
    	 
        prop = new Properties();
        FileInputStream fis = new FileInputStream("./Data.properties");
        prop.load(fis);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(prop.getProperty("url"));
        
       
    }

    @AfterTest
    public void tearDown() {
    	 Reporter.log("==================================================", true);
         Reporter.log(" WINDOW CLOSED & QUIT FROM BROWSER SUCCESSFULLY", true);
         Reporter.log("==================================================", true);

       driver.quit();
    }

}


