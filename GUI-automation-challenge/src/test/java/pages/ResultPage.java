package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends BasePage {


    @FindBy(css= ".results > div:nth-child(1) > div > .details > div:nth-child(1) > .title > div > a[data-id='4bc88fc1017a3c122d009254'] > h2")
    private WebElement firstItemResult;


    public ResultPage(WebDriver driver) {
        super(driver);
    }


    public String getTitleOfFirstResult (){
        return firstItemResult.getText();
    }






}
