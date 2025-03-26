📌 Overview
This is a Hybrid Test Automation Framework that supports both testing on Web and Mobile platforms.
The framework is built using Java 17, Appium v2.17.1, UIAutomator2 v4.1.5, Selenium WebDriver, TestNG, and Extent Reports for test reporting.

🚀 Tech Stack
Java: 17

- Appium: v2.17.1

- UIAutomator2 Driver: 4.1.5

- Selenium Java: 4.29.0

- TestNG: 7.6.1

- Extent Reports: 5.0.9

🛠️ Setup Instructions

1️⃣ Install Dependencies

Ensure you have the following installed:

- Java 17

- Appium Server v2.17.1

- Node.js (for Appium installation)

- UIAutomator2 Driver:

  - appium driver install uiautomator2@4.1.5

- Android SDK

- Ensure adb is accessible via terminal.

2️⃣ Install Required Java Dependencies

If using Maven, add the following dependencies to your pom.xml:

    <dependencies>
        <!-- Appium Java Client -->
        <dependency>
            <groupId>io.appium</groupId>
            <artifactId>java-client</artifactId>
            <version>9.3.0</version>
        </dependency>

        <!-- Selenium WebDriver -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.29.0</version>
        </dependency>

        <!-- Jackson Databind-->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.15.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>5.0.9</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.6.1</version>
            <scope>compile</scope>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.28</version>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20231013</version>
        </dependency>
    </dependencies>

3️⃣ Run Tests via Command Line

mvn clean test

mvn test -Dsurefire.suiteXmlFiles=testng.xml

📊 Generating Test Reports with Extent Reports
The framework integrates Extent Reports for better test reporting. After running tests, the report will be generated in the /reports directory.

📂 Project Structure
bash
Copy
Edit
Elfie/
│── logs/                     # Appium logs
│   ├── appium.log
│── reports/                   # Test execution reports
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/           # Main package
│   │   │   ├── config/        # Configuration files
│   │   │   ├── core/          # Driver setup & framework utilities
│   │   │   ├── page/          # Page Object Models (POM)
│   │   │   ├── utils/         # Helper utilities
│   │   │   ├── BaseTest.java  # Base test setup
│   │   ├── resources/
│   │   │   ├── app/           # Mobile app-related files
│   │   │   ├── config/        # Config properties (e.g., capabilities)
│   │   │   ├── suite/         # TestNG suite XML files
│   │   │   ├── testdata/      # Test data
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/         # Test cases
│── target/                    # Compiled test output
│── .gitignore
│── pom.xml                     # Maven dependencies
│── README.md                    # Project documentation
