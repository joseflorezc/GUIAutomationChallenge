package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
//import java.util.concurrent.TimeUnit;

public class LandingPage extends BasePage{


    @FindBy(xpath = "/html/body/div[1]/header/div[1]/div/div[2]/ul/li[3]/a")
    private WebElement login;

    @FindBy(css = "#inner_search_form > input[type=submit]")
    private WebElement searchButton;

    @FindBy(id = "inner_search_v4")
    private WebElement searchBar;

    By movieOptionsMenu = By.cssSelector(" li.k-item.k-menu-item.k-state-default.k-first.k-state-border-down > div > ul > li");





    public LandingPage(WebDriver driver){
        super(driver);
        header = new HeaderPage(driver);
    }



    public LoginPage login(){
        login.click();
        return new LoginPage(driver);
    }

    public void search (String query){

        searchBar.sendKeys(query);

    }

    public ResultPage sendSearchRequest(){

        searchButton.click();

        return new ResultPage(driver);
    }

    public void openingHeaderMovieMenu(){

        header.openMoviesMenu();
    }

    public ResultPage openingTopRatedMovies(){

        header.openTopRatedMovies();
        return new ResultPage(driver);
    }

    public void waitExplicitNumberOfElementsMoreThanOne(){

        List<WebElement> listMovieOptions = driver.findElements(movieOptionsMenu);
        //explicit
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(movieOptionsMenu, 1));
        //implicit
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }



}
