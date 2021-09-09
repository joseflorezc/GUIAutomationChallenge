
import org.testng.annotations.Test;
import pages.*;
import utils.steps.Hooks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

public class LoginTests extends Hooks {


    @Test
    public void successfulLogin() {

        LandingPage landingPage = new LandingPage(driver);

        LoginPage loginPage = landingPage.login();

        loginPage.fillUserName(realUsername);
        loginPage.fillPassword(realPassword);
        AccountPage accountPage = loginPage.loggingIn();

        assertThat("the User Name displayed on the account view was not the expected one", accountPage.getProfileUserName(), equalTo(realUsername));

    }

    @Test
    public void failingLoggingIn(){


        LandingPage landingPage = new LandingPage(driver);

        LoginPage loginPage = landingPage.login();

        loginPage.fillUserName(realUsername);
        loginPage.fillPassword(fakePassword);
        loginPage.loggingIn();
        loginPage.waitPresenceOfErrorStatusCardBy();

        assertThat("the error status text was not displayed or was incorrect during the login process", loginPage.getErrorStatusText()  , containsString("There was a problem"));
        assertThat("the error status first message was not displayed or was incorrect during the login process", loginPage.firstErrorMessage()  , containsString("We couldn't validate your information. Want to try again?"));
        assertThat("the error status second message was not displayed or was incorrect during the login process", loginPage.secondErrorMessage()  , containsString("remaining login attempts."));


    }


}
