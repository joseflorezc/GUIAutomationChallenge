package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class LoginPage extends BasePage {

    private final static Logger LOGGER = getLogger(LoginPage.class.getName());

    @FindBy(id = "username")
    private WebElement usernameWebEle;
    @FindBy(id = "password")
    private WebElement passwordWebEle;
    @FindBy(id = "login_button")
    private WebElement loginButtonWebEle;

    @FindBy(css = ".carton > a  > .background_color > span")
    private WebElement errorStatusWebEle;

    private By errorStatusCardBy = By.cssSelector("h2.background_color.red");

    private By errorMessagesBy = By.cssSelector(".carton > .content > ul > li");


    public LoginPage(WebDriver driver) {
        super(driver);
        Configurator.setLevel(LOGGER.getName(), Level.ALL);
    }


    @Step
    public void fillUserName(String username) {
        LOGGER.debug("Start filling username TextBox");
        usernameWebEle.sendKeys(username);
        LOGGER.debug("Finish filling username TextBox");

    }

    @Step
    public void fillPassword(String password) {
        LOGGER.debug("Filling password TextBox");
        passwordWebEle.sendKeys(password);
        LOGGER.debug("Finish filling password TextBox");
    }

    @Step("Clicking login and now going to account detail")
    public AccountPage loggingIn(){
        LOGGER.debug("Clicking login and now going to account detail");
        loginButtonWebEle.click();
        return new AccountPage(driver);
    }
    @Step("Waiting for the error status to appear ")
    public void waitPresenceOfErrorStatusCardBy(){

        LOGGER.debug("Waiting for the error status to appear ");
        //explicit
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(errorStatusCardBy));
        LOGGER.debug("Finished waiting for the error status to appear ");

    }

    @Step("Getting error status text ")
    public String getErrorStatusText (){
        LOGGER.debug("Getting error status text ");
        return errorStatusWebEle.getText();
    }

    @Step("Getting the messages from the error status")
    private String [] messagesInError (){
        LOGGER.debug("Getting the messages from the error status");
        List <WebElement> messagesList = driver.findElements(errorMessagesBy);

        String [] messagesToReturn = new String[2];
        messagesToReturn[0] = messagesList.get(0).getText();
        messagesToReturn[1] = messagesList.get(1).getText();
        LOGGER.debug("Finished getting the messages from the error status");
        return messagesToReturn;

    }

    @Step("Giving the first message from the error status")
    public String firstErrorMessage (){
        LOGGER.debug("Giving the first message from the error status");
        String [] containerMessages = messagesInError();

        return containerMessages[0];
    }

    @Step("Giving the second message from the error status")
    public String secondErrorMessage (){
        LOGGER.debug("Giving the second message from the error status");
        String [] containerMessages = messagesInError();
        return containerMessages[1];
    }






}
