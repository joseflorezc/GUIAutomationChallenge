# GUIAutomationChallenge
Maven pom:

Dependencies:
1. testNg - 7.4.0 - https://mvnrepository.com/artifact/org.testng/testng
2. selenium-java - 3.141.59 - https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
3. hamcrest - 2.2 - https://mvnrepository.com/artifact/org.hamcrest/hamcrest
4. log4j-core - 2.14.1 - https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
5. javafaker - 1.0.2 - https://mvnrepository.com/artifact/com.github.javafaker/javafaker
6. allure-testng - 2.14.0 - https://mvnrepository.com/artifact/io.qameta.allure/allure-testng
7. maven-surefire-plugin - 3.0.0-M5

Plugins:
1. maven-compiler-plugin
2. maven-surefire-plugin - 3.0.0-M5

### Command for execution

#### To run tests and generate Allure report:
```
mvn clean verify

allure serve "{path to allure-results}"

