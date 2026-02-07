# Make-My-Trip-Automation

A comprehensive **Selenium-based Test Automation Framework** for MakeMyTrip.com built with Java, TestNG, and Page Object Model (POM). This project demonstrates end-to-end automation testing of flight booking workflows with advanced Selenium techniques.

---

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Key Technologies](#key-technologies)
- [Test Execution](#test-execution)
- [TestNG Reports](#testng-reports)
- [Video Demonstrations](#video-demonstrations)
- [Screenshots](#screenshots)
- [Advanced Features](#advanced-features)
- [Configuration](#configuration)
- [Contributing](#contributing)

---

## 🎯 Project Overview

This automation framework automates the **MakeMyTrip flight booking process** with comprehensive test scenarios covering various web elements and interactions. It demonstrates best practices in test automation including POM architecture, data-driven testing, and robust synchronization techniques.

---

## ✨ Features

### Core Testing Features
✅ **Page Object Model (POM)** - Maintains clean separation of test logic and locators  
✅ **Data-Driven Testing (DDT)** - External data source management for multiple test scenarios  
✅ **TestNG Framework** - Advanced test execution and reporting  
✅ **WebDriver Management** - Centralized browser driver initialization and cleanup  
✅ **Implicit & Explicit Waits** - Robust synchronization strategies  
✅ **Screenshot Capture** - Auto-capture on test failures  
✅ **Maven Build** - Dependency management and test execution

### Advanced Web Element Handling
✅ **Calendar/Date Picker** - Automated date selection  
✅ **Auto-Suggestion Handling** - Dropdown suggestion selection  
✅ **Dynamic Scrolling** - Scroll to elements for visibility  
✅ **Popup Handling** - Alert, confirmation, and custom popup management  
✅ **IFrame Handling** - Switch between nested frames  
✅ **Child Window/Tab Handling** - Multi-window switching  
✅ **Element Locators** - Multiple locator strategies (XPath, CSS, ID, Class, Name)  

---

## 🛠️ Tech Stack

| Component | Technology |
|-----------|-----------|
| **Language** | Java |
| **Testing Framework** | TestNG |
| **Browser Automation** | Selenium WebDriver |
| **Build Tool** | Maven (POM) |
| **Test Data** | Excel/CSV (DDT) |
| **Reporting** | TestNG HTML Reports |
| **IDE** | Eclipse/IntelliJ |
| **Version Control** | Git |

---

## 📁 Project Structure

```
Make-My-Trip-Automation/
│
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   ├── BaseClass.java          # Base setup/teardown
│   │   │   │   └── DriverManager.java      # WebDriver management
│   │   │   ├── pages/
│   │   │   │   ├── HomePage.java           # Home page locators & methods
│   │   │   │   ├── FlightSearchPage.java   # Flight search page
│   │   │   │   ├── SearchResultsPage.java  # Search results page
│   │   │   │   ├── PassengerDetailsPage.java
│   │   │   │   └── PaymentPage.java        # Payment page
│   │   │   ├── tests/
│   │   │   │   ├── HomePageTest.java       # Test cases
│   │   │   │   ├── FlightBookingTest.java  # E2E booking tests
│   │   │   │   └── DDTTest.java            # Data-driven tests
│   │   │   ├── utils/
│   │   │   │   ├── ExcelDataProvider.java  # Read test data
│   │   │   │   ├── ElementActions.java     # Reusable methods
│   │   │   │   ├── WaitManager.java        # Synchronization
│   │   │   │   └── ScreenshotManager.java  # Screenshot capture
│   │   │   └── listeners/
│   │   │       └── TestListener.java       # TestNG listeners
│   │   └── resources/
│   │       ├── Data.properties             # Configuration file
│   │       ├── testdata.xlsx               # Test data
│   │       └── testng.xml                  # TestNG config
│
├── test-output/                            # TestNG reports
│   ├── emailable-report.html
│   └── index.html
│
├── Screenshot's/                           # Failure screenshots
│   └── [failure_screenshots]
│
├── screenshots/                            # Working screenshots
│   └── [execution_screenshots]
│
├── pom.xml                                 # Maven dependencies
├── Data.properties                         # Application config
├── README.md                               # This file
└── .gitignore

```

---

## 📋 Prerequisites

Before running the tests, ensure you have:

- **Java JDK 8+** installed
- **Maven 3.6+** installed
- **Git** for version control
- **ChromeDriver/GeckoDriver** (automatically managed via WebDriverManager)
- **IDE** (Eclipse or IntelliJ)
- **Test Data Files** (Excel sheet with test cases)

---

## 🚀 Installation & Setup

### Step 1: Clone the Repository
```bash
git clone https://github.com/AryanMishra17/Make-My-Trip-Automation.git
cd Make-My-Trip-Automation
```

### Step 2: Import Project
```bash
# Using Maven
mvn clean install

# Or import directly into your IDE
```

### Step 3: Configure Data.properties
Update `Data.properties` with your test environment details:
```properties
# Browser Configuration
browser=chrome
headless=false
implicitWait=10
explicitWait=20

# Application URL
baseUrl=https://www.makemytrip.com/

# Test Data
testDataPath=src/test/resources/testdata.xlsx
screenshotPath=screenshots/
```

### Step 4: Update Test Data
Create `testdata.xlsx` with columns:
- FromCity
- ToCity
- DepartDate
- ReturnDate
- Passengers
- TravelClass

### Step 5: Run Tests
```bash
# Run all tests
mvn test

# Run specific test
mvn test -Dtest=FlightBookingTest

# Run with TestNG XML
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml
```

---

## 🔑 Key Technologies Explained

### 1. **Page Object Model (POM)**
Separates test logic from UI locators for better maintainability.

```java
public class HomePage {
    @FindBy(id="origin") 
    private WebElement fromField;
    
    public void enterFromCity(String city) {
        fromField.sendKeys(city);
    }
}
```

### 2. **Data-Driven Testing (DDT)**
Runs same test with multiple data sets from external source.

```java
@DataProvider(name = "flightData")
public Object[][] getFlightData() {
    return ExcelDataProvider.getTestData("testdata.xlsx");
}

@Test(dataProvider = "flightData")
public void bookFlight(String from, String to, String date) {
    // Test code
}
```

### 3. **Synchronization Strategies**

#### Implicit Wait
```java
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
```

#### Explicit Wait
```java
WebDriverWait wait = new WebDriverWait(driver, 20);
wait.until(ExpectedConditions.visibilityOf(element));
wait.until(ExpectedConditions.elementToBeClickable(element));
```

#### Custom Wait
```java
public static void waitForElement(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOf(element));
}
```

### 4. **WebDriver Management**

```java
public class DriverManager {
    private static WebDriver driver;
    
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```

### 5. **Locator Strategies**

```java
// ID
By.id("origin")

// XPath
By.xpath("//input[@placeholder='From']")

// CSS Selector
By.cssSelector("input.city-field")

// Name
By.name("departure")

// Class Name
By.className("search-field")

// Link Text
By.linkText("Flights")
```

### 6. **Calendar/Date Picker Handling**

```java
public void selectDepartureDate(String date) {
    // Click on date field
    datePicker.click();
    
    // Find and click specific date
    WebElement dateElement = driver.findElement(
        By.xpath("//div[@data-date='" + date + "']")
    );
    dateElement.click();
}
```

### 7. **Auto-Suggestion Handling**

```java
public void selectFromCity(String city) {
    fromField.sendKeys(city);
    
    // Wait for suggestion dropdown
    WebElement suggestion = new WebDriverWait(driver, 10)
        .until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//li[contains(text(), '" + city + "')]')
        ));
    suggestion.click();
}
```

### 8. **Scrolling**

```java
// Scroll to element
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView(true);", element);

// Scroll down
js.executeScript("window.scrollBy(0, 500);");

// Scroll up
js.executeScript("window.scrollBy(0, -500);");
```

### 9. **Popup Handling**

#### Alert Popup
```java
Alert alert = driver.switchTo().alert();
alert.accept();  // OK button
alert.dismiss(); // Cancel button
alert.getText(); // Get text
```

#### Custom Popup
```java
WebElement popup = driver.findElement(By.id("popup"));
WebElement closeBtn = popup.findElement(By.className("close"));
closeBtn.click();
```

### 10. **IFrame Handling**

```java
// Switch to iframe by index
driver.switchTo().frame(0);

// Switch to iframe by ID
driver.switchTo().frame("iframeId");

// Switch to iframe by WebElement
WebElement iframe = driver.findElement(By.id("iframe"));
driver.switchTo().frame(iframe);

// Switch back to main content
driver.switchTo().defaultContent();
```

### 11. **Child Window/Tab Handling**

```java
// Get original window handle
String originalWindow = driver.getWindowHandle();

// Get all window handles
Set<String> allWindows = driver.getWindowHandles();

// Switch to new window
for (String windowHandle : allWindows) {
    if (!windowHandle.equals(originalWindow)) {
        driver.switchTo().window(windowHandle);
        break;
    }
}

// Switch back
driver.switchTo().window(originalWindow);
```

### 12. **Methods & Reusable Components**

```java
public class ElementActions {
    
    public static void clickElement(WebElement element) {
        new WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(element))
            .click();
    }
    
    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
    
    public static String getText(WebElement element) {
        return element.getText();
    }
    
    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException) {
            return false;
        }
    }
}
```

---

## 📊 Test Execution

### Maven Command Examples

```bash
# Clean and install dependencies
mvn clean install

# Run all tests
mvn test

# Run with specific TestNG XML
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml

# Run specific test class
mvn test -Dtest=FlightBookingTest

# Run specific test method
mvn test -Dtest=FlightBookingTest#testCompleteFlightBooking

# Generate reports
mvn surefire-report:report
```

### TestNG XML Configuration

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Make My Trip Suite">
    <test name="Flight Booking Tests">
        <classes>
            <class name="tests.FlightBookingTest"/>
            <class name="tests.HomePageTest"/>
        </classes>
    </test>
</suite>
```

---

## 📈 TestNG Reports

### Report Locations

```
test-output/
├── index.html                    # Main Report
├── emailable-report.html         # Email-friendly Report
├── testng-results.xml            # XML Report
└── [Test Details]
```

### View Reports

1. **HTML Report**: Open `test-output/index.html` in browser
2. **Console Output**: View Maven console
3. **Eclipse TestNG**: View TestNG Results tab

### Report Features
- ✅ Test Pass/Fail Status
- ✅ Execution Duration
- ✅ Stack Traces for Failures
- ✅ Screenshots of Failures
- ✅ Test Configuration Details

---

## 🎥 Video Demonstrations

### Video 1: Complete Test Execution Demo
- **Link**: [Add your video link here]
- **Duration**: [XX minutes]
- **Content**: 
  - Full flight booking automation flow
  - Test execution from start to finish
  - Real-time browser interactions
  - Multiple test scenarios

### Video 2: TestNG Report Showcase
- **Link**: [Add your video link here]
- **Duration**: [XX minutes]
- **Content**:
  - TestNG report generation
  - Report analysis and details
  - Pass/Fail statistics
  - Failure screenshots review

---

## 📸 Screenshots

### TestNG Report Screenshots

#### Test Report Dashboard
![TestNG Report](screenshots/testng-report-dashboard.png)

#### Test Results Summary
![Test Results](screenshots/test-results-summary.png)

#### Individual Test Details
![Test Details](screenshots/test-details.png)

### Application Screenshots

#### Home Page
![Home Page](screenshots/homepage.png)

#### Flight Search Results
![Search Results](screenshots/search-results.png)

#### Passenger Details
![Passenger Details](screenshots/passenger-details.png)

#### Payment Page
![Payment Page](screenshots/payment-page.png)

---

## 🚀 Advanced Features

### Feature 1: Data-Driven Testing
```java
@DataProvider(name = "bookingData")
public Object[][] getBookingData() throws IOException {
    return ExcelDataProvider.readExcelData("testdata.xlsx", "Sheet1");
}

@Test(dataProvider = "bookingData")
public void testFlightBooking(String from, String to, String date) {
    // Execute test with different data
}
```

### Feature 2: Screenshot on Failure
```java
@Override
public void onTestFailure(ITestResult result) {
    WebDriver driver = (WebDriver) result.getTestContext()
        .getAttribute("driver");
    ScreenshotManager.captureScreenshot(driver, result.getName());
}
```

### Feature 3: Custom Listeners
```java
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        captureScreenshot();
    }
}
```

---

## ⚙️ Configuration

### Data.properties File
```properties
# Browser Settings
browser=chrome
headless=false
pageLoadTimeout=30
implicitWait=10
explicitWait=20

# URLs
baseUrl=https://www.makemytrip.com/
loginUrl=https://www.makemytrip.com/account/login

# Test Data Paths
testDataPath=src/test/resources/testdata.xlsx
screenshotPath=screenshots/

# Logging
logLevel=INFO
```

### pom.xml Dependencies

```xml
<dependencies>
    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.0.0</version>
    </dependency>
    
    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.5.1</version>
    </dependency>
    
    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.3.2</version>
    </dependency>
    
    <!-- Apache POI (Excel) -->
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi</artifactId>
        <version>5.2.0</version>
    </dependency>
</dependencies>
```

---

## 📚 Maven Commands Cheat Sheet

```bash
# Clean project
mvn clean

# Install dependencies
mvn install

# Run tests
mvn test

# Generate reports
mvn test -Dtest=FlightBookingTest
mvn surefire-report:report

# Skip tests
mvn clean install -DskipTests

# Compile only
mvn compile

# Run specific TestNG XML
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml
```

---

## 🔧 Troubleshooting

### Common Issues

| Issue | Solution |
|-------|----------|
| **Driver not found** | Use WebDriverManager or download ChromeDriver |
| **Element not clickable** | Use explicit wait and scroll to element |
| **Timeout exceptions** | Increase wait times in Data.properties |
| **IFrame not found** | Ensure correct frame index or ID |
| **Popup not handled** | Add explicit wait for popup appearance |
| **Test data not loading** | Verify Excel file path and sheet name |

---

## 💡 Best Practices Implemented

✅ **DRY Principle** - Reusable methods in utility classes  
✅ **POM Architecture** - Clean separation of concerns  
✅ **Explicit Waits** - Avoid flaky tests  
✅ **Error Handling** - Try-catch blocks for robustness  
✅ **Logging** - Track test execution flow  
✅ **Screenshot Capture** - Evidence of failures  
✅ **Configuration Management** - External properties file  
✅ **Test Data Management** - DDT with Excel  

---

## 📞 Contact & Support

- **Author**: Aryan Mishra
- **GitHub**: [AryanMishra17](https://github.com/AryanMishra17)
- **Repository**: [Make-My-Trip-Automation](https://github.com/AryanMishra17/Make-My-Trip-Automation)
- **Email**: [your-email@example.com]

---

## 📄 License

This project is licensed under the MIT License - see LICENSE file for details.

---

## 🙏 Acknowledgments

- Selenium WebDriver Documentation
- TestNG Framework
- MakeMyTrip for providing the test application
- Java Community

---

**Last Updated**: 2026-02-07 15:36:38  
**Status**: ✅ Active & Maintained