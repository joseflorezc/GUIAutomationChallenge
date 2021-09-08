package pages;

import com.google.common.graph.AbstractNetwork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {


    @FindBy(id = "username")
    private WebElement usernameWebEle;
    @FindBy(id = "password")
    private WebElement passwordWebEle;
    @FindBy(id = "login_button")
    private WebElement loginButtonWebEle;

    @FindBy(css = ".carton > a  > .background_color > span")
    private WebElement errorStatusWebEle;

    private By errorStatusCardBy = By.xpath("//*[@id=\"main\"]/section/div/div/div/div");

    private By errorMessagesBy = By.cssSelector(".carton > .content > ul > *");


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void fillUserName(String username) {
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
        //implicit
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    public String getErrorStatusText (){
        return errorStatusWebEle.getText();
    }

    public String [] messagesInError (){
        List <WebElement> messagesList = driver.findElements(errorMessagesBy);

        String [] messagesToReturn = new String[2];
        messagesToReturn[0] = messagesList.get(0).toString();
        messagesToReturn[1] = messagesList.get(1).toString();

        return messagesToReturn;

    }

    public String firstErrorMessage (){
        String [] containerMessages = messagesInError();
        return containerMessages[0];
    }

    public String secondErrorMessage (){
        String [] containerMessages = messagesInError();
        return containerMessages[1];
    }






}
