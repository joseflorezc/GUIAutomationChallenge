package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends BasePage {


    @FindBy(css = ".search_results.movie > .results > div:nth-child(1) > div > .details > div:nth-child(1) > .title > div > a> h2")
    private WebElement firstItemResult;

    @FindBy(css = "#media_v4 > div > div > div.content > div:nth-child(1) > div:nth-child(2)")
    private WebElement filterButton;

    By resultsSearchItems = By.cssSelector("#page_1.page_wrapper");


    public ResultPage(WebDriver driver) {
        super(driver);
    }


    public String getTitleOfFirstResultMovies() {
        return firstItemResult.getText();
    }

    public void openFiltersMenu(){
        filterButton.click();
    }

    public void detailMediaResult(){}

    public void elementOfResultsIs(){

    }



}
