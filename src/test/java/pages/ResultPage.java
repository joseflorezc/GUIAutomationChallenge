package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.steps.CommonSteps;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

public class ResultPage extends BasePage {

    private final static Logger LOGGER = getLogger(ResultPage.class.getName());

    @FindBy(css = ".search_results.movie > .results > div:nth-child(1) > div > .details > div:nth-child(1) > .title > div > a> h2")
    private WebElement firstItemResult;

    @FindBy(css = "#media_v4 > div > div > div.content > div:nth-child(1) > div:nth-child(2)")
    private WebElement filterButton;

    @FindBy(css = "div.filter_panel:nth-child(1) > div.filter > span")
    private WebElement sortByButton;


    @FindBy(css = "#with_genres > li:nth-child(1) > a")
    private WebElement actionButton;

    @FindBy(css = "div.apply.small.background_color.light_blue.enabled > p > a")
    private WebElement searchButtonForFilter;

    @FindBy(css = "#page_1.page_wrapper > div:nth-child(4) > div.content > h2 > a")
    private WebElement fourthMovieFromTopRatedMovies;

    @FindBy(css = "#sort_by_listbox > li[data-offset-index=\"5\"]")
    private WebElement sortByReleaseDateAscendingOption;




    By lastActionMovie = By.cssSelector("a[href='/movie/670'].image");

    By lastSortedByDateAscendingMovie = By.cssSelector("a[href='/movie/901'].image");

    By resultsSearchItems = By.cssSelector("#page_1.page_wrapper > div");

    By filterGenreOptions = By.cssSelector("#with_genres > li");

    By sortByOptionsList = By.cssSelector("#sort_by_listbox > li");


    public ResultPage(WebDriver driver) {
        super(driver);
        Configurator.setLevel(LOGGER.getName(), Level.ALL);

    }

    @Step("Returning the text of the first movie after searching")
    public String getTitleOfFirstResultMovies() {
        LOGGER.debug("Returning the text of the first movie after searching");
        return firstItemResult.getText();
    }

    @Step("Clicking to open the filters menu")
    public void openFiltersMenu() {
        LOGGER.debug("Clicking to open the filters menu");
        filterButton.click();
        waitUntilGenresAppear();
        LOGGER.debug("Finished clicking to open the filters menu");
    }

    @Step("Clicking on the action filter to turn it on")
    public void setActionFilterOn() {
        LOGGER.debug("Clicking on the action filter to turn it on");
        actionButton.click();
        LOGGER.debug("Finished clicking on the action filter");
    }

    @Step("Sending the request to update media items depending on filters")
    public void sendFilterPreferences() {
        scrollDownResultPage();
        LOGGER.debug("Sending the request to update media items depending on filters");
        searchButtonForFilter.click();
        waitUntilLastActionMovieAppears();
        LOGGER.debug("Finished sending the request to update media items depending on filters");
    }

    @Step("Sending the request to update media items depending on filters")
    public void sendSortByPreferences() {
        scrollDownResultPage();
        LOGGER.debug("Sending the request to update media items depending on filters");
        searchButtonForFilter.click();
        waitUntilLastSortedByDateAscendingMovieAppears();
        LOGGER.debug("Finished sending the request to update media items depending on filters");
    }

    @Step("Scrolling down the page")
    private void scrollDownResultPage(){
        LOGGER.debug("Scrolling down the page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1600)", "");
    }

    @Step("Clicking on the movie item selected from the results")
    public MediaDetailPage detailMediaResult() {

        LOGGER.debug("Getting the movie that is going to be tested");
        WebElement elementAnchorToDetailOfMovie = oneMovieOfResults().findElement(By.cssSelector("#page_1.page_wrapper > div > div.image > div.wrapper > a"));
        LOGGER.debug("Finished getting the movie that is going to be tested");
        LOGGER.debug("Clicking on the movie item selected from the results");
        elementAnchorToDetailOfMovie.click();
        LOGGER.debug("Finished clicking on the movie item selected from the results");
        LOGGER.info("Going to enter to the detail of the movie item selected from the grid");
        return new MediaDetailPage(driver);
    }

