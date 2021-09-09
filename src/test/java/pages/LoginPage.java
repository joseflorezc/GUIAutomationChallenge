package pages;


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

    private By errorStatusCardBy = By.xpath("//*[@id=\"main\"]/section/div/div/div/div");

    private By errorMessagesBy = By.cssSelector(".carton > .content > ul > li");


    public LoginPage(WebDriver driver) {
        super(driver);
        Configurator.setLevel(LOGGER.getName(), Level.ALL);
    }


    public void fillUserName(String username) {
        LOGGER.debug("");
        usernameWebEle.sendKeys(username);

    }

    public void fillPassword(String password) {
        passwordWebEle.sendKeys(password);
    }

    public AccountPage loggingIn(){
        loginButtonWebEle.click();
        return new AccountPage(driver);
    }
    public void waitPresenceOfErrorStatusCardBy(){
        //explicit
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(errorStatusCardBy));

    }

    public String getErrorStatusText (){
        return errorStatusWebEle.getText();
    }

    private String [] messagesInError (){
        List <WebElement> messagesList = driver.findElements(errorMessagesBy);

        String [] messagesToReturn = new String[2];
        messagesToReturn[0] = messagesList.get(0).getText();
        messagesToReturn[1] = messagesList.get(1).getText();


//        System.out.println(messagesToReturn[1]);
        return messagesToReturn;

    }

    public String firstErrorMessage (){
        String [] containerMessages = messagesInError();
        System.out.println(containerMessages[0]);
        return containerMessages[0];
    }

    public String secondErrorMessage (){
        String [] containerMessages = messagesInError();
        System.out.println("second message"+containerMessages[1]);
        return containerMessages[1];
    }






}
