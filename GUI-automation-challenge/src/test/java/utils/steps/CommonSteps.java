package utils.steps;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

public class CommonSteps extends BasePage {


    public CommonSteps(WebDriver driver) {
        super(driver);
    }

    public void waitImplicit(){
        //explicit
//        WebDriverWait wait = new WebDriverWait(driver, 3);
//        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(suggestedItems, 3));
        //implicit
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

}
