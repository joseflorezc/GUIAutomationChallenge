package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage{


    @FindBy(css = "ul.primary > li:nth-child(3) > a")
    private WebElement login;

    @FindBy(css = "a[href='/movie/top-rated']")
    private WebElement topRatedMovies;


    @FindBy(css = " div.nav_wrapper > ul > li:nth-child(1) > a")
    private WebElement moviesNavButton;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Movies Menu in navbar")
    public void openMoviesMenu (){

        moviesNavButton.click();
    }

    @Step("Open top rated movies")
    public void openTopRatedMovies(){
        topRatedMovies.click();
    }

    @Step("Open login menu")
    public void openLoginMenu(){
        login.click();
    }



}
