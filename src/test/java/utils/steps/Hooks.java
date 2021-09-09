package utils.steps;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;


public class Hooks {



    protected static String searchQuery;
    protected String searchResultTitle;
    protected String actionGenreText;
    protected String nameOfMovieOfActorTimeLine;


    protected String realUsername;
    protected String realPassword;
    protected String fakePassword;

    protected WebDriver driver;

    protected String domain;



    @BeforeMethod
    public void setup() throws IOException {

        searchQuery = System.getenv("SearchTheMovieDB");
        searchResultTitle = System.getenv("SearchTheMovieDB");

        actionGenreText = System.getenv("ActionTextTheMovieDB");
        nameOfMovieOfActorTimeLine = System.getenv("NameOfMovieOfActorTimeLineTheMovieDB");

        realUsername = System.getenv("UsernameTheMovieDB");
        realPassword = System.getenv("PasswordTheMovieDB");

        fakePassword = new Faker().letterify("???????????????");

        domain = System.getenv("DomainTheMovieDB");

        driver = new ChromeDriver();
        driver.navigate().to(domain);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void exit() {
        driver.quit();
    }


}
