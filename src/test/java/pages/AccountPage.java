package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {


    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div/div/div/div/div/div[1]/h2/a")
    private WebElement profileUserName;


    public AccountPage(WebDriver driver) {
        super(driver);
    }


    public String getProfileUserName (){
        return profileUserName.getText();
    }






}
