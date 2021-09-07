package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LandingPage extends BasePage{


    @FindBy(xpath = "/html/body/div[1]/header/div[1]/div/div[2]/ul/li[3]/a")
    private WebElement login;
    private By searchBar = By.id("searchInput");
    private By suggestedItems = By.cssSelector(".suggestion-dropdown >a");


    public LandingPage(WebDriver driver){
        super(driver);
    }

    public void waitForSuggestedItems(){
        //explicit
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(suggestedItems, 3));
        //implicit
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    public void login(){
        login.click();
    }

    public void search (String query){


        driver.findElement(searchBar).sendKeys(query);
        waitForSuggestedItems();
    }

    public ArticlePage clickFirstArticle(){
        List<WebElement> suggestedItemsList = driver.findElements(suggestedItems);
        suggestedItemsList.get(0).click();

        return new ArticlePage(driver);
    }

}
