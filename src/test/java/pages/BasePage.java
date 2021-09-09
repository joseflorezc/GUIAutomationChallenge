package pages;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.apache.logging.log4j.LogManager.getLogger;

public class BasePage {

    protected WebDriver driver;
    protected HeaderPage header;


    public BasePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


}
