**Wise Staging Environment Automation Testing Overview**

This repository contains the automated test scripts for the Wise platform. The tests cover login, classroom navigation, session scheduling and session validation.

**Technology Stack**
1. Selenium (Java)
2. TestNG (for test execution)
3. Maven (for dependency management)
4. Constructor Injection (for better test structure)
5. POM (Page Object Model) (for maintaining the separation of concerns)
6. Email Reports (TestNG reports sent via email)

**Prerequisites**
1. Java 8+
2. Maven
3. Driver dependencies are already available in the project folder, so there is no need to install them separately.

**Setup Instructions**
1. Navigate to the Project Directory
2. mvn clean install
3. mvn test
4. Email Reports  - Once the tests are executed, email reports will be generated under test-output folder.

Or

1. Can execute the test classes one by one.
2. Can execute the classes with testNG.xml file.

**Folders and its usages**

**Main//**
1. Wise Main - Entry point.
2. Base - Single Class for object initialization.
3. Classes - Functions to perform.
4. Factory - Initialize Properties and Browser/Driver Initialization.
5. Interfaces - To encapsulate classes.
6. Locator Constants - To store elements as constants.
7. initialize objects and pass it to other classes 

**//Test**
1. Base - Single Class for object initialization.
2. Classes - To test the main class functions.

**//Resources**
1. Config - To store Test Data in form of properties file.
2. Test Runners - To execute the classes in sequential order with help of testng.xml file.

**//Test-Output**
1. To generate emailable reporters.

**Code Structure**
src/main/java: Contains the main code and classes (Page objects, Test classes).
src/test/java: Contains test classes, configurations and helpers.
testng.xml: TestNG configuration file for test execution.
pom.xml: Maven configuration file.
