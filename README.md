# Make-My-Trip-Automation

A comprehensive **Selenium-based Test Automation Framework** for MakeMyTrip.com built with Java, TestNG, and Page Object Model (POM). This project demonstrates end-to-end automation testing of flight booking workflows with advanced Selenium techniques.


## 📸 Screenshot

### TestNG Report Screenshots
<img width="640" height="916" alt="Screenshot 2026-02-07 210256" src="https://github.com/user-attachments/assets/d6e77dfa-dc53-4e6f-afa1-defa43519151" />


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


## 🔑 Key Technologies Used in Project.

### 1. **Page Object Model (POM)**

### 2. **Data-Driven Testing (DDT)**

### 3. **Synchronization Strategies**

### 4. **WebDriver Management**

### 5. **Locator Strategies**

### 6. **Calendar/Date Picker Handling**

### 7. **Auto-Suggestion Handling**

### 8. **Scrolling**

### 9. **Popup Handling**

### 10. **IFrame Handling**

### 11. **Child Window/Tab Handling**





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



## 🙏 Acknowledgments

- Selenium WebDriver Documentation
- TestNG Framework
- MakeMyTrip for providing the test application
- Java Community

  
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


## 📞 Contact & Support

- **Author**: Aryan Mishra
- **GitHub**: [AryanMishra17](https://github.com/AryanMishra17)
- **Repository**: [Make-My-Trip-Automation](https://github.com/AryanMishra17/Make-My-Trip-Automation)
- **Email**: [mishraaryan813@gmail.com]

---
---

