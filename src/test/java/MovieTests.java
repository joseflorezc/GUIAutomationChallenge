
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.steps.Hooks;

import java.text.ParseException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MovieTests extends Hooks {


    @Test(description = "The ")
    public void searchingMovie() {
        LandingPage landingPage = new LandingPage(driver);

        landingPage.search(searchQuery);
        ResultPage resultPage = landingPage.sendSearchRequest();

        assertThat("the first Movie displayed in the search results was not the expected one", resultPage.getTitleOfFirstResultMovies(), equalTo(searchResultTitle));
    }

    @Test
    public void verifyMovieGenre() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.openingHeaderMovieMenu();

        ResultPage resultPage = landingPage.openingTopRatedMovies();
        resultPage.openFiltersMenu();
        resultPage.setActionFilterOn();
        resultPage.sendFilterPreferences();

        MediaDetailPage movieDetail = resultPage.detailMediaResult();

        assertThat("The movie selected in the top rated didn't have action among its genres", movieDetail.getActionGenreText(), equalTo(actionGenreText));

    }

    @Test
    public void validateActingTimeLine() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.openingHeaderMovieMenu();

        ResultPage resultPage = landingPage.openingTopRatedMovies();

        MediaDetailPage movieDetail = resultPage.detailOfFourthMovieOfResults();

        PersonPage personPage = movieDetail.detailPersonTopBilled();

        assertThat("The movie selected in the top rated didn't appear in the persons timeline", personPage.getTextOfMovieFromTimeLine(), equalTo(nameOfMovieOfActorTimeLine));

    }

    @Test
    public void validatingSortByDatesOnAscendingOrder() throws ParseException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.openingHeaderMovieMenu();

        ResultPage resultPage = landingPage.openingTopRatedMovies();

        resultPage.openSortingMenu();
        resultPage.selectSortingByReleaseDateAscending();

        resultPage.sendSortByPreferences();

        Assert.assertTrue(resultPage.comparingDatesOfMovies(),"The ascending order of the movies was not correct");
    }


}