    @Step("Selecting a movie from the results")
    private WebElement oneMovieOfResults() {

        LOGGER.debug("Going to generate a random number to select the movie to test");
        int elementPicked = CommonSteps.getRandomNumberInRange(0, 19);

        LOGGER.debug("The random number generated to select the movie to test was: " + elementPicked);
        LOGGER.debug("Selecting the movie from the results");
        List<WebElement> listResults = driver.findElements(resultsSearchItems);

        LOGGER.debug("Finished selecting the movie from the results");
        return listResults.get(elementPicked);
    }

    @Step("Clicking on the fourth movie")
    public MediaDetailPage detailOfFourthMovieOfResults() {

        LOGGER.debug("Clicking on the fourth movie");
        fourthMovieFromTopRatedMovies.click();
        LOGGER.debug("Going to Detail of the fourth movie");

        return new MediaDetailPage(driver);
    }

    @Step("Opening the filters menu")
    public void openSortingMenu() {
        LOGGER.debug("Clicking to open the filters menu");
        sortByButton.click();
        waitUntilSortByListAppear();
        LOGGER.debug("Finished clicking to open the filters menu");
    }

    @Step("Selecting the option release date ascending")
    public void selectSortingByReleaseDateAscending() {
        LOGGER.debug("Clicking on the release date ascending to select it");
        sortByReleaseDateAscendingOption.click();
        LOGGER.debug("Finished clicking on the release date ascending to select it");
    }

    @Step("Start comparing all dates and saving on Array")
    public Boolean comparingDatesOfMovies() throws ParseException {

        Boolean[] correctOrder = new Boolean[3];
        String[] datesOfMovies = extractingDatesofFirstfourSortedMovies();
        LOGGER.debug("Start comparing all dates and saving on Array");
        for (int currentMovie = 0; currentMovie < 3; currentMovie++) {
            correctOrder[currentMovie] = CommonSteps.compareAscendingOrderOfDates(datesOfMovies[currentMovie], datesOfMovies[currentMovie+1]);
        }

        LOGGER.debug("Finished comparing all dates and now are save on an Array");

        return Arrays.asList(correctOrder).stream().allMatch(val -> val == true);
    }

    @Step("Getting the Dates of a list of movies in the results ")
    private String[] extractingDatesofFirstfourSortedMovies(){
        String [] datesOfMovies = new String[4];
        LOGGER.debug("Getting the list of movies in the results ");
        List<WebElement> listResults = driver.findElements(resultsSearchItems);

        for (int currentMovie = 0; currentMovie < 4; currentMovie++) {
            WebElement currentDate = listResults.get(currentMovie).findElement(By.cssSelector("#page_1.page_wrapper > div > div.content > p"));
            datesOfMovies[currentMovie] = currentDate.getText();
        }

        LOGGER.debug("Finished getting the list of movies in the results ");
        return datesOfMovies;
    }


    @Step("Waiting until genre options appear")
    private void waitUntilGenresAppear() {
        LOGGER.debug("Start waiting until genre options appear");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(filterGenreOptions, 1));
        LOGGER.debug("Finished waiting until genre options appear");
    }

    @Step("Waiting until the last action movie loads")
    private void waitUntilLastActionMovieAppears(){
        //explicit
        LOGGER.debug("Start waiting until the last action movie loads");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(lastActionMovie));
        LOGGER.debug("Finished waiting for the last action movie to load");

    }

    @Step("Waiting until sort by list appear")
    private void waitUntilSortByListAppear() {
        LOGGER.debug("Start waiting until sort by list appear");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(sortByOptionsList, 3));
        LOGGER.debug("Finished waiting until sort by list appear");
    }

    @Step("Waiting until the last sorted movie loads")
    private void waitUntilLastSortedByDateAscendingMovieAppears(){
        //explicit
        LOGGER.debug("Start waiting until the last sorted movie loads");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(lastSortedByDateAscendingMovie));
        LOGGER.debug("Finished waiting for the last sorted movie to load");

    }




}
