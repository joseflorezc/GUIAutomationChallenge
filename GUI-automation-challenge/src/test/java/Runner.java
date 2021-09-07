
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.LandingPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Runner extends Hooks {

    @Test
    public void FirstTest() {

        LandingPage landingPage = new LandingPage(driver);

        landingPage.login();

//        ArticlePage articlePage = landingPage.clickFirstArticle();
//     Assert.assertEquals(articlePage.getTitleText(), "Endava");
//        assertThat("the Title was not the expected one", articlePage.getTitleText(), equalTo("Endava"));


    }

}
