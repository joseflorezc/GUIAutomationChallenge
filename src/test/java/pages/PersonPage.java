package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.apache.logging.log4j.LogManager.getLogger;

public class PersonPage extends BasePage {

    private final static Logger LOGGER = getLogger(PersonPage.class.getName());

    @FindBy(css = " a.tooltip[href=\"/movie/238\"]")
    private WebElement movieInTimeline;


    public PersonPage(WebDriver driver) {
        super(driver);
        Configurator.setLevel(LOGGER.getName(), Level.ALL);
    }


    @Step("Sending the Title of the Movie from the Time Line")
    public String getTextOfMovieFromTimeLine (){
        LOGGER.debug("Sending the Title of the Movie from the Time Line");
        return movieInTimeline.getText();
    }






}
