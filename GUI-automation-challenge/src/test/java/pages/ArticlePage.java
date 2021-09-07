package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends BasePage{


    //private By articleTitle = By.tagName("h1");
    //esto es otra forma de crear webElements pero con factory de selenium
    @FindBy(tagName = "h1")
    private WebElement articleTitle;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText (){
        return articleTitle.getText();
        //return driver.findElement(articleTitle).getText();
    }
}
