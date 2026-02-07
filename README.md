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
- [Configuration](#configuration)<img width="640" height="916" alt="Screenshot 2026-02-07 210256" src="https://github.com/user-attachments/assets/d6e77dfa-dc53-4e6f-afa1-defa43519151" />

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

### Step 3: Update Test Data
Create `testdata.xlsx` with columns:
- FromCity
- ToCity
- DepartDate
- ReturnDate
- Passengers
- TravelClass


---

## 🔑 Key Technologies Explained

### 1. **Page Object Model (POM)**
Separates test logic from UI locators for better maintainability.

### 2. **Data-Driven Testing (DDT)**
Runs same test with multiple data sets from external source.

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


### 5. **Locator Strategies**


### 6. **Calendar/Date Picker Handling**

### 7. **Auto-Suggestion Handling**

### 8. **Scrolling**


### 9. **Popup Handling**


### 10. **IFrame Handling**


### 11. **Child Window/Tab Handling**




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

---




## pom.xml Dependencies

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
- **Email**: [mishraaryan813@gmail.com]

---

## 🙏 Acknowledgments

- Selenium WebDriver Documentation
- TestNG Framework
- MakeMyTrip for providing the test application
- Java Community

---

