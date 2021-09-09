package pages;


import static org.apache.logging.log4j.LogManager.getLogger;

import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class LandingPage extends BasePage{

    private final static Logger LOGGER = getLogger(LandingPage.class.getName());


    @FindBy(css = "#inner_search_form > input[type=submit]")
    private WebElement searchButton;

    @FindBy(id = "inner_search_v4")
    private WebElement searchBar;

    By movieOptionsMenu = By.cssSelector(" li.k-item.k-menu-item.k-state-default.k-first.k-state-border-down > div > ul > li");





    public LandingPage(WebDriver driver){
        super(driver);
        header = new HeaderPage(driver);
        Configurator.setLevel(LOGGER.getName(), Level.ALL);

    }



    @Step("Clicking on the login Button")
    public LoginPage login(){
        LOGGER.debug("Clicking on the login Button");
        header.openLoginMenu();
        LOGGER.debug("The click on the login button was succesfull");
        LOGGER.info("Going to enter to Login Page");
        return new LoginPage(driver);
    }

    @Step("Filling search bar with query")
    public void search (String query){

        LOGGER.debug("Filling search bar with query");
        searchBar.sendKeys(query);
        LOGGER.debug("Finished filling search bar with query");

    }

    @Step("Sending query request by clicking on the search button")
    public ResultPage sendSearchRequest(){

        LOGGER.debug("Sending query request by clicking on the search button");
        searchButton.click();
        LOGGER.debug("finished clicking the search button");

        LOGGER.info("Going to Enter to ResultPage");
        return new ResultPage(driver);
    }

    @Step("Opening Movies Menu of Header")
    public void openingHeaderMovieMenu(){

        LOGGER.debug("Opening Movies Menu of Header");
        header.openMoviesMenu();
        waitExplicitNumberOfElementsMoreThanOne();
        LOGGER.debug("Finished Opening Movies Menu of Header");

    }

    @Step("Clicking on the top rated option of Movies")
    public ResultPage openingTopRatedMovies(){
        LOGGER.debug("Clicking on the top rated option of Movies");
        header.openTopRatedMovies();
        LOGGER.debug("Finished clicking on the top rated option of Movies");

        LOGGER.info("Going to Enter to ResultPage for Top Rated Movies");
        return new ResultPage(driver);
    }

    @Step("Waiting for the options of movie navbar to appear")
    public void waitExplicitNumberOfElementsMoreThanOne(){

        LOGGER.debug("Waiting for the options of movie navbar to appear");

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(movieOptionsMenu, 1));
        LOGGER.debug("finished waiting for the options of movie navbar to appear");


    }





}
