package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage{


    @FindBy(css = "a[href='/movie/top-rated']")
    private WebElement topRatedMovies;


    @FindBy(css = " div.nav_wrapper > ul > li:nth-child(1) > a")
    private WebElement moviesNavButton;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void openMoviesMenu (){

        moviesNavButton.click();
//        Actions act = new Actions(driver);
//        act.moveToElement(moviesNavButton);
    }

    public void openTopRatedMovies(){
        topRatedMovies.click();
    }

}
