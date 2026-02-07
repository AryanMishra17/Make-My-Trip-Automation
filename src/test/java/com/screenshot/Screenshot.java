package com.screenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Reporter;

public class Screenshot {
	 private static int screenshotCount = 1;

	    public static void captureOnFailure(WebDriver driver) {

	        try {
	            String path = "./Screenshot's/failure_" + screenshotCount + ".png";

	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File src = ts.getScreenshotAs(OutputType.FILE);
	            File dest = new File(path);

	            FileUtils.copyFile(src, dest);

	            Reporter.log(
	                "Test failed. Screenshot captured.<br/>" +
	                "<a href='" + dest.getAbsolutePath() + "' target='_blank'>View Screenshot</a>",
	                true
	            );

	            screenshotCount++;

	        } catch (Exception e) {
	            Reporter.log("Screenshot capture failed.", true);
	            e.printStackTrace();
	        }
	    }
	}

