package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

public class MediaDetailPage extends BasePage {

    private final static Logger LOGGER = getLogger(MediaDetailPage.class.getName());

    @FindBy(css = " a[href=\"/genre/28-action/movie\"]")
    private WebElement actionGenreAnchor;

    By peopleInTopBilledCast = By.cssSelector("#cast_scroller > ol > li");


    public MediaDetailPage(WebDriver driver) {
        super(driver);
    }


    public String getActionGenreText (){
        return actionGenreAnchor.getText();
    }
    public PersonPage detailPersonTopBilled() {

        LOGGER.debug("Getting the movie that is going to be tested");
        WebElement elementAnchorToDetailToPerson = firstActorInTopBilledCast().findElement(By.cssSelector("#cast_scroller > ol > li > a"));
        LOGGER.debug("Finished getting the movie that is going to be tested");
        LOGGER.debug("Clicking on the movie item selected from the results");
        elementAnchorToDetailToPerson.click();
        LOGGER.debug("Finished clicking on the movie item selected from the results");
        LOGGER.info("Going to enter to the detail of the movie item selected from the grid");
        return new PersonPage(driver);
    }

    private WebElement firstActorInTopBilledCast() {

        LOGGER.debug("Selecting the first person of the Top Billed Cast");
        List<WebElement> listResults = driver.findElements(peopleInTopBilledCast);

        LOGGER.debug("Finished selecting the first person of the Top Billed Cast");
        return listResults.get(0);
    }







}
