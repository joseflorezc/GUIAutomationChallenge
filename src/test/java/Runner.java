
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ResultPage;
import utils.steps.Hooks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Runner extends Hooks {

    @Test
    public void successfulLogin() {

        LandingPage landingPage = new LandingPage(driver);

        LoginPage loginPage = landingPage.login();

        loginPage.fillUserName(realUsername);
        loginPage.fillPassword(realPassword);
        AccountPage accountPage = loginPage.loggingIn();

        assertThat("the User Name displayed on the account view was not the expected one", accountPage.getProfileUserName(), equalTo(realUsername));

    }

//    @Test
//    public void failingLoggingIn(){
//
//
//        LandingPage landingPage = new LandingPage(driver);
//
//        LoginPage loginPage = landingPage.login();
//
//        loginPage.fillUserName(realUsername);
//        loginPage.fillPassword(fakePassword);
//        loginPage.loggingIn();
//        loginPage.waitPresenceOfErrorStatusCardBy();
//
//        assertThat("the error status first message was not displayed or was incorrect during the login process", loginPage.firstErrorMessage()  , containsStringIgnoringCase(" We couldn't find your username"));
//        assertThat("the error status second message was not displayed or was incorrect during the login process", loginPage.secondErrorMessage()  , containsStringIgnoringCase(" remaining login attempts."));
//        assertThat("the error status text was not displayed or was incorrect during the login process", loginPage.getErrorStatusText()  , containsStringIgnoringCase(" There was a problem"));
//
//    }

    @Test
    public void searchingMovie (){
        LandingPage landingPage = new LandingPage(driver);

        landingPage.search(searchQuery);
        ResultPage resultPage = landingPage.sendSearchRequest();

        assertThat("the first Movie displayed in the search results was not the expected one", resultPage.getTitleOfFirstResultMovies()  , equalTo(searchResultTitle));
    }

    @Test
    public void verifyMovieGenre(){
        LandingPage landingPage = new LandingPage(driver);

        System.out.println("click headerMovie");
        landingPage.openingHeaderMovieMenu();
        System.out.println("openningtopRatedMovies headerMovie");
        landingPage.waitExplicitNumberOfElementsMoreThanOne();
        ResultPage resultPage = landingPage.openingTopRatedMovies();

        resultPage.openFiltersMenu();

    }

}
