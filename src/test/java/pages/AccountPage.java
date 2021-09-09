package pages;

import static org.apache.logging.log4j.LogManager.getLogger;

import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.apache.logging.log4j.LogManager.getLogger;

public class AccountPage extends BasePage {

    private final static Logger LOGGER = getLogger(AccountPage.class.getName());

    @FindBy(css = "div.block.header.gradient.green > div.inner_content  > div.content > div > div.about > div:nth-child(1) > h2 > a")
    private WebElement profileUserName;

    public AccountPage(WebDriver driver) {
        super(driver);

        Configurator.setLevel(LOGGER.getName(), Level.ALL);
    }


    @Step("Getting profile user name")
    public String getProfileUserName (){
        LOGGER.debug("Getting profile user name");
        return profileUserName.getText();

    }






}
