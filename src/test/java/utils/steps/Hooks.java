package utils.steps;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class Hooks {

    protected WebDriver driver;
    protected String realUsername;
    protected String realPassword;
    protected String fakePassword;
    protected String domain;
    protected String searchQuery;
    protected String searchResultTitle;

    @BeforeMethod
    public void setup() throws IOException {

        realUsername = System.getenv("UsernameTheMovieDB");
        realPassword = System.getenv("PasswordTheMovieDB");

        fakePassword = new Faker().letterify("???????????????");

        domain = System.getenv("DomainTheMovieDB");

        searchQuery = System.getenv("SearchTheMovieDB");
        searchResultTitle = System.getenv("SearchTheMovieDB");


        driver = new ChromeDriver();
        driver.navigate().to(domain);
        //Es necesario establecer el tamanio, para que no se rompa el test,
        // ya que con paginas responsive los componentes pueden cambiar completamente
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void exit(){
       driver.quit();
    }




}
