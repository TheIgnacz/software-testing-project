package team_b.vimeo.stepdefinitions;

import team_b.vimeo.config.TestConfig;
import team_b.vimeo.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.awaitility.Awaitility;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.Duration;

import static team_b.vimeo.config.TestConfig.PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestConfig.class)
public class VimeoSignupStepDefs {

    @Autowired
    private HomePage homePage;

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.navigateToHomePage();
    }

    @And("the Join header button is clicked")
    public void theJoinHeaderButtonIsClicked() {
        homePage.clickOnJoinButton();
    }

    @And("the Log in header button is clicked")
    public void theLogInHeaderButtonIsClicked() {
        homePage.clickOnLogInButton();
    }

    @When("the Join with email button is clicked")
    public void theJoinWithEmailButtonIsClicked() {
        homePage.clickOnJoinWithEmailButton();
    }

    @When("the Log in with email button is clicked")
    public void theLogInWithEmailButtonIsClicked() {
        homePage.clickOnLogInWithEmailButton();
    }

    @And("^the '(.*)' error message of the '(?:.*)' (?:field|dropdown|radio buttons|checkbox) should be shown$")
    public void theErrorMessageShouldBeShown(final String message) {
        Awaitility.await(String.format("Element was not loaded in %s seconds", PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .atMost(Duration.ofSeconds(PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .until(() -> homePage.getWebDriverFromFactory().findElements(
                                By.xpath(String.format("//div[text()=\"%s\" or ./span[text()=\"%s\"]]", message, message))
                        ).size(),
                        Matchers.is(1));
    }

    @When("the {string} is filled in with {string}")
    public void theFieldIsFilledWithParameter(final String field, final String content) {
        homePage.getInputFieldByName(field).sendKeys(content);
        homePage.waitForPageReadiness();
    }

    @When("the Tab button is pressed")
    public void theTabButtonIsPressed() {
        new Actions(homePage.getWebDriverFromFactory()).sendKeys(Keys.TAB).build().perform();
        homePage.waitForPageReadiness();
    }

    @Then("home page should be displayed")
    public void verifySuccessful(){
        Awaitility.await(String.format("Element was not loaded in %s seconds", PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS)).atMost(Duration.ofSeconds(PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS))
                .until(() -> homePage.getWebDriverFromFactory().findElements(
                                By.xpath(String.format("//*[@id=\"wrap\"]/div[2]/main/div/div/div[1]/div[1]/div/div[2]/div/div/div/div[1]/div/div/div/div[1]/div/div[1]/section/div/div[1]/div/div/div[1]/div/div/h3", "Teszt Elek"))
                        ).size(),
                        Matchers.is(1));
    }

}
